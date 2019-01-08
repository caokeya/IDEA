package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class _535_Encode_and_Decode_TinyURL_TinyURL的加密与解密 {
    public class Codec {
        Map<String, String> dict = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String url = "http://tinyurl.com/" + longUrl.hashCode();
            dict.put(url, longUrl);
            return url;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return dict.get(shortUrl);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

}
