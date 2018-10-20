package src.com.Java;

import java.util.Arrays;

/*
给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
一个点的坐标（x，y）由一个有两个整数的整数数组表示。
示例:
输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
输出: True
 */
public class _593_Valid_Square_有效的正方形 {
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[] distances = new int[6];
            distances[0] = distance2(p1,p2);
            distances[1] = distance2(p1,p3);
            distances[2] = distance2(p1,p4);
            distances[3] = distance2(p2,p3);
            distances[4] = distance2(p2,p4);
            distances[5] = distance2(p3,p4);
            Arrays.sort(distances);
            return (
                distances[0] >0 && 
                distances[0] == distances[1] &&
                distances[0] == distances[2] &&
                distances[0] == distances[3] &&
                
                distances[4] == distances[5]                      
               ) ;
        }
        
        int distance2(int[] p1, int[] p2){
            return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
        }
    }
}
