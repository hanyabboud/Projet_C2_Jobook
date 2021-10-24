package lb.cnam.c2.v1.apis.exceptions.custom;

public class InvalidUserException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public InvalidUserException() {
		super();
	}
	
	public InvalidUserException(int userId) {
		super("[User] Invalid User ID: " + userId);
	}

}