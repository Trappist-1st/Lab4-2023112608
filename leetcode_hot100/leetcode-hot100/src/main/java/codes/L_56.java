package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//核心思想：按区间起点排序,遍历合并重叠区间
public class L_56 {
    public int[][] merge(int[][] intervals) {
        // 按区间起点排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int i = 1 ; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] last = merged.get(merged.size()-1);

            //如果当前区间与最后一个区间重叠
            if(current[0] <= last[1]){
                //合并区间，更新终点为较大值
                last[1] = Math.max(last[1], current[1]);
            }else{
                //不重叠，直接添加当前区间
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args){
        L_56 l56 = new L_56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = l56.merge(intervals);
        for(int[] interval : mergedIntervals){
            System.out.println(Arrays.toString(interval));
        }
    }
}
