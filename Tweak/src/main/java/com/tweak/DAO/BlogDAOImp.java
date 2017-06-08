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
		List<Blog> list=sessionFactory.getCurrentSession().createQuery("from Blog where blogId"+blogId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteBlog(int blogId) {
		Blog blogDelete=new Blog();
		blogDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogDelete);
		
	}

}
