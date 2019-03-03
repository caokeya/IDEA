package com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
示例：
输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
输出：[null,0,1,1,0,0,1]
解释：
时间为 3，票数分布情况是 [0]，编号为 0 的候选人领先。
时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。
时间为 25，票数分布情况是 [0,1,1,0,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。
在时间 15、24 和 8 处继续执行 3 个查询。
 */
public class _911_Online_Election_在线选举 {


class TopVotedCandidate {
        // map to record time -> leader mappings. 
        Map<Integer, Integer> map = new HashMap<>();
        // cache the input times[] array
        int[] time;
    
        // time: O(n) where n is the number of votes. 
        // space: O(n) where n is the number of votes. 
        public TopVotedCandidate(int[] persons, int[] times) {
            // acquire input stats
            int n = persons.length;
            // assign times[]
            time = times;
            // initialize leader (leader is actually person, NOT INDEX! )
            int leader = -1;

            // map used to record person's index ---> vote mappings.
            Map<Integer, Integer> count = new HashMap<>();

            // for rach person.
            for (int i = 0; i < n; i++) {
                // increment this person's vote by 1
                count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
                // if the first iteration OR current person's vote is more than current leader.
                if (i == 0 || count.get(persons[i]) >= count.get(leader)) {
                    // update leader
                    leader = persons[i];
                }
                // record time->leader relation.
                map.put(time[i], leader);
            }
        }

        // time: O(log n); where n is the number of votes. 
        // use binary search to find a closest time that is no later than the query time 't'. 
        // and return the result from 'map'.
        public int q(int t) {
            int i = Arrays.binarySearch(time, t);
            // -insertionPoint - 1; insertion point is the first element that is larger than key.
            // 如果key在数组中，则返回搜索值的索引；否则返回-1或者”-“(插入点)。插入点是索引键将要插入数组的那一点，即第一个大于该键的元素索引。
            return (i < 0) ? map.get(time[-i - 2]) : map.get(time[i]);
        }
    }
    /**
     * Your TopVotedCandidate object will be instantiated and called as such:
     * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
     * int param_1 = obj.q(t);
     */
}
