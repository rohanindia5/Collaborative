package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.ForumComment;


@Repository
public class ForumCommentDAOImp implements ForumCommentDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addForumComment(ForumComment forumComment) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
	}

	@Override
	public List<ForumComment> displayForumComment(int forumId) {
		List<ForumComment> list=sessionFactory.getCurrentSession().createQuery("from ForumComment where forumId="+forumId).getResultList();
		return list;
	}

	@Override
	public ForumComment updateForumComment(int forumCommentId) {
		List<ForumComment> list=sessionFactory.getCurrentSession().createQuery("from ForumComment where forumCommentId="+forumCommentId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteForumComment(int forumCommentId) {
		ForumComment forumCommentDelete=new ForumComment();
		forumCommentDelete.setForumCommentId(forumCommentId);
		sessionFactory.getCurrentSession().delete(forumCommentDelete);
		
	}	
}
