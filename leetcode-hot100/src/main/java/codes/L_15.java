package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int first = 0;first <n;first++){
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int third = n-1;
            int target = -nums[first];

            for(int second = first+1;second < n;second++){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while(second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        L_15 l15 = new L_15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = l15.threeSum(nums);
        System.out.println(lists);
    }
}
