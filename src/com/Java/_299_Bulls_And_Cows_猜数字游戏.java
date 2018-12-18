package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年11月7日 下午3:38:39 
* 类说明 
* 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，
* 你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了
* 但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。

请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。

请注意秘密数字和朋友的猜测数都可能含有重复数字。

示例 1:

输入: secret = "1807", guess = "7810"

输出: "1A3B"

解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
示例 2:

输入: secret = "1123", guess = "0111"

输出: "1A1B"

解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
*/
public class _299_Bulls_And_Cows_猜数字游戏 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//该方法1ms,后一种2ms
    public String getHintFaster(String secret, String guess) {
        int bull = 0, cow = 0;
        char[] ss = secret.toCharArray();
        char[] gg = guess.toCharArray();
        int n = ss.length;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int s = ss[i] - '0', g = gg[i] - '0';
            if (s == g) {
                bull++;
            } else {
                if (count[s] < 0) {
                    cow++;
                }
                if (count[g] > 0) {
                    cow++;
                }
                count[s]++;
                count[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }
	
	  public String getHint(String secret, String guess) {
	        char[] cSecret = secret.toCharArray();
	        char[] cGuess = guess.toCharArray();
	        int bulls = getBulls(cSecret, cGuess);
	        int cows = getCows(cSecret, cGuess)-bulls;
	        
	        
	        return bulls+"A"+cows+'B';
		  
	  }
	  
	  //匹配位置和数字都正确的个数： Bulls
	  public static int  getBulls(char[] cSecret, char[] cGuess) {
		  int ans = 0;
		  for(int i = 0; i<cSecret.length; i++)
			  if(cSecret[i] == cGuess[i])
				  ans++;
		  return ans;
	  }
	  //获取有多少位数字猜对了但是位置不对：  = 猜对数字的个数- bulls
	  public static int  getCows(char[] cSecret, char[] cGuess) {
		  int ans = 0;
		  int[] s=new int[10];
		  int[] g = new int[10];
		  
		  for (char i : cSecret ) 
			s[i - '0']++;
		
		  for (char i : cGuess ) 
			g[i - '0']++;
			
			  
		  for(int i = 0; i<s.length; i++)
			 ans+=s[i]>g[i]?g[i]:s[i];
		  return ans;
	  }

}
