package com.practice.MessengerApplication.Resource;

/*
 * @Author G V Kushal
 */

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.MediaType;

import com.practice.MessengerApplication.Model.Message;
import com.practice.MessengerApplication.Service.MessageService;

@Path("/message")
public class MessageResource {
	MessageService msgService = new MessageService();
	ResourceContext resourceContext;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllMessages() {
		return msgService.getMessages();
	}

	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") int msgId) {
		return msgService.getSingleMessage(msgId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message insertMessage(Message msg) {
		return msgService.insertMessage(msg);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message msg) {
		return msgService.updateMessage(msg);
	}

	@DELETE
	@Path("{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("messageId") int msgId) {
		return msgService.deleteMessage(msgId);
	}

	@Path("/{messageId}/comment")
	public CommentResource getComment() {
		return new CommentResource();
	}
}
