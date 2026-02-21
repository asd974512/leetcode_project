package again;

import java.util.*;

public class java两数之和{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            int[] nums = new int[strs.length - 1];
            int target = Integer.parseInt(strs[strs.length-1]);
            for(int i=0;i<strs.length-1;i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
//            System.out.println(Arrays.toString(nums));
//            System.out.println(target);
            solution(nums,target);
        }
    }

    public static void solution(int[] nums,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //如果hashMap中有对应的另一半值，说明找到了
            if(hashMap.containsKey(target-nums[i])){
                int index = hashMap.get(target-nums[i]);
                System.out.println("["+index+","+i+"]");
                return;
            }else{
                hashMap.put(nums[i],i);
            }
        }
        System.out.println(-1);
    }
}