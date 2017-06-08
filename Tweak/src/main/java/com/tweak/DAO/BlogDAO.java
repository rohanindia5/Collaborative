package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.Blog;

public interface BlogDAO 
{
	public void addBlog(Blog blog);
	public List<Blog> displayBlog();
	public Blog updateBlog(int blogId);
	public void deleteBlog(int blogId);
}
