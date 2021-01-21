package com.ozygod.elementary.string;

/**
 * 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        int hs = 0, ns = 0;
        while (hs < haystack.length()) {
            if (haystack.charAt(hs) != needle.charAt(ns)) {
                hs++;
                if (ns > 0) {
                    hs = hs - ns;
                    ns = 0;
                }
                continue;
            }
            if (ns == needle.length()-1) return hs-ns;
            hs++;
            ns++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        StrStr demo = new StrStr();
        System.out.println(demo.strStr(haystack, needle));
    }
}
