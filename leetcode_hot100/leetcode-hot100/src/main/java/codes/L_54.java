package codes;

import java.util.ArrayList;
import java.util.List;
//螺旋矩阵
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//解题思路：
//1.定义四个边界：上边界top，右边界right，下边界bottom，左边界left，初始值分别为0，n-1，m-1，0
//2.使用一个循环，直到top > bottom 或 left > right
//3.在每次循环中，按照顺时针方向遍历矩阵的边界，并将元素添加到结果列表中
//4.更新边界：遍历完一圈后，更新边界值，缩小矩阵的范围
//5.返回结果列表
public class L_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        int top = 0,bottom = m-1,left = 0,right = n-1;

        while(top <= bottom && left <= right){
            for(int j = left;j <= right; j++){
                result.add(matrix[top][j]);
            }
            top++;

            for(int i = top;i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int j = right;j >= left; j--){
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom;i >= top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        L_54 l54 = new L_54();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> integers = l54.spiralOrder(matrix);
        System.out.println(integers);
    }
}
