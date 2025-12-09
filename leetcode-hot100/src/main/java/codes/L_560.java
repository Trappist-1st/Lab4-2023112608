package codes;

import java.util.ArrayList;
import java.util.List;
//前缀和解题，暂时看起来并不快
public class L_560 {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int  i = 1; i <= nums.length ; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1 ;j <= nums.length ;j++){
                if(sum[j] - sum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        L_560 l560 = new L_560();
        int[] nums = {1,2,3};
        int k = 3;
        int i = l560.subarraySum(nums, k);
        System.out.println(i);
    }
}
