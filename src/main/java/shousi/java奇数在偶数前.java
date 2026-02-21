package shousi;

public class java奇数在偶数前 {
    public static void main(String[] args) {

    }
}

class Solution奇数在偶数前 {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1){
            return nums;
        }
        int left =0;
        int right = n-1;
        while(left<right){
            if(nums[left]%2==0){
                swap(nums,left,right);
                right--;
            }else{
                left++;
            }
        }
        return nums;
    }
    public void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
