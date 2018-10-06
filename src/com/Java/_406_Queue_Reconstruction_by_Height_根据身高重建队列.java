package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
注意：
总人数少于1100人。
示例
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
(1)[4,4], index = 4,the only position is 4, because it's the shortest--> [][][][][4,4][]
(2)[5,2], index = 2 --> [][][5,2][][4,4][]
(3)[5,0], index = 0, --> [5,0][][5,2][][4,4][]
(4)[6,1], index = 1, the index 1 of remaining unoccupied position ->[5,0][][5,2][6,1][4,4][]
(5)[7,1], index = 1, the index 1 of remaining unoccupied position ->[5,0][][5,2][6,1][4,4][7,1]
(5)[7,0], index = 0, the index 0 of remaining unoccupied position ->[5,0][7,0][5,2][6,1][4,4][7,1]
 */
public class _406_Queue_Reconstruction_by_Height_根据身高重建队列 {
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    } else {
                        return b[0] - a[0];
                    }
                }
            });
            List<int[]> list = new ArrayList<>();
            for (int[] k : people) {
                list.add(k[1], k);
            }
            int[][] ret = new int[list.size()][];
            list.toArray(ret);
            return ret;
        }
    }
}
