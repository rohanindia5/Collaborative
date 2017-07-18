package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.BlogCommentDAOImp;
import com.tweak.modal.BlogComment;

@Service
@Transactional

public class BlogCommentService 
{
	@Autowired
	BlogCommentDAOImp blogCommentDAOImp;
	public void addBlogComment(BlogComment blogcomment)
	{
		blogCommentDAOImp.addBlogComment(blogcomment);
	}
	public List<BlogComment> displayBlogComment(int blogId)
	{
		return blogCommentDAOImp.displayBlogComment(blogId);
	}
	public BlogComment updateBlogComment(int blogCommentId)
	{
		return blogCommentDAOImp.updateBlogComment(blogCommentId);
	}
	public void deleteBlogComment(int blogCommentId)
	{
		blogCommentDAOImp.deleteBlogComment(blogCommentId);
	}
}
