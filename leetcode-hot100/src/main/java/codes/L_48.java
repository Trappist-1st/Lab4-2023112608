package codes;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//解题思路；先转置再水平翻转
//转置：matrix[i][j] 和 matrix[j][i] 交换
//水平翻转：matrix[i][j] 和 matrix[i][n-1-j] 交换
public class L_48 {
    public void rotate(int[][] matrix) {
        int m =matrix.length, n = matrix[0].length;

        //转置
        for(int i = 0;i < m ;i++){
            for(int j = i ;j < n ;j++){
                //j从i开始，只交换对角线右上方的元素，避免重复交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //水平翻转


        for(int i = 0; i < m ; i++){
            int a = 0, b = n - 1;
            while(a < b){
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
                a++;
                b--;
            }
        }
    }
    public static void main(String[] args){
        L_48 l48 = new L_48();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        l48.rotate(matrix);
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
