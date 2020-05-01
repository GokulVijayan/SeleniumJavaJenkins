package genericComponents;



public class ReusableComponents {

	/**
	 * Compare text1 and text2.Returns true if both texts match and return false otherwise
	 * @param text1
	 * @param text2
	 * @return
	 * @throws Exception 
	 */
	public static boolean CompareText(String text1, String text2) {
		try {
			text1 = text1.trim().replaceAll("^\\s+","").replaceAll("\\s++$", "");
			text2 = text2.trim().replaceAll("^\\s+","");
			int result = (text1).compareToIgnoreCase(text2);
			if(result == 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("Text comparison failed");
			throw (e);
		}
	}
	
	/**
	 * Return true if text1 contains text - text2 and flase otherwise
	 * @param text1
	 * @param text2
	 * @return
	 */
	public static boolean ContainsText(String text1, String text2) {
		try {
			text1 = text1.trim().replaceAll("^\\s+","").replaceAll("\\s++$", "");
			text2 = text2.trim().replaceAll("^\\s+","");
			boolean result = (text1).contains(text2);
			return result;
			
		} catch (Exception e) {
			System.out.println("Text comparison failed");
			throw (e);
		}
	}


}
