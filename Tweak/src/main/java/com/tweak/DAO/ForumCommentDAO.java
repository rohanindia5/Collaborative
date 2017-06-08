package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.ForumComment;
public interface ForumCommentDAO 
{
	public void addForumComment(ForumComment forumComment);
	public List<ForumComment> displayForumComment();
	public ForumComment updateForumComment(int forumCommentId);
	public void deleteForumComment(int forumCommentId);
}
