package src.com.Java;

import java.util.Arrays;

/** 
* @author  suzw
* @version 创建时间：2018年9月13日 下午8:41:27 
* 类说明 
*/
public class _220_Contains_Duplicate_III_重复数字 {
	public static void main(String[] args) {
		int[] nums = {-Integer.MAX_VALUE,Integer.MAX_VALUE};
		//System.out.println(Math.abs((double)(Integer.MAX_VALUE+1)));
		System.out.println(containsDuplicate2(nums, 1,Integer.MAX_VALUE));
		
	}
	 public static boolean containsDuplicate2(int[] nums,int k,int t) {
			if(nums.length<2||k<1||t<0) return false;
			ValuePosPair[] valPosArr = new ValuePosPair[nums.length];
			for(int i =0;i<nums.length;i++) valPosArr[i] = new ValuePosPair(nums[i],i); 
			//先将数据进行排序，能加快速度
			Arrays.sort(valPosArr);	
			for(int i=0;i<valPosArr.length;i++){
				for(int j=i+1;j<valPosArr.length&&((long)valPosArr[j].val-(long)valPosArr[i].val<=(long)t);j++){
					if(Math.abs(valPosArr[j].pos-valPosArr[i].pos)<=k) return true;	
				}
			}
			return false;
		}  
		 
		 /*
		  * 该方法TimeLimited
		 for (int i = 0; i < nums.length; i++) {
			 for (int j = i+1; j < nums.length && j<=i+k; j++) {
				 if (Math.abs(((long)nums[j]-(long)nums[i]))<=t) {
					 System.out.println(j+":"+nums[j]+"-"+i+":"+nums[i]);
					 return true;
				 }
			}
		 }
	    */


}	 
class ValuePosPair implements Comparable<ValuePosPair>{

	int val;
	int pos;

	ValuePosPair(int v, int p) { val = v; pos = p;}

	public int compareTo(ValuePosPair x){
		return this.val - x.val;
	}	
}
