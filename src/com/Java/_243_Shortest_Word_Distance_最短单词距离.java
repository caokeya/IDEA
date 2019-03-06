package src.src.com.Java;
/*
Given a list of words and two words word1 and word2, return the
shortest distance between these two words in the list.
For example, Assume that words = ["practice", "makes", "perfect","coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = “makes”,  word2 = "coding", return 1.
 Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class _243_Shortest_Word_Distance_最短单词距离 {
	public static int shortestDistance(String[] words, String word1, String word2) {
		int ans = Integer.MAX_VALUE;
		int i = 0;
		int p1 = Integer.MIN_VALUE;
		int p2 = Integer.MIN_VALUE;
		for (String string : words) {
			if (string.equals(word1)) {
				p1= i;
				//可以避免p2和p2没有完成初始值时，math.abs越界，导致输出-2147483647的情况，Integer.MIN_VALUE
				if(p2 !=Integer.MIN_VALUE)
					ans = Math.min(ans, Math.abs((p2-p1)));
			}
			else if(string.equals(word2)) {
				p2= i;
				if(p1 !=Integer.MIN_VALUE)
				ans = Math.min(ans, Math.abs(p2-p1));
			}
			i++;
		}
		return ans;
	}
}
