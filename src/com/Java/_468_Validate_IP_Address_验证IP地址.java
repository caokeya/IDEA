package src.com.Java;

/*
编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
示例 1:
输入: "172.16.254.1"
输出: "IPv4"
解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
示例 2:
输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
输出: "IPv6"
解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 */
public class _468_Validate_IP_Address_验证IP地址 {
    class Solution {
        public String validIPAddress(String IP) {
            if (isValidIPv4(IP))
                return "IPv4";
            else if (isValidIPv6(IP))
                return "IPv6";
            else
                return "Neither";
        }

        public boolean isValidIPv4(String ip) {
            if (ip.length() < 7)
                return false;
            if (ip.charAt(0) == '.')
                return false;
            if (ip.charAt(ip.length() - 1) == '.')
                return false;
            String[] tokens = ip.split("\\.");
            if (tokens.length != 4)
                return false;
            for (String token : tokens) {
                if (!isValidIPv4Token(token))
                    return false;
            }
            return true;
        }

        public boolean isValidIPv4Token(String token) {
            if (token.startsWith("0") && token.length() > 1)
                return false;
            try {
                int parsedInt = Integer.parseInt(token);
                if (parsedInt < 0 || parsedInt > 255)
                    return false;
                if (parsedInt == 0 && token.charAt(0) != '0')
                    return false;
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }

        public boolean isValidIPv6(String ip) {
            if (ip.length() < 15)
                return false;
            if (ip.charAt(0) == ':')
                return false;
            if (ip.charAt(ip.length() - 1) == ':')
                return false;
            String[] tokens = ip.split(":");
            if (tokens.length != 8)
                return false;
            for (String token : tokens) {
                if (!isValidIPv6Token(token))
                    return false;
            }
            return true;
        }

        public boolean isValidIPv6Token(String token) {
            if (token.length() > 4 || token.length() == 0)
                return false;
            char[] chars = token.toCharArray();
            for (char c : chars) {
                boolean isDigit = c >= 48 && c <= 57;
                boolean isUppercaseAF = c >= 65 && c <= 70;
                boolean isLowerCaseAF = c >= 97 && c <= 102;
                if (!(isDigit || isUppercaseAF || isLowerCaseAF))
                    return false;
            }
            return true;
        }
    }
}
