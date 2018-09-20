package src.com.Java;

//Z字形将多个字符拼接一个字符串

public class _006_ZigZag_Conversion_Z字形将多个字符拼接一个字符串 {

	public String convert(String s, int nRows) {
		char c[] = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		// creating objects
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) 		// vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--) 	// obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}

}