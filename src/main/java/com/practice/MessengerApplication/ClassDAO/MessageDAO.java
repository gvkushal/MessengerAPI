package com.practice.MessengerApplication.ClassDAO;

/*
 * @Author G V Kushal
 */

import java.util.List;

import javax.persistence.FlushModeType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.MessengerApplication.Model.Message;

public class MessageDAO {

	// Setting Hibernate configuration to get session Object.
	Configuration con = new Configuration().configure().addAnnotatedClass(Message.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tns = session.beginTransaction();

	// Getting Single Message
	public Message getSingleMessageDAO(int msgId) {
		return (Message) session.get(Message.class, msgId);
	}

	// Getting All Messages
	public List<Message> getAllMessagesDAO() {
		Query q = session.createQuery("from Message");
		List<Message> messages = (List<Message>) q.getResultList();
		return messages;
	}

	// Inserting a new message
	public Message insertMessageDAO(Message msg) {
		session.save(msg);
		tns.commit();
		return msg;
	}

	// updating existing message
	public Message updateMessageDAO(Message msg) {
		session.update(msg);
		tns.commit();
		return msg;
	}

	// Deleting existing message
	public String deleteMessageDAO(int msgId) {
		Message message = new Message();
		message.setMessageId(msgId);
		session.delete(message);
		tns.commit();
		return "!!....Deleted Successfully..!!";
	}

}
