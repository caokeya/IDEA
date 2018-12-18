package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月31日 下午8:47:13 
* 类说明 
* 
根据百度百科，生命游戏，简称为生命，是英国数学家约翰・何顿・康威在1970年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

示例:

输入: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
进阶:

你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
*/
public class _290_Game_of_Life_九宫格 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void gameOfLifeFaster(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checkSurroundings(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    /*使用四个数字表示不同的状态
     * To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1
     */
    public void checkSurroundings(int[][]board, int i, int j) {
        int numOnes = getOnes(board, i-1, j) +
            getOnes(board, i-1, j-1) +
            getOnes(board, i-1, j+1) + 
            getOnes(board, i, j-1) +
            getOnes(board, i, j+1) +
            getOnes(board, i+1, j-1) + 
            getOnes(board, i+1, j) + 
            getOnes(board, i+1, j+1);
        
        if(board[i][j] == 1){
            //cell with 0 1 4 5 6 7 8 dies
            if (numOnes < 2 || numOnes > 3) {
                board[i][j] = -1;    
            }
        } else if (board[i][j] == 0){
            //dead cell with 3 live again
            if (numOnes == 3){
                 board[i][j] = 2;    
            }
        }
    }
    
    public int getOnes(int[][]board, int i, int j) {
        if (i >= 0 && j >= 0 && 
            i < board.length && 
            j < board[0].length) {
            
            if (board[i][j] == 1 || board[i][j] == -1) { // The cells were/are previously alive
                return 1;
            }
            
            if (board[i][j] == 2) { // The cell was previously dead
                return 0;
            }
            return 0;
        } 
        return 0;
    }
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) return;
	    int m = board.length, n = board[0].length;
	
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int lives = liveNeighbors(board, m, n, i, j);
	
	            // In the beginning, every 2nd bit is 0;
	            // So we only need to care about when will the 2nd bit become 1.
	            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
	                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
	            }
	            if (board[i][j] == 0 && lives == 3) {
	                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
	            }
	        }
	    }
	
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            board[i][j] >>= 1;  // Get the 2nd state.
	        }
	    }
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
	    int lives = 0;
	    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
	        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
	            lives += board[x][y] & 1;
	        }
	    }
	    lives -= board[i][j] & 1;
	    return lives;
	}
	
}
