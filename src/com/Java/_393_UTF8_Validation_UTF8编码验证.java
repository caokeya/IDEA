package com.Java;

/*
UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
    对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
    对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
这是 UTF-8 编码的工作方式：
   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 */
public class _393_UTF8_Validation_UTF8编码验证 {
    class Solution {
        public boolean validUtf8(int[] data) {
            if (data == null || data.length == 0) {
                return false;
            }

            int count = 0;
            for (int d : data) {
                if (count == 0) {
                    if (d >> 5 == 0b110) {
                        count = 1;
                    } else if (d >> 4 == 0b1110) {
                        count = 2;
                    } else if (d >> 3 == 0b11110) {
                        count = 3;
                    } else if (d >> 7 == 0b0) {
                        count = 0;
                    } else {
                        return false;
                    }
                } else {
                    if (d >> 6 != 0b10) {
                        return false;
                    }
                    count--;
                }
            }
            return count == 0;
        }
    }

    class Solution2 {
        public boolean validUtf8(int[] data) {
            if (data == null || data.length == 0)
                return false;
            boolean isValid = true;
            for (int i = 0; i < data.length;) {
                if (data[i] > 255)
                    return false; // 1 after 8th digit, 100000000
                int numberOfBytes = 0;
                if ((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
                    numberOfBytes = 1;
                } else if ((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                    numberOfBytes = 2;
                } else if ((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                    numberOfBytes = 3;
                } else if ((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                    numberOfBytes = 4;
                } else {
                    return false;
                }
                for (int j = 1; j < numberOfBytes; j++) { // check that the next n bytes start with 10xxxxxx
                    if (i + j >= data.length)
                        return false;
                    if ((data[i + j] & 192) != 128)
                        return false; // 192(11000000), 128(10000000)
                }
                i = i + numberOfBytes;
            }
            return isValid;
        }
    }
}
