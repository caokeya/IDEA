package src.com.Java;
/*
给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
说明:
    输入值和输出值都将是浮点数。
    圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
    圆周上的点也认为是在圆中。
    randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
示例 1：
输入: 
["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 */
public class _478_Generate_Random_Point_in_a_Circle_在圆内随机生成点 {
    class Solution {
        public double r, c_x, c_y;

        public Solution(double radius, double x_center, double y_center) {
            this.r = radius;
            this.c_x = x_center;
            this.c_y = y_center;
        }

        public double[] randPoint() {
            double pc_r = Math.sqrt(Math.random()) * r;
            double pc_theate = Math.random() * Math.PI * 2;
            double x = c_x + pc_r * Math.cos(pc_theate);
            double y = c_y + pc_r * Math.sin(pc_theate);
            return new double[] { x, y };
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(radius, x_center, y_center);
     * double[] param_1 = obj.randPoint();
     */
}
