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


import com.tweak.modal.ForumComment;
import com.tweak.service.ForumCommentService;
import com.tweak.service.ForumService;
import com.tweak.service.UserService;


@RestController
public class ForumCommentRestController 
{
	@Autowired
	ForumCommentService forumCommentService;
	@Autowired
	UserService userService;
	@Autowired
	ForumService forumService;
	
	@RequestMapping(value="/addForumComment",method=RequestMethod.POST)
	public ResponseEntity<String> addForumComment(@RequestBody ForumComment forumComment,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		int currentforumDetail=(int)session.getAttribute("forumIdDetails");
		forumComment.setForumCommentDate(new Date());
		forumComment.setUserId(currentuserid);
		forumComment.setForumId(currentforumDetail);
		forumCommentService.addForumComment(forumComment);
		int currentcommentcount=forumService.updateForum(currentforumDetail).getForumComment();
		currentcommentcount=currentcommentcount+1;
		forumService.updateCommentCount(currentcommentcount, currentforumDetail);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getForumComment",method=RequestMethod.GET)
	public ResponseEntity<List<ForumComment>> getUser(HttpSession session)
	{
		int currentforumDetail=(int)session.getAttribute("forumIdDetails");
		List<ForumComment> listforumscomment=forumCommentService.displayForumComment(currentforumDetail);
		return new ResponseEntity<List<ForumComment>>(listforumscomment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateForumComment-{forumCommentId}",method=RequestMethod.PUT)
	public ResponseEntity<ForumComment> updateForumComment(@PathVariable("forumCommentId") int forumCommentId,@RequestBody ForumComment forumComment)
	{
		ForumComment curr_forumcomment=forumCommentService.updateForumComment(forumCommentId);
		curr_forumcomment.setForumCommentContext(forumComment.getForumCommentContext());
		forumCommentService.addForumComment(curr_forumcomment);
		return new ResponseEntity<ForumComment>(curr_forumcomment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteForumComment-{forumCommentId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteForumComment(@PathVariable("forumCommentId") int forumCommentId)
	{
		forumCommentService.deleteForumComment(forumCommentId);
		return new ResponseEntity<String>("Deleted Forum Successfully",HttpStatus.OK);
	}
	
	
}
