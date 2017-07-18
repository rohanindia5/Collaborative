package com.tweak.restcontroller;

import java.util.*;
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
import com.tweak.modal.BlogComment;
import com.tweak.modal.UserTable;
import com.tweak.service.BlogCommentService;
import com.tweak.service.BlogService;
import com.tweak.service.UserService;

@RestController
public class BlogCommentRestController 
{
	@Autowired
	BlogCommentService blogCommentService;
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/addBlogComment",method=RequestMethod.POST)
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		int currentblogDetail=(int)session.getAttribute("blogIdDetails");
		blogComment.setBlogCommentDate(new Date());
		blogComment.setUserId(currentuserid);
		blogComment.setBlogId(currentblogDetail);
		blogCommentService.addBlogComment(blogComment);
		int commentcount=blogService.updateBlog(currentblogDetail).getBlogComment();
		commentcount=commentcount+1;
		blogService.updateCommentCount(currentblogDetail, commentcount);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBlogComment",method=RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getUser(HttpSession session)
	{
		int currentblogDetail=(int)session.getAttribute("blogIdDetails");
		List<BlogComment> listblogscomment=blogCommentService.displayBlogComment(currentblogDetail);
		return new ResponseEntity<List<BlogComment>>(listblogscomment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateBlogComment-{blogCommentId}",method=RequestMethod.PUT)
	public ResponseEntity<BlogComment> updateBlogComment(@PathVariable("blogCommentId") int blogCommentId,@RequestBody BlogComment blogComment)
	{
		BlogComment curr_blogcomment=blogCommentService.updateBlogComment(blogCommentId);
		curr_blogcomment.setBlogCommentContext(blogComment.getBlogCommentContext());
		blogCommentService.addBlogComment(curr_blogcomment);
		return new ResponseEntity<BlogComment>(curr_blogcomment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteBlogComment-{blogCommentId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBlogComment(@PathVariable("blogCommentId") int blogCommentId)
	{
		blogCommentService.deleteBlogComment(blogCommentId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}
}
