package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.ForumCommentDAOImp;
import com.tweak.modal.ForumComment;

@Service
@Transactional
public class ForumCommentService 
{
	@Autowired
	ForumCommentDAOImp forumCommentDAOImp;
	public void addForumComment(ForumComment forumComment)
	{
		forumCommentDAOImp.addForumComment(forumComment);
	}
	public List<ForumComment> displayForumComment(int forumId)
	{
		return forumCommentDAOImp.displayForumComment(forumId);
	}
	public ForumComment updateForumComment(int forumCommentId)
	{
		return forumCommentDAOImp.updateForumComment(forumCommentId);
	}
	public void deleteForumComment(int forumCommentId)
	{
		forumCommentDAOImp.deleteForumComment(forumCommentId);
	}
}
