package huisu;

public class java494目标和 {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int ways = solution494.findTargetSumWays(nums, target);
        System.out.println(ways);
    }
}

class Solution494{
    public static int ways= 0;
    public int findTargetSumWays(int[] nums,int target){
        int length = nums.length;
        if(length==1 && (nums[0]==target || nums[0]==-target)){
            return 1;
        }
        if(length==1 && nums[0]!=target){
            return 0;
        }
        //开局是正数
        dfs(nums,target,true,0);
        //开局是负数
        dfs(nums,target,false,0);
        return ways;
    }
    //isPositive=true表示为正数，否则为负数.depth表示深度，depth=nums.length表示最后一步
    public void dfs(int[] nums,int target,boolean isPositive,int depth){
        if(isPositive){
            target = target-nums[depth];
        }else{
            target = target+nums[depth];
        }

        if(depth==nums.length-1 && target==0){
            //表示走完了，而且目标值是对的
            ways++;
            return;
        }else if(depth==nums.length-1 && target!=0){
            //表示走完了，但目标值是错的
            return;
        }

        dfs(nums,target,true,depth+1);
        dfs(nums,target,false,depth+1);
    }
}
