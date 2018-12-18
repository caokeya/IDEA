package src.com.Java;

import java.util.ArrayList;

import java.util.List;

/** 
* @author  suzw
* @version 创建时间：2018年10月11日 下午8:21:31 
* 类说明
* 
* 多数投票算法(Boyer-Moore Algorithm)：
* https://blog.csdn.net/kimixuchen/article/details/52787307
* https://www.jianshu.com/p/dfd676b71ef0
* 
*  		该算法时间复杂度为O(n)，空间复杂度为O(1)，只需要对原数组进行两趟扫描，并且简单易实现。
*  		第一趟扫描我们得到一个候选节点candidate，第二趟扫描我们判断candidate出现的次数是否大于 n/2 。
* 一般解法：
*  		先对数组排序，然后取中间位置的元素，再对数据扫描一趟来判断此元素是否为多数元素。时间复杂度O(nlog(n))，空间复杂度O(1)。
		使用一个hash表，对数组进行一趟扫描统计每个元素出现的次数，即可得到多数元素。时间复杂度O(n)，空间复杂度O(n)。
* 
* Given an integer array of size n, find all elements that appear more than  n/3 times.
Note: The algorithm should run in linear time and in O(1) space.
Example 1:
Input: [3,2,3]
Output: [3]
Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/
public class _229_Majority_Element_II_统计数字出现的个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public static List<Integer> majorityElement(int[] nums) {
    	  List<Integer> ans = new ArrayList<>();
          if (nums.length == 0) {
  			return ans;
  		}
          int count1=0;
          int count2=0;
          int candidate1=nums[0];
          int candidate2=nums[0];
          
          for (int i = 0; i < nums.length; i++) {
  			if (nums[i] == candidate1) {
  				count1++;
  			}else if (nums[i] == candidate2) {
  				count2++;
  			}else if (count1==0) {
  				candidate1 = nums[i];
                  count1 =1;
  			}else if (count2 == 0) {
  				candidate2 = nums[i];
                  count2= 1;
  			}else {
  				count1--;
  				count2--;
  			}
  		}
          count1 = count2 = 0;
          for (int i : nums) {
          	if (i == candidate1) {
  				count1++;
  			}else if (i == candidate2) {
  				count2++;
  			}
  		}
          if (count1>nums.length/3) {
  			ans.add(candidate1);
  			
  		}
          if (count2>nums.length/3  && candidate2!=candidate1) {
  			ans.add(candidate2);
  			
  		}
          
          
          return ans;

    }
}
