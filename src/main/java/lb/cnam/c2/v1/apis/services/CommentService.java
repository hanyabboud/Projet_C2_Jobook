package lb.cnam.c2.v1.apis.services;

import java.util.HashMap;
import java.util.List;

import lb.cnam.c2.v1.apis.entities.CommentEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;

public interface CommentService {
	
	public Response addComment(int jobId, int userId, CommentEntity comment);
	
	public HashMap<Integer, List<CommentEntity>> fetchCommentsMapByUserId(int userId);

	public Response deleteComment(int commentId);

}