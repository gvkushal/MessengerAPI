package com.practice.MessengerApplication.Model;

/*
 * @Author G V Kushal
 */

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;
	private String messageInfo;
	private Date createdDate;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "Message_Comment_Id")
	private List<Comment> comment;

	public Message() {
	}

	public Message(String messageInfo) {
		super();
		this.messageInfo = messageInfo;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	/*
	 * public List<Comment> getComment() { return comment; } public void
	 * setComment(List<Comment> comment) { this.comment = comment; }
	 */
	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageInfo=" + messageInfo + ", createdDate=" + createdDate
				+ "]";
	}

}
