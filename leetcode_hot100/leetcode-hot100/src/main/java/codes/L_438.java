package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//滑动窗口+计数数组解题,解题思路：
//1. 定义两个计数数组sCount和pCount，分别用于统计字符串s和p中每个字符的出现次数。
//2. 初始化sCount和pCount，将p中每个字符的出现次数记录在pCount中。
//3. 使用滑动窗口在字符串s上进行遍历，窗口的大小为p的长度。
//4. 在遍历过程中，实时更新sCount数组，将当前窗口内的字符出现次数记录在sCount中。
//5. 比较sCount和pCount是否相等，如果相等，则说明当前窗口内的字符是p的异位词，将窗口的起始索引添加到结果列表中。
//6. 继续遍历，直到窗口到达字符串s的末尾。
//7. 返回结果列表。
public class L_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;

    }

    public static void main(String[] args){
        L_438 l438 = new L_438();
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = l438.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
