package com.tweak.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweak.modal.Friends;

import com.tweak.service.FriendsService;
import com.tweak.service.UserService;

@RestController
public class FriendsRestController 
{
	@Autowired
	FriendsService friendsService;
	@Autowired
	UserService userService;
	


	@RequestMapping(value="/addFriend/{friendsUserId}",method=RequestMethod.GET)
	public ResponseEntity<String> addUser(@RequestBody Friends friends,HttpSession session,@PathVariable("friendsUserId")int friendsUserId)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		friends.setFriendsUserId(friendsUserId);
		friends.setUserId(currentuserid);
		friends.setStatus("Requested");
		friendsService.addFriends(friends);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getFriends",method=RequestMethod.GET)
	public ResponseEntity<List<Friends>> getFriends()
	{
		List<Friends> listblogs=friendsService.displayFriends();
		return new ResponseEntity<List<Friends>>(listblogs,HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/updateFriends-{friendsId}",method=RequestMethod.PUT)
	public ResponseEntity<Friends> updateUser(@PathVariable("friendsId") int friendsId,@RequestBody Friends friends)
	{
		Friends curr_friends=friendsService.updateFriends(friendsId);
		
		return new ResponseEntity<UserTable>(curr_user,HttpStatus.OK);
	}*/
	
	@RequestMapping(value="/deleteFriend-{friendId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteFriend(@PathVariable("friendId") int friendId)
	{
		friendsService.deletefriends(friendId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}

}
