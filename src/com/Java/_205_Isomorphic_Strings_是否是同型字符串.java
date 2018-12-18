package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/** 
* @author  suzw
* @version 创建时间：2018年9月5日 上午11:17:57 
* 类说明 
* 测试用例1
		String s ="egg";
		String t = "odd";
		测试用例1
		String s ="foo";
		String t = "bar";
				测试用例1
		String s ="foo";
		String t = "bar";
		
*/
public class _205_Isomorphic_Strings_是否是同型字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="paper";
		String t = "title";
		System.out.println(isIsomorphic(s, t));
	}
	
	public static boolean isIsomorphic(String s,String t) {
		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapT = new HashMap<>();
		if (s.length()!= t.length()) 	return false;
		if (s.equals(t)) 
			return true;
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		
		int[] modelS = new int[s.length()];
		int[] modelT = new int[t.length()];

		modelS = stringToModel(charS, mapS, modelS);
		modelT = stringToModel(charT, mapT, modelT);
		
		int i = 0;
		while(modelS[i] == modelT[i]) {
			i++;
			if (i==s.length()) {
				return true;
				
			}
		}
		return false;
	}
	public static int[] stringToModel(char[] charS, Map<Character, Integer> mapS, int[] modelS) {
		for (int i = 0; i < charS.length; i++) {
			char c = charS[i];
			if (!mapS.containsKey(c)) {
				mapS.put(c,  mapS.size());
			}
			modelS[i] = mapS.get(c);
			System.out.print(mapS.get(c));
		}
		System.out.println();
		return modelS;
	}
	
}
