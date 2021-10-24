package lb.cnam.c2.v1.apis.exceptions.global;

public class TypeParsingException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public TypeParsingException() {
		super();
	}
	
	public TypeParsingException(Class<?> classFrom, Class<?> classTo, String value) {
		super("Error parsing from '" + classFrom.getName() + "' to '" + classTo.getName() + "' for the value '" + value + "'.");
	}

}