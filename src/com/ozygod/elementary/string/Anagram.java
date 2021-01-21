package com.ozygod.elementary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char tmp = t.charAt(i);
            if (map.getOrDefault(tmp, 0) == 0) return false;
            map.put(tmp, map.getOrDefault(tmp, 0)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Anagram demo = new Anagram();
        System.out.println(demo.isAnagram(s, t));
    }
}
