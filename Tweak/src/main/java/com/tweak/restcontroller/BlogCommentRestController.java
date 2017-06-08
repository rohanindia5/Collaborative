package com.tweak.restcontroller;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tweak.modal.BlogComment;
import com.tweak.service.BlogCommentService;

@RestController
public class BlogCommentRestController 
{
	@Autowired
	BlogCommentService blogCommentService;
	
	@RequestMapping(value="/addBlogComment",method=RequestMethod.PUT)
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment)
	{
		blogComment.setBlogCommentDate(new Date());
		blogCommentService.addBlogComment(blogComment);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBlogComment",method=RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getUser()
	{
		List<BlogComment> listblogscomment=blogCommentService.displayBlogComment();
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
