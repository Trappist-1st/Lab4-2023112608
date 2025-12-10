package testfloor;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args){
        String str = "bvfjvhg";
        System.out.println(str.toCharArray()[1]);
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

        String str1 = new String(charArray);
        System.out.println(str1.getClass());
    }
}
