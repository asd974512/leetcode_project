package again;

import java.util.Arrays;
import java.util.Scanner;

public class java删除有序数组重复元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            int[] nums = new int[strs.length];
            for(int i=0;i<nums.length;i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
            solution(nums);
        }
    }

    public static void solution(int[] nums){
        int length = 1;
        if(nums.length==0){
            System.out.println("0");
            return;
        }
        int left = 0;
        //right就是i
        for(int right=0;right<nums.length;right++){
            if(nums[left]==nums[right]){
                //left==right，就让right++，left不动，left就是不重复数组的右边界
            }else{
                length++;
                left++;
                nums[left]=nums[right];
            }
        }
        System.out.print(length+"   ");
        System.out.print("[");
        for(int i=0;i<left;i++){
            System.out.print(nums[i]+",");
        }
        System.out.print(nums[left]);
        System.out.print("]");
    }
}
