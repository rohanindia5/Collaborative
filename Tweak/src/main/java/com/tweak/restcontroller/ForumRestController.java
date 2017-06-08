package com.tweak.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tweak.modal.Forum;
import com.tweak.service.ForumService;

@RestController
public class ForumRestController 
{
	@Autowired
	ForumService forumService;
	
	@RequestMapping(value="/addForum",method=RequestMethod.PUT)
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setForumDate(new Date());
		forum.setForumLikes(0);
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
}
