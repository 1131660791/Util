package util.encryption.unicode;

/**
 * 编码工具
 * @author hzw
 */
public class EncodeUtil {
	
	/**
	 * 将字符串 转为unicode 编码
	 * @param string
	 * @return
	 */
	public static String stringToUnicode(String string) {
	    StringBuffer unicode = new StringBuffer();
	    for (int i = 0; i < string.length(); i++) {
	        // 取出每一个字符
	        char c = string.charAt(i);
	        // 转换为unicode
	        unicode.append("\\u" + Integer.toHexString(c));
	    }
	    return unicode.toString();
	}

	/**
	 * unicode 转字符串
	 */
	public static String unicodeToString(String unicode) {
	 
	    StringBuffer string = new StringBuffer();
	    String[] hex = unicode.split("\\\\u");
	    for (int i = 1; i < hex.length; i++) {
	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i], 16);
	        // 追加成string
	        string.append((char) data);
	    }
	    return string.toString();
	}

	
	public static void main(String[] args) {
		String s = stringToUnicode("{dd:扫扫地}");
		String d = unicodeToString(s);
		System.out.println(d);
	}

}
