package src.com.Java;

/*
给定一个无向图graph，当这个图为二分图时返回true。
如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
示例 1:
输入: [[1,3], [0,2], [1,3], [0,2]]
输出: true
解释: 
无向图如下:
0----1
|    |
|    |
3----2
我们可以将节点分成两组: {0, 2} 和 {1, 3}。
示例 2:
输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
输出: false
解释: 
无向图如下:
0----1
| \  |
|  \ |
3----2
我们不能将节点分割成两个独立的子集。
 */
public class _785_Is_Graph_Bipartite_判断二分图 {
    /*
     * 试图用两种颜色给图上色看看是否有任何相邻的节点有相同的颜色。
     * 如果它没有被着色，就用一种颜色来着色。然后用另一种颜色给所有相邻节点(DFS)上色。
     * 如果它已经被着色，检查当前的颜色是否与用于着色的颜色相同
     */
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];

            for (int i = 0; i < n; i++) { // This graph might be a disconnected graph. So check each unvisited node.
                if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean validColor(int[][] graph, int[] colors, int color, int node) {
            if (colors[node] != 0) {
                return colors[node] == color;
            }
            colors[node] = color;
            for (int next : graph[node]) {
                if (!validColor(graph, colors, -color, next)) {
                    return false;
                }
            }
            return true;
        }
    }
}
