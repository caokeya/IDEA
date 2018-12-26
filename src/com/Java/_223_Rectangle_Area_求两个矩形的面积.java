package src.com.Java;

/*
 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
[(A,B),(C,D)],[(E,F),(G,H)]
Example:
Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
*/
public class _223_Rectangle_Area_求两个矩形的面积 {
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

            int areaOfSqrA = (C - A) * (D - B);
            int areaOfSqrB = (G - E) * (H - F);

            int left = Math.max(A, E);
            int right = Math.min(G, C);
            int bottom = Math.max(F, B);
            int top = Math.min(D, H);

            //If overlap
            int overlap = 0;
            if (right > left && top > bottom)
                overlap = (right - left) * (top - bottom);

            return areaOfSqrA + areaOfSqrB - overlap;
        }
    }
}
