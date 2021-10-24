package lb.cnam.c2.v1.apis.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import lb.cnam.c2.v1.apis.exceptions.global.MissingFieldException;

public class RequestUtils {

	public static Object checkBodyField(Class<?> type, JSONObject body, String field) {
		// Check body if null
		if(body == null) throw new MissingFieldException(field);
		
		// Initiate Field Value
		Object out = null;
		
		// Init Type Conditions
		boolean condForInteger = type == Integer.class;
		boolean condForString = type == String.class;
		boolean condForBoolean = type == Boolean.class;
		boolean condForJSONObject = type == JSONObject.class;
		boolean condForJSONArray = type == JSONArray.class;
				
		// Throw missing field exception on missing field
		try {
			// Check if field exists
			if(body.has(field)) {
				// Check field type to fetch the value accordingly
				if(condForInteger) out = body.getInt(field);
				else if(condForString) out = body.getString(field);
				else if(condForBoolean) out = body.getBoolean(field);
				else if(condForJSONObject) out = body.getJSONObject(field);
				else if(condForJSONArray) {
					if(body.getJSONArray(field).length() > 0 && body.getJSONArray(field).getJSONObject(0) != null)
						out = body.getJSONArray(field);
				}
//				else if(condForJSONArray) out = body.getJSONArray(field);
			} else {
				throw new MissingFieldException(field);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new MissingFieldException(field);
		}
		
		// Return field value
		return out;
	}
	
	public static Object checkResponseField(Class<?> type, JSONObject body, String field, boolean required) {
		// Check body if null
		if(body == null) return null;
		
		// Initiate Field Value
		Object out = null;

		// Init Type Conditions
		boolean condForInteger = type == Integer.class;
		boolean condForString = type == String.class;
		boolean condForBoolean = type == Boolean.class;
		boolean condForJSONObject = type == JSONObject.class;
		boolean condForJSONArray = type == JSONArray.class;
		
		try {
			// Check if field exists
			if(body.has(field)) {
				// Check field type to fetch the value accordingly
				if(condForInteger) out = body.getInt(field);
				else if(condForString) out = body.getString(field);
				else if(condForBoolean) out = body.getBoolean(field);
				else if(condForJSONObject) out = body.getJSONObject(field);
				else if(condForJSONArray) {
					if(body.getJSONArray(field).length() > 0 && body.getJSONArray(field).getJSONObject(0) != null)
						out = body.getJSONArray(field);
				}
			} else {
				if(required) throw new MissingFieldException(field);
			}
		} catch(Exception e) {
			e.printStackTrace();
			if(required) throw new MissingFieldException(field);
		}
		
		// Return field value
		return out;
	}
	
}
