package lb.cnam.c2.v1.apis.utils;

import lb.cnam.c2.v1.apis.modals.responses.Response;

public class ResponseUtils {

	public final static boolean STATUS_SUCCESS = true;
	public final static boolean STATUS_ERROR = false;

	public final static int CODE_SUCCESS = 1;
	
	public static Response getSuccessResponse(Object data) {
		return Response.builder()
				.success(STATUS_SUCCESS)
				.message("SUCCESS")
				.data(data)
				.build();
	}
	
	public static Response getErrorResponse(Exception exception) {
		return Response.builder()
				.success(STATUS_ERROR)
				.message(exception.getMessage())
				.data(exception)
				.build();
	}
	
}
