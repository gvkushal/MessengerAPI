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
import javax.ws.rs.core.MediaType;

import com.practice.MessengerApplication.Model.Comment;
import com.practice.MessengerApplication.Service.CommentService;

@Path("/")
public class CommentResource {

		//As this CommentResource is a child of MessageResource messageId path param will be available to child also.
	
	CommentService cmtService = new CommentService();

	@GET
	@Path("{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("messageId") int msgId, @PathParam("commentId") int commentId) {
		return cmtService.getSingleComment(msgId, commentId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageId") int msgId) {
		return cmtService.getAllComments(msgId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertComment(@PathParam("messageId") int msgId, Comment comment) {
		System.out.println("I am in");
		return cmtService.insertComment(comment, msgId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateComment(@PathParam("messageId") int msgId, Comment comment) {
		return cmtService.updateComment(msgId, comment);
	}

	@DELETE
	@Path("{commentId}")
	public String deleteComment(@PathParam("messageId") int msgId, @PathParam("commentId") int commentId) {
		return cmtService.deleteComment(msgId, commentId);
	}
}
