package again;

public class java盛水最多的容器 {
    public static void main(String[] args) {

    }
}

class Solution盛水最多的容器 {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length <= 1 || height == null) {
            return 0;
        }
        int left = 0;
        int right = length-1;
        int theMaxArea = 0;
        while(left<right){
            int area = (right-left)*Math.min(height[left],height[right]);
            theMaxArea = Math.max(theMaxArea,area);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
        }
        return theMaxArea;
    }
}