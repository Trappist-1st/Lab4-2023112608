package codes;
//动态规划：最大子序和 dp[i]表示以第i个元素结尾的最大子序和
// 状态转移方程：dp[i] = max(dp[i-1] + nums[i],nums[i])
public class L_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        L_53 l53 = new L_53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = l53.maxSubArray(nums);
        System.out.println(i);
    }
}
