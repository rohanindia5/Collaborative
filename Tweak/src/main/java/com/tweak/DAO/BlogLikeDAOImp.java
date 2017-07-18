package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.BlogLike;



@Repository
public class BlogLikeDAOImp implements BlogLikeDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addLike(BlogLike blogLike) {
	sessionFactory.getCurrentSession().saveOrUpdate(blogLike);
		
	}
	
	public BlogLike getLike(int userId,int blogId)
	{
		List<BlogLike> list=sessionFactory.getCurrentSession().createQuery("from BlogLike where userId="+userId+"and blogId="+blogId).getResultList();
		return list.get(0);
	}

	
	
}
