package com.tweak.restcontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.tweak.modal.Blog;
import com.tweak.modal.UserTable;

import com.tweak.service.UserService;

@RestController
public class UserRestController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody UserTable userTable)
	{
		userService.addUser(userTable);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public ResponseEntity<List<UserTable>> getUser(HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		List<UserTable> listblogs=userService.displayUser(currentuserid);
		return new ResponseEntity<List<UserTable>>(listblogs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUser-{userId}",method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateUser(@PathVariable("userId") int userId,@RequestBody UserTable userTable)
	{
		UserTable curr_user=userService.updateUser(userId);
		curr_user.setUserFirstName(userTable.getUserFirstName());
		curr_user.setUserLastName(userTable.getUserLastName());
		userService.addUser(curr_user);
		return new ResponseEntity<UserTable>(curr_user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteUser-{userId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
	{
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value="/authenticateuser", method=RequestMethod.POST)
	public ResponseEntity<UserTable> authenticateUsers(@RequestBody UserTable usercred, HttpSession httpSession)
	{
		UserTable usercredobj = userService.authenticateUser(usercred.getUserName(), usercred.getPassword());
		
			httpSession.setAttribute("loggedInUser", usercredobj.getUserName());
			httpSession.setAttribute("loggedInUserRole", usercredobj.getUserRole());
			//friendDAO.setOnline(usercredobj.getUsername());
			
		return new ResponseEntity<UserTable>(usercredobj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ResponseEntity<String> logoutUser(HttpSession httpSession)
	{
		String username = (String) httpSession.getAttribute("loggedInUser");
		httpSession.invalidate();
		return new ResponseEntity<String>("Succesfullyloggedout", HttpStatus.OK);
	}
	
	
	@RequestMapping(value= "/userUpload", method = RequestMethod.POST)
	public ResponseEntity<String> addUserPicture(@RequestParam(value="file")MultipartFile file,UriComponentsBuilder builder,UserTable user,HttpSession session)
	{
	      File newFile;
     		String path = "D:\\Projects\\TweakFrontEnd\\WebContent\\resources\\image\\";
     		String currentusername=(String) session.getAttribute("loggedInUser");
     		int currentuserid=userService.getUserByName(currentusername).getUserId();
     		path = path+"user"+currentuserid+".jpg";
     		newFile = new File(path);
     		System.out.println(path);
     		
     		if(!file.isEmpty())
     		{
     			try {
     				byte[] bytes = file.getBytes();
     				FileOutputStream fos = new FileOutputStream(newFile);
     				BufferedOutputStream bos = new BufferedOutputStream(fos);
     				bos.write(bytes);
     				bos.close();
     			} catch (IOException e) {
     				// TODO Auto-generated catch block
     				System.out.println("exception occured"+e);
     			}			
     		}
     		else{
     				System.out.println("No file selected");
     		}
     		
             return new ResponseEntity<String>("sucessfully uploaded image", HttpStatus.CREATED);	
	}

}
