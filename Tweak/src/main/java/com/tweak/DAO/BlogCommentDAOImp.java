package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.BlogComment;
import com.tweak.modal.UserTable;
@Repository
public class BlogCommentDAOImp implements BlogCommentDAO 
{

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public void addBlogComment(BlogComment blogcomment) 
	{
		sessionfactory.getCurrentSession().saveOrUpdate(blogcomment);
	}

	@Override
	public List<BlogComment> displayBlogComment() {
		List<BlogComment> list=sessionfactory.getCurrentSession().createQuery("from BlogComment").getResultList();
		return list;
	}

	@Override
	public BlogComment updateBlogComment(int blogCommentId) {
		List<BlogComment> list=sessionfactory.getCurrentSession().createQuery("from BlogComment where blogCommentId="+blogCommentId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteBlogComment(int blogCommentId) 
	{
		BlogComment blogCommentUser=new BlogComment();
		blogCommentUser.setBlogCommentId(blogCommentId);
		sessionfactory.getCurrentSession().delete(blogCommentUser);
		
	}

}
