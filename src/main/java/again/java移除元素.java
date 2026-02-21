package again;

import java.util.Scanner;

public class java移除元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int target = Integer.parseInt(s1[s1.length-1]);
            int[] nums = new int[s1.length - 1];
            for(int i=0;i<s1.length-1;i++){
                nums[i] = Integer.parseInt(s1[i]);
            }
            solution(nums,target);
        }
    }
    public static void solution(int[] nums, int target){
        int left =0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]==target){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                left++;
            }
        }
        System.out.println(left+1);
        for(int i=0;i<=left;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
