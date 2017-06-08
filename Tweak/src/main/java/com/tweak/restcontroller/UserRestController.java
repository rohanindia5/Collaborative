package com.tweak.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tweak.modal.UserTable;

import com.tweak.service.UserService;

@RestController
public class UserRestController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public ResponseEntity<String> addUser(@RequestBody UserTable userTable)
	{
		userService.addUser(userTable);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public ResponseEntity<List<UserTable>> getUser()
	{
		List<UserTable> listblogs=userService.displayUser();
		return new ResponseEntity<List<UserTable>>(listblogs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUser-{userId}",method=RequestMethod.PUT)
	public ResponseEntity<UserTable> updateUser(@PathVariable("userId") int userId,@RequestBody UserTable userTable)
	{
		UserTable curr_user=userService.updateUser(userId);
		curr_user.setFirstName(userTable.getFirstName());
		curr_user.setLastName(userTable.getLastName());
		userService.addUser(curr_user);
		return new ResponseEntity<UserTable>(curr_user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteUser-{userId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
	{
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}

}
