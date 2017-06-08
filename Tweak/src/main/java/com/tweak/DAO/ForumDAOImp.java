package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.Forum;
@Repository
public class ForumDAOImp implements ForumDAO 
{
	@Autowired
	SessionFactory sessionFactory;
		
	@Override
	public void addForum(Forum forum) 
	{
		sessionFactory.getCurrentSession().save(forum);
		
	}

	@Override
	public List<Forum> displayForum() {
		List<Forum> list=sessionFactory.getCurrentSession().createQuery("from Forum").getResultList();
		return list;
	}

	@Override
	public Forum updateForum(int forumId) {
		List<Forum> list=sessionFactory.getCurrentSession().createQuery("from Forum where forumId="+forumId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteForum(int forumId) {
		Forum forumDelete=new Forum();
		forumDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumDelete);
	}

}
