package codes;

import java.util.Arrays;

//轮转数组，给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//解题思路：
//1. 先将数组反转，将数组分为两部分，分别是[0,n-k-1]和[n-k,n-1]。
//2. 分别对这两部分进行反转，即可得到轮转后的数组。（:真他妈妙）
public class L_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;//如果k大于n，取k对n的余数

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums, k,n-1);
    }
    public void reverse(int[] nums, int start, int end){//反转区间[start,end]的元素
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        L_189 l189 = new L_189();
        int[] nums = {1,2,3,4,5,6,7,8};
        l189.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
