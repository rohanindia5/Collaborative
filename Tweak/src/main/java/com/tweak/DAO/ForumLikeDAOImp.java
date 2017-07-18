package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.BlogLike;
import com.tweak.modal.ForumLike;

@Repository
public class ForumLikeDAOImp implements ForumLikeDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addLike(ForumLike forumLike) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(forumLike);
		
	}
	
	public ForumLike getForumLike(int userId,int forumId)
	{
		List<ForumLike> list=sessionFactory.getCurrentSession().createQuery("from ForumLike where userId="+userId+"and forumId="+forumId).getResultList();
		return list.get(0);
	}
}
