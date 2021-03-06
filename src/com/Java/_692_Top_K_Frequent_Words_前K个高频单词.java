package src.com.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
示例 1：
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
示例 2：
输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 */
public class _692_Top_K_Frequent_Words_前K个高频单词 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            List<String>[] bucket = new ArrayList[words.length + 1];

            for (String key : map.keySet()) {
                int freq = map.get(key);
                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }
            List<String> res = new ArrayList<>();
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] != null) {
                    Collections.sort(bucket[i]);
                    for (String word : bucket[i]) {
                        res.add(word);
                        if (res.size() == k) {
                            return res;
                        }
                    }
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : words)
                map.put(s, map.getOrDefault(s, 0) + 1); // Frequent hashmap

            PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k,
                    (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey())
                            : b.getValue() - a.getValue());
            // if same frequency, then sort alphabetical .

            for (Map.Entry<String, Integer> entry : map.entrySet())
                maxHeap.add(entry);

            List<String> res = new ArrayList<>();
            while (res.size() < k)
                res.add(maxHeap.poll().getKey()); // add top k
            return res;
        }
    }

    class Solution3 {
        public List<String> topKFrequent(String[] words, int k) {

            List<String> result = new LinkedList<>();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i]))
                    map.put(words[i], map.get(words[i]) + 1);
                else
                    map.put(words[i], 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey())
                            : a.getValue() - b.getValue());

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k)
                    pq.poll();
            }

            while (!pq.isEmpty())
                result.add(0, pq.poll().getKey());

            return result;
        }
    }

}
