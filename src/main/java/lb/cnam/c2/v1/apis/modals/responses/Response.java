package lb.cnam.c2.v1.apis.modals.responses;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Response {

	private final String version = "1.0.0";
	
	private boolean success;
	
	private String message;
	
	private Object data;
	
	public Response(boolean success, String message, Object data) {
		this.success =  success;
		this.message =  message;
		this.data =  data;
	}
	
	public Response(boolean success, String message) {
		this.success =  success;
		this.message =  message;
		this.data =  null;
	}
	
}
