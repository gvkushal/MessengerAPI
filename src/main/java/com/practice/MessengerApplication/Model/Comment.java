package com.practice.MessengerApplication.Model;

/*
 * @Author G V Kushal
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	private Message message;
	private String commentInfo;

	public Comment(){
		
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Comment(String commentInfo) {
		super();
		this.commentInfo = commentInfo;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	public Message getMessage() {
		return message;
	}

	/*
	 * public Message getMessage() { return message; }
	 * 
	 * public void setMessage(Message message) { this.message = message; }
	 */
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentInfo=" + commentInfo + "]";
	}

}
