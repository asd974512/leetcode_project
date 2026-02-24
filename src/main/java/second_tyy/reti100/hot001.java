package second_tyy.reti100;

import java.util.Arrays;
import java.util.HashMap;

// 两数之和

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class hot001 {
    public static void main(String args[]) {
        Solution solution = new Solution();

        int[] nums = {2, 7, 11, 15};


        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));

    }

}


class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int secondValue = target - nums[index];
            if (numMap.containsKey(secondValue)) {
                return new int[]{numMap.get(secondValue), index};
            }
            numMap.put(nums[index], index);
        }
        return new int[]{0};
    }


    public int[] twoSum暴力遍历方法(int[] nums, int target) {

        int[] result = {-1, -1};

        int firstIndex = 0;
        int secondIndex = 1;
        for (; firstIndex < nums.length - 1; firstIndex++) {
            secondIndex = firstIndex + 1;
            for (; secondIndex < nums.length; secondIndex++) {
                if (nums[firstIndex] + nums[secondIndex] == target) {
                    break;
                }
            }
            if (secondIndex != nums.length) {
                break;
            }
        }
        result[0] = firstIndex;
        result[1] = secondIndex;

        return result;
    }

}
