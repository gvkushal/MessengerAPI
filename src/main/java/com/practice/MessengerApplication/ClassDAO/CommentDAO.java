package com.practice.MessengerApplication.ClassDAO;

/*
 * @Author G V Kushal
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.MessengerApplication.Model.Comment;
import com.practice.MessengerApplication.Model.Message;

public class CommentDAO {

	Configuration con = new Configuration().configure().addAnnotatedClass(Message.class)
			.addAnnotatedClass(Comment.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tns = session.beginTransaction();

	// Getting single comment.
	public Comment getSingleComment(int msgId, int commentId) {
		Query query = session.createQuery("from Comment where message_messageId= :msgId and commentId = :cmtId");
		query.setParameter("msgId", msgId);
		query.setParameter("cmtId", commentId);
		Comment comment = (Comment) query.getSingleResult();
		System.out.println(comment);
		return comment;
	}

	// Getting All comments
	public List getAllCommentsDAO(int msgId) {
		Query qry = session.createQuery("from Comment where message_messageId= :messageId");
		qry.setParameter("messageId", msgId);
		List<Comment> comments = (List<Comment>) qry.getResultList();
		return comments;
	}

	// Inserting Comment
	public String insertCommentDAO(Comment comment) {
		System.out.println("Comment DAO called..!!");
		session.save(comment);
		tns.commit();
		return "Inserted successfully..!!";
	}

	// Updating Comment
	public String updateCommentDAO(Comment comment) {
		session.update(comment);
		tns.commit();
		return "Updat DAO";
	}

	// Delete Comment
	public String deletecommentDAO(int msgId, int commentId) {
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		session.delete(comment);
		tns.commit();
		return "Deleted";
	}

}
