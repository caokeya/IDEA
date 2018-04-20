package com.company;

//求两个字符串是否匹配（Hard）
//'.' 匹配一个任意字符
//'*' 匹配0个或多个字符

public class RegularExpressionMatching {

	class Solution {
	    public boolean isMatch(String s, String p) {
	        if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 1; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {				//为了跳过a*b*c中a*和b*不代表任何字符的情况
	            dp[0][i+1] = true;
	        }
	    }
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	    }
	}
	
}
