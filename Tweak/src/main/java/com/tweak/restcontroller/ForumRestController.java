package com.tweak.restcontroller;

import java.util.Date;
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

import com.tweak.modal.Blog;
import com.tweak.modal.ForumLike;
import com.tweak.modal.Forum;
import com.tweak.service.ForumLikeService;
import com.tweak.service.ForumService;
import com.tweak.service.UserService;

@RestController
public class ForumRestController 
{
	@Autowired
	ForumService forumService;
	@Autowired
	UserService userService;
	@Autowired
	ForumLikeService forumLikeService;
	
	@RequestMapping(value="/addForum",method=RequestMethod.POST)
	public ResponseEntity<String> addForum(@RequestBody Forum forum,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();		
		forum.setForumDate(new Date());
		forum.setForumLikes(0);
		forum.setUserId(currentuserid);
		forumService.addForum(forum);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getForum",method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> getForum()
	{
		List<Forum> listforum=forumService.displayForum();
		return new ResponseEntity<List<Forum>>(listforum,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateForum-{forumId}",method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateBlog(@PathVariable("forumId") int forumId,@RequestBody Forum forum)
	{
		Forum curr_forum=forumService.updateForum(forumId);
		curr_forum.setForumName(forum.getForumName());
		curr_forum.setForumContent(forum.getForumContent());
		forumService.addForum(curr_forum);
		return new ResponseEntity<Forum>(curr_forum,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteForum-{forumId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBlog(@PathVariable("forumId") int forumId)
	{
		forumService.deleteForum(forumId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getForumDetails/{forumId}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getAForum(@PathVariable("forumId") int forumId,HttpSession session)
	{
		
		System.out.println("getting forum details");
		Forum forum=forumService.updateForum(forumId);
		session.setAttribute("forumIdDetails", forumId);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addForumLike",method=RequestMethod.POST)
	public ResponseEntity<String> addForumLike(@RequestBody ForumLike forumLike,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		int currentforumDetail=(int)session.getAttribute("forumIdDetails");
		try{
			ForumLike like=forumLikeService.getForumLike(currentuserid, currentforumDetail);
			return new ResponseEntity<String>("failed Liked",HttpStatus.OK);
		}
		catch (Exception e) {
			forumLike.setUserId(currentuserid);
			forumLike.setForumId(currentforumDetail);
			forumLikeService.addLike(forumLike);
			int currentlikecount=forumService.updateForum(currentforumDetail).getForumLikes();
			currentlikecount=currentlikecount+1;
			forumService.updateLikeCount(currentlikecount,currentforumDetail);
			return new ResponseEntity<String>("Success Liked",HttpStatus.OK);
			
		}
		
	}
	
	@RequestMapping(value="/getForumOfUser",method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> getForumOfUser(HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		List<Forum> list=forumService.getForumOfUser(currentuserid);
		return new ResponseEntity<List<Forum>>(list,HttpStatus.OK);
	}
}
