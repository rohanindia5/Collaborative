package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.BlogDAOImp;
import com.tweak.modal.Blog;

@Service
@Transactional
public class BlogService 
{
	@Autowired
	BlogDAOImp blogDAOImp;
	public void addBlog(Blog blog)
	{
		blogDAOImp.addBlog(blog);
	}
	public List<Blog> displayBlog()
	{
		return blogDAOImp.displayBlog();
	}
	public Blog updateBlog(int blogId)
	{
		return blogDAOImp.updateBlog(blogId);
	}
	public void deleteBlog(int blogId)
	{
		blogDAOImp.deleteBlog(blogId);
	}
	public void updateCommentCount(int blogId,int count)
	{
		blogDAOImp.updateCommentCount(blogId, count);
	}
	public void updateLikeCount(int blogId,int count)
	{
		blogDAOImp.updateLikeCount(blogId, count);
	}
	public List<Blog> getBlogOfUser(int userId)
	{
		return blogDAOImp.getBlogOfUser(userId);
	}
}
