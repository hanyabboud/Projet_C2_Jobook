package lb.cnam.c2.v1.apis.adapter;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResultSetAdapter {

	public static JSONArray build(ResultSet in) {
		try {
			ResultSetMetaData rsmd = in.getMetaData();
			
			JSONArray out = new JSONArray();
			while (in.next()) {
				JSONObject jsonObject = new JSONObject();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					jsonObject.put(rsmd.getColumnName(i), in.getString(i));
				}
				out.put(jsonObject); 
			}
			return out;
		} catch (Exception e) {
			return new JSONArray();
		}
	}
	
}
