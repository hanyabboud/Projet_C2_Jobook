package lb.cnam.c2.v1.apis.exceptions.custom;

public class TestException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public TestException() {
		super();
	}
	
	public TestException(String message) {
		super("[TEST]" + message);
	}

}