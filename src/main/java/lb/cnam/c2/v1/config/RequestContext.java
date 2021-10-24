package lb.cnam.c2.v1.config;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RequestContext {
	
	private JSONObject jsonBody;

	public JSONObject getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(JSONObject jsonBody) {
		this.jsonBody = jsonBody;
	}
}