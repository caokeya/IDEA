package src.com.Java;

/*
一个 N x N的 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。
输出将这个矩阵变为 “棋盘” 所需的最小移动次数。“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。如果不存在可行的变换，输出 -1。
示例:
输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
输出: 2
解释:
一种可行的变换方式如下，从左到右：
0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101
第一次移动交换了第一列和第二列。
第二次移动交换了第二行和第三行。
输入: board = [[0, 1], [1, 0]]
输出: 0
解释:
注意左上角的格值为0时也是合法的棋盘，如：
01
10
也是合法的棋盘.
输入: board = [[1, 0], [1, 0]]
输出: -1
解释:
任意的变换都不能使这个输入变为合法的棋盘。
 */
public class _782_Transform_to_Chessboard_变为棋盘_难 {
    class Solution {
        /**
         *      这道题给了我们一个二维数组，里面都是由0和1组成，让我们通过交换行或列来形成一个棋盘。
         *      就是国际象棋那种棋盘，黑白相间的那种，用数组表示就是0和1交替出现，相邻位置上的数字
         *      必定不是一样的。这道题默认棋盘的起始位置可以使1或0，然后依次类推可以得到所有位置上
         *      的值。这道题最大的难点是在于判定给定的数组，能否最终组成棋盘，因为能通过交换组成棋盘
         *      的数组其实是有很多苛刻条件需要满足的，只有这些条件都满足了，才能到计算交换数的那一步。
         *      首先我们来看长度为4的棋盘：
         *          1 0 1 0
         *          0 1 0 1
         *          1 0 1 0
         *          0 1 0 1
         *          或者
         *          0 1 0 1
         *          1 0 1 0
         *          0 1 0 1
         *          1 0 1 0
         *      我们发现对于长度为偶数的棋盘，每一行0和1的个数都是相等的，不管我们如何交换行和列，0和1
         *      的个数都是不会变化的，再看看长度为奇数的棋盘， 比如3：
         *          1 0 1
         *          0 1 0
         *          1 0 1
         *          或者
         *          0 1 0
         *          1 0 1
         *          0 1 0
         *      我们发现对于长度为奇数的棋盘，各行的0和1个数不同，但是还是有规律的，每行的1的个数要么为
         *      n/2要么为(n + 1)/2, 这个规律一定要保证，不然无法形成棋盘！！！！！！
         *
         *      ！！！还有个很重要的规律，我们观察题目给的第一个例子，如果我们只看行，我们发现只有两种情况
         *      0110 和 1001；如果只看列，只有两种情况0011 和 1100，我们发现不管棋盘有多长，都只有两种
         *      情况，而这两种情况各个位置上的数字是相反的，只有这样的矩阵才有可能转换为棋盘。那么这个规律
         *      可以衍生出一个规律，就是任意一个矩形的四个顶点只有三种情况，要么4个0，要么4个1，要么2个0要么
         *      2个1，不会有其他情况。那么四个顶点异或（xor）在一起一定是0，所以只要我们判断出了异或为1，
         *      一定是不对的，直接返回-1. 之后我们来统计首行和首列中1的个数，因为我们要让其满足之前提到的规律！！！！！！
         *      统计完了首行首列1的个数，我们判断如果其小于n/2或者大于(n + 1)/2, 那么一定无法转为棋盘。
         *      我们还需要计算一下首行和首列跟棋盘位置的错位的个数，虽然01010和10101都可以是正确的棋盘，
         *      我们先默认跟10101比较好了，之后再做优化处理。
         *
         *      ！！！！最后的难点就是计算最小的交换步数了，这里要分n的奇偶来讨论。如果n是奇数，必须得到偶数个错位，
         *      为啥呢，因为我们之前统计的是跟棋盘位置的错位的个数，而每次交换行或列，会修改两个错位，所以如果是
         *      奇数就无法还原为棋盘。举个例子，比如首行是10001，如果我们跟棋盘10101比较，只有一个错位，但是我们
         *      是无法通过交换得到10101，所以我们必须交换得到01010（另一种棋盘），此时错位是4个，而我们通过n-rowDiff
         *      正好也能得到4（另一种棋盘和当前棋盘相反，一个错位，那么当前row和另一种棋盘有n-1个错位），这就是为啥
         *      我们需要偶数个错位。如果n是偶数就不会出现这个问题， 但是会出现另一个问题，比如我们是0101，这本身就是
         *      正确的棋盘排列了，但是由于我们默认是跟1010比较，那么我们会得到4个错位，所以我们应该跟n - rowDiff
         *      比较取较小值。列的处理跟行的处理完全一样。最终我们把行错位和列错位个数相加，再除以2，就可以得到最小的交换
         *      次数了，之前说过了，每交换一次，可以修复两个错位。
         */
        public int movesToChessboard(int[][] board) {
            int N = board.length, rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < board[0].length; j++)
                    if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1)
                        return -1;

            for (int i = 0; i < N; i++) {
                // 计算首行，首列1的个数
                rowSum += board[0][i];
                colSum += board[i][0];

                // 假设默认的棋盘起点为1，计算错位的个数
                if (board[i][0] == i % 2)
                    rowSwap++;
                if (board[0][i] == i % 2)
                    colSwap++;
            }

            // 判断1的个数是否为<N/2 或 > (N + 1)/2
            if (rowSum < N / 2 || rowSum > (N + 1) / 2)
                return -1;
            if (colSum < N / 2 || colSum > (N + 1) / 2)
                return -1;

            // 判断棋盘行数奇偶性
            if (N % 2 == 1) {
                if (rowSwap % 2 == 1)
                    rowSwap = N - rowSwap;
                if (colSwap % 2 == 1)
                    colSwap = N - colSwap;
            } else {
                rowSwap = Math.min(rowSwap, N - rowSwap);
                colSwap = Math.min(colSwap, N - colSwap);
            }

            return (rowSwap + colSwap) / 2;
        }
    }
}
