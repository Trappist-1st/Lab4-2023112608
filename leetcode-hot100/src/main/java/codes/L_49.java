package codes;

import java.util.*;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

//示例 1:
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//
//输入: strs = ["a"]
//输出: [["a"]]
public class L_49 {


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }
}
