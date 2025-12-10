package codes;
//搜索二维矩阵II
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

//解题思路：从右上角开始搜索，如果当前元素大于目标值，向左移动一列，排除当前列
//如果当前元素小于目标值，向下移动一行，排除当前行
public class L_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int m = matrix.length, n =matrix[0].length;
        int curRow = 0, curCol = n - 1;
        while(curRow < m && curCol >= 0){
            int current = matrix[curRow][curCol];
            if(current == target){
                return true;
            }
            if(current > target){
                curCol--;
            }
            if(current < target){
                curRow++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        L_240 l240 = new L_240();
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        boolean b = l240.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
