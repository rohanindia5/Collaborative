package com.tweak.restcontroller;


import java.util.*;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweak.modal.Blog;

import com.tweak.service.BlogService;
import com.tweak.service.UserService;

@RestController
public class BlogRestController 
{
	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<String> addBlog(@RequestBody Blog blog,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		blog.setBlogDate(new Date());
		blog.setBlogLikes(0);
		blog.setUserId(currentuserid);
		blogService.addBlog(blog);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBlog",method=RequestMethod.GET)
	public ResponseEntity<List<Blog>> getUser()
	{
		List<Blog> listblogs=blogService.displayBlog();
		return new ResponseEntity<List<Blog>>(listblogs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateBlog/{blogId}",method=RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("blogId") int blogId,@RequestBody Blog blog)
	{
		Blog curr_blog=blogService.updateBlog(blogId);
		curr_blog.setBlogName(blog.getBlogName());
		curr_blog.setBlogContent(blog.getBlogContent());
		blogService.addBlog(curr_blog);
		return new ResponseEntity<Blog>(curr_blog,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteBlog/{blogId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId)
	{
		blogService.deleteBlog(blogId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBlogDetails/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getABlog(@PathVariable("blogId") int blogId)
	{
		System.out.println("getting blog details");
		Blog blog=blogService.updateBlog(blogId);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
}
