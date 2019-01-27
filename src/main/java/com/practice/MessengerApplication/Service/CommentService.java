package com.practice.MessengerApplication.Service;

/*
 * @Author G V Kushal
 */

import java.util.List;

import com.practice.MessengerApplication.ClassDAO.CommentDAO;
import com.practice.MessengerApplication.Model.Comment;

public class CommentService {

	CommentDAO cDAO = new CommentDAO();

	public Comment getSingleComment(int msgId, int commentId) {
		return cDAO.getSingleComment(msgId, commentId);
	}

	public List getAllComments(int msgId) {
		return cDAO.getAllCommentsDAO(msgId);
	}

	public String insertComment(Comment comment, int msgId) {
		MessageService msgService = new MessageService();
		System.out.println(comment.getMessage());
		comment.setMessage(msgService.getSingleMessage(msgId));
		return cDAO.insertCommentDAO(comment);
	}

	public String updateComment(int msgId, Comment comment) {
		MessageService msgService = new MessageService();
		comment.setMessage(msgService.getSingleMessage(msgId));
		return cDAO.updateCommentDAO(comment);
	}

	public String deleteComment(int msgId, int commentId) {
		return cDAO.deletecommentDAO(msgId, commentId);
	}

}
