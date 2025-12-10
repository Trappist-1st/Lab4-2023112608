package codes;

public class L_11 {
//    public int maxWater(int[] height){
//        int maxSize = 0;
//        for(int i=0;i<height.length - 1;i++){
//            for(int j=i+1;j<height.length;j++){
//                int size = Math.min(height[i],height[j]) * (j - i);
//                maxSize = Math.max(size,maxSize);
//            }
//        }
//        return maxSize;
//    }
    public int maxArea(int[] height){
        int left= 0;
        int right = height.length - 1;
        int maxSize = 0;
        while(left < right){
            int size = Math.min(height[left],height[right]) * (right - left);
            maxSize = Math.max(size,maxSize);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        int[] height = {1,8,6,2,5,4,8,3,7};
        L_11 l11 = new L_11();
        int maxSize = l11.maxArea(height);
        System.out.println(maxSize);
    }
}
