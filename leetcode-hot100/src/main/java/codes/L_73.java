package codes;

import java.util.Arrays;

//矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//解题思路：
//1.首先检查第一行和第一列是否包含零，分别用两个布尔变量firstRowZero和firstColZero记录下来。
//2.然后遍历矩阵的其余部分，如果发现某个元素为零，就将该元素所在行的第一列和该元素所在列的第一行分别标记为零。
//3.接下来，再次遍历矩阵的其余部分，根据第一行和第一列的标记，将对应的行和列置为零。
//4.最后，根据firstRowZero和firstColZero的值，决定是否将第一行和第一列置为零。
//时间复杂度：O(m*n)，空间复杂度：O(1)
public class L_73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // 检查第一行和第一列是否有零
        for(int j=0;j<cols;j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i=0;i<rows;i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        // 使用第一行和第一列作为标记
        for(int i=1 ; i<rows ;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据标记置零
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行和第一列
        if (firstRowZero) Arrays.fill(matrix[0], 0);
        if (firstColZero) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }

    }
    public static void main(String[] args){
        L_73 l73 = new L_73();
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        l73.setZeroes(matrix);
        for(int i = 0;i < matrix.length ; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
