package lb.cnam.c2.v1.apis.exceptions.custom;

public class InvalidCommentException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public InvalidCommentException() {
		super();
	}
	
	public InvalidCommentException(int commentId) {
		super("[Comment] Invalid Comment ID: " + commentId);
	}

}