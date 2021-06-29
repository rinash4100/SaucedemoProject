package infra;

/**
 * This class is designed for functions that handle strings and are repeated
 * several times
 */

public class StringUtility {

	public static double getPriceFromString(String price) {
		price = price.replaceAll("[^0-9?!\\.]", "");
		return Double.parseDouble(price);
	}
}
