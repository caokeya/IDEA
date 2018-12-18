package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Distance. The only difference is now you are given the list of words
and your method will be called repeatedly many times with different
parameters. How would you optimize it?
Design a class which receives a list of words in the constructor,
and implements a method that takes two words word1 and word2 and
return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect","coding", "makes"].
 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 ="makes", word2 = "coding", return 1.
 Note: You may assume that word1 does not equal to word2, and word1
and word2 are both in the list.
这道题是之前那道Shortest Word Distance的拓展，不同的是这次我们需要多次调用求最短单词距离的函数，
那么用之前那道题的解法二和三就非常不高效，而当时我们摒弃的解法一的思路却可以用到这里，
我们用哈希表来建立每个单词和其所有出现的位置的映射，然后在找最短单词距离时，
我们只需要取出该单词在哈希表中映射的位置数组进行两两比较即可，参见代码如下：
 */
public class _244_Shortest_Word_DistanceII_最短单词距离2 {
    HashMap<String, List<Integer>> hashmap = new HashMap<String, List<Integer>>();

    public void _244_Shortest_Word_DistanceII_最短单词距离2(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (hashmap.containsKey(words[i])) {
                hashmap.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashmap.put(words[i], list);
            }
        }
    }

    //因为hashmap存的时候，是按照顺序存的，所以两个list每次把最小的那个去掉，然后进行update
    public int shortest(String word1, String word2) {
        List<Integer> list1 = hashmap.get(word1);
        List<Integer> list2 = hashmap.get(word2);
        int i = 0;
        int j = 0;
        int mindis = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            mindis = Math.min(mindis, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return mindis;
    }

}
// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
