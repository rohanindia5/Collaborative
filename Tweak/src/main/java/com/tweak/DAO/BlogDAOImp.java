package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.Blog;



@Repository
public class BlogDAOImp implements BlogDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);	
	}

	@Override
	public List<Blog> displayBlog() {
		List<Blog> list=sessionFactory.getCurrentSession().createQuery("from Blog").getResultList();
		return list;
	}

	@Override
	public Blog updateBlog(int blogId) {
		List<Blog> list=sessionFactory.getCurrentSession().createQuery("from Blog where blogId="+blogId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteBlog(int blogId) {
		Blog blogDelete=new Blog();
		blogDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogDelete);
		
	}
	
	public void updateCommentCount(int blogId,int count)
	{
		sessionFactory.getCurrentSession().createQuery("UPDATE Blog set blogComment="+count+"where blogID="+blogId).executeUpdate();
	}
	
	public void updateLikeCount(int blogId,int count)
	{
		sessionFactory.getCurrentSession().createQuery("UPDATE Blog set blogLikes="+count+"where blogID="+blogId).executeUpdate();
	}
	
	public List<Blog> getBlogOfUser(int userId)
	{
		List<Blog> list=sessionFactory.getCurrentSession().createQuery("from Blog where userId="+userId).getResultList();
		return list;
	}

}
