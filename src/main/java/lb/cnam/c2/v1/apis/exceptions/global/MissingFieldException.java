package lb.cnam.c2.v1.apis.exceptions.global;

public class MissingFieldException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public MissingFieldException() {
		super();
	}
	
	public MissingFieldException(String field) {
		super("Missing Required Field: " + field);
	}

}