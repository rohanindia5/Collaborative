package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.BlogComment;

public interface BlogCommentDAO 
{
	public void addBlogComment(BlogComment blogcomment);
	public List<BlogComment> displayBlogComment();
	public BlogComment updateBlogComment(int blogCommentId);
	public void deleteBlogComment(int blogCommentId);
}
