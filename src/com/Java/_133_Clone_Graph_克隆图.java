package com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。
节点被唯一标记。
我们用 # 作为每个节点的分隔符，用 , 作为节点标签和邻接点的分隔符。
例如，序列化无向图 {0,1,2#1,2#2,2}。
该图总共有三个节点, 被两个分隔符  # 分为三部分。 
    第一个节点的标签为 0，存在从节点 0 到节点 1 和节点 2 的两条边。
    第二个节点的标签为 1，存在从节点 1 到节点 2 的一条边。
    第三个节点的标签为 2，存在从节点 2 到节点 2 (本身) 的一条边，从而形成自环。
 */
public class _133_Clone_Graph_克隆图 {
    /**
     * Definition for undirected graph.
     */
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public class Solution {
        private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return clone(node);
        }

        private UndirectedGraphNode clone(UndirectedGraphNode node) {
            if (node == null)
                return null;
            if (map.containsKey(node.label))
                return map.get(node.label);
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(clone.label, clone); // 这里注意要先放入map, 要不然有circle
            for (UndirectedGraphNode nei : node.neighbors)
                clone.neighbors.add(clone(nei));
            return clone;
        }
    }
}
