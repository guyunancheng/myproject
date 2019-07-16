package Test;

import java.util.Arrays;

public class TestUser {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.print(nums.toString());
        System.out.println(Arrays.toString(nums));
        StringBuffer sf = new StringBuffer();
        for (int i=0;i<nums.length;i++){
            sf.append(nums[i]+",");
        }
        // com.entidy.User@abcdef
        sf.deleteCharAt(sf.length()-1);
        System.out.println(sf.toString());
    }
}
