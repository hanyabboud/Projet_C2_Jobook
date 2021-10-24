package lb.cnam.c2.v1.apis.exceptions.custom;

public class InvalidJobException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
    public InvalidJobException() {
		super();
	}
	
	public InvalidJobException(int jobId) {
		super("[Job] Invalid Job ID: " + jobId);
	}

}