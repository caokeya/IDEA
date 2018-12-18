package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/** 
* @author  suzw
* @version 创建时间：2018年10月31日 下午8:37:55 
* 类说明 
* Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class _290_Word_Pattern_单词格式匹配 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public boolean wordPatternNew(String pattern, String str) {
		   String[] arr= str.split(" ");
		           HashMap<Character, String> map = new HashMap<Character, String>();
		           if(arr.length!= pattern.length())
		               return false;
		           for(int i=0; i<arr.length; i++){
		               char c = pattern.charAt(i);
		               if(map.containsKey(c)){
		                   if(!map.get(c).equals(arr[i]))
		                       return false;
		               }else{
		                   if(map.containsValue(arr[i]))
		                       return false;
		                   map.put(c, arr[i]);
		               }    
		           }
		           return true;
		       }
	public boolean wordPattern(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
	
}
