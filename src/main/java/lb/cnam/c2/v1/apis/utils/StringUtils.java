package lb.cnam.c2.v1.apis.utils;

import lb.cnam.c2.v1.apis.exceptions.global.TypeParsingException;

public class StringUtils {

	public static int parseInt(String in) {
		// Initiate Return Value
		int out;

		// Throw exception on parsing error
		try {
			// Parse to Integer
			out = Integer.parseInt(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TypeParsingException(String.class, Integer.class, in);
		}

		// Return Integer Value
		return out;
	}

}
