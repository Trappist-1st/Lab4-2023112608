package codes;

import java.util.*;

public class L_128 {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0;i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(map.containsKey(nums[i]-1)){
                List<Integer> list = map.get(nums[i]-1);
                list.add(nums[i]);
                map.put(nums[i]-1,list);
                map.put(nums[i],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(nums[i],list);
                //map.put(nums[i],List.of(nums[i]));
            }
        }

        int max = 0;
        for(List<Integer> list :map.values()){
            max = Math.max(max,list.size());
        }
        return max;
    }
//public static int longestConsecutive(int[] nums) {
//    if (nums == null || nums.length == 0) {
//        return 0;
//    }
//
//    Arrays.sort(nums);
//    Map<Integer, List<Integer>> map = new HashMap<>();
//
//    for (int i = 0; i < nums.length; i++) {
//        // 跳过重复数字
//        if (i > 0 && nums[i] == nums[i - 1]) {
//            continue;
//        }
//
//        int current = nums[i];
//        int previous = current - 1;
//
//        if (map.containsKey(previous)) {
//            // 连接到前一个序列
//            List<Integer> seq = map.get(previous);
//            seq.add(current);
//            map.put(current, seq);
//        } else {
//            // 创建新序列
//            List<Integer> newSeq = new ArrayList<>();
//            newSeq.add(current);
//            map.put(current, newSeq);
//        }
//    }
//
//    // 找出最长序列
//    int maxLen = 0;
//    Set<List<Integer>> seen = new HashSet<>();
//    for (List<Integer> seq : map.values()) {
//        if (seen.add(seq)) { // 如果成功添加，说明是新的序列
//            maxLen = Math.max(maxLen, seq.size());
//        }
//    }
//
//    return maxLen;
//}

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1));
    }
}
