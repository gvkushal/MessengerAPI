package com.practice.MessengerApplication.Service;

import java.util.Date;
import java.util.List;

import com.practice.MessengerApplication.ClassDAO.MessageDAO;
import com.practice.MessengerApplication.Model.Message;

public class MessageService {

	MessageDAO mDAO = new MessageDAO();

	public List getMessages() {
		return mDAO.getAllMessagesDAO();

	}

	public Message insertMessage(Message msg) {
		msg.setCreatedDate(new Date());
		return mDAO.insertMessageDAO(msg);
	}

	public Message updateMessage(Message msg) {
		msg.setCreatedDate(new Date());
		return mDAO.updateMessageDAO(msg);
	}

	public String deleteMessage(int msgId) {
		return mDAO.deleteMessageDAO(msgId);
	}

	public Message getSingleMessage(int msgId) {
		return mDAO.getSingleMessageDAO(msgId);

	}
}