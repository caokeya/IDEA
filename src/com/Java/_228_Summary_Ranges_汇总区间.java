package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  suzw
* @version 创建时间：2018年10月9日 下午7:55:27 
* 类说明 
* 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
示例 1:
输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:
输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
*/
public class _228_Summary_Ranges_汇总区间 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));
	}
    public static List<String> summaryRanges(int[] nums) {
    		
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) {
    			return ans;
    		}
            if (nums.length == 1) {
    			ans.add(nums[0]+"");
    			return ans;
    		}
            for (int i = 0; i < nums.length; i++) {
            	int a = nums[i];
            	//注意条件的前后顺序，先判断长度
            	while(i<nums.length-1 &&(nums[i+1]-nums[i]==1) ) {
            		i++;
            	}
            	if (a != nums[i]) {
            		ans.add(a + "->" + nums[i]);
    			}
            	else ans.add(a+"");
            }
            return ans;
            
            
        }

}
