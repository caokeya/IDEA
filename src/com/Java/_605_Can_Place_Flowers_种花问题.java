package com.Java;

/*
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
示例 1:
输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:
输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
 */
public class _605_Can_Place_Flowers_种花问题 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (n == 0)
                return true;
            if (flowerbed.length == 1 && (n == 1) && flowerbed[0] == 0)
                return true;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    if (i - 1 >= 0 && i + 1 < flowerbed.length) {
                        if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                            n--;
                            flowerbed[i] = 1;
                        }
                    } else if (i == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
                if (n == 0) {
                    return true;
                }

            }
            return n == 0 ? true : false;
        }
    }
}
