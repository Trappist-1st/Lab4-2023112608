package codes;

import java.util.HashSet;
import java.util.Set;
//经典滑动窗口问题：最长无重复子串
public class L_3 {
    //occ：HashSet，记录当前窗口中出现的字符
    //n：字符串长度
    //rk：右指针，指向当前窗口的右边界
    //ans：记录最长子串长度
    //i：左指针，指向当前窗口的左边界
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();

        int rk = -1, ans = 0;
        for(int i=0;i<n;i++){
            if(i != 0){
                occ.remove(s.charAt(i-1));
            }
            while(rk + 1 < n && !occ.contains(s.charAt(rk +1))){
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "vbjdnceufgufjwefjvb";
        L_3 l3 = new L_3();
        int length = l3.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
