package src.com.Java;

/*
在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
（请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
返回区域的数目。
示例 1：
输入：
[
  " /",
  "/ "
]
输出：2
示例 2：
输入：
[
  " /",
  "  "
]
输出：1
示例 3：
输入：
[
  "\\/",
  "/\\"
]
输出：4
示例 4：
输入：
[
  "/\\",
  "\\/"
]
输出：5
示例 5：
输入：
[
  "//",
  "/ "
]
输出：3
 */
public class _959_Regions_Cut_By_Slashes_由斜杠划分区域 {
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            DSU dsu = new DSU(4 * N * N);
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c) {
                    int root = 4 * (r * N + c);
                    char val = grid[r].charAt(c);
                    if (val != '\\') {
                        dsu.union(root + 0, root + 1);
                        dsu.union(root + 2, root + 3);
                    }
                    if (val != '/') {
                        dsu.union(root + 0, root + 2);
                        dsu.union(root + 1, root + 3);
                    }
                    // north south
                    if (r + 1 < N)
                        dsu.union(root + 3, (root + 4 * N) + 0);
                    if (r - 1 >= 0)
                        dsu.union(root + 0, (root - 4 * N) + 3);
                    // east west
                    if (c + 1 < N)
                        dsu.union(root + 2, (root + 4) + 1);
                    if (c - 1 >= 0)
                        dsu.union(root + 1, (root - 4) + 2);
                }
            int ans = 0;
            for (int x = 0; x < 4 * N * N; ++x) {
                if (dsu.find(x) == x)
                    ans++;
            }
            return ans;
        }
    }

    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
