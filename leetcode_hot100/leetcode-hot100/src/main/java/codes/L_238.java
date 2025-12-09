package codes;

import java.util.Arrays;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题
//解题思路：前缀乘积和后缀乘积
//1.创建两个数组left和right，分别存储每个元素左侧和右侧的乘积
//2.遍历数组nums，计算left和right数组
//3.最后遍历数组nums，计算结果数组answer，answer[i] = left[i] * right[i]
public class L_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if(i == 0){
                left[i] = 1;
            }else{
                left[i] = left[i-1] * nums[i-1];
            }
        }
        for (int i = n-1; i >=0 ;i--){
            if(i == n-1) {
                right[i] = 1;
            }else{
                right[i] = right[i+1] * nums[i+1];
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
    public static void main(String[] args){
        L_238 l238 = new L_238();
        int[] nums = {1,2,3,4};
        int[] answer = l238.productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }
}
