package fr.net.asclepiosh.outilcalculgreve.util;

/**
 * Helper functions for check whether the string received is able to convert to numeric or float.
 *
 * @author Niolas Torres
 */
public class StringUtil {

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			// Not a numeric
			return false;
		}
	}


	public static boolean isFloat(String str) {

		try {
			Float.parseFloat(str);
			return true;
		} catch (NumberFormatException e) {
			// Not a float
			return false;
		}
	}

}
