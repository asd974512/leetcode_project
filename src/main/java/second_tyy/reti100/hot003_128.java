package second_tyy.reti100;


// 128 最长连续序列

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * <p>
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class hot003_128 {
    public static void main(String[] args) {

        Solution128 solution128 = new Solution128();
        int[] params = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        int i = solution128.longestConsecutive(params);
        System.out.println("result:" + i);
    }
}


class Solution128 {


    public int longestConsecutive(int[] nums) {
        // 用哈希集合去除重复元素，并且在 O(1) 时间内查找元素
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 遍历每个元素
        for (int num : numSet) {
            // 判断当前元素是否为一个连续序列的起点
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 扩展序列
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最长序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    /**
     * 击败了5%
     * 我的思路：1.先排序、2然后在放入到TreeSet进行去重。3.依次比较前后两个的差值，差值为1就记录+1，如果不唯一就记录改为1.最后返回记录最大的那个值
     * @param nums
     * @return
     */
    public int longestConsecutiveNingbin(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }

        TreeSet<Integer> set = new TreeSet<>(list);

        int result = 1;
        int longestResult = 1;
        int preNum = nums[0];
        int nextNum = nums[0];
        for (Integer num:set) {
            nextNum = num;
            if(nextNum-preNum==1){
                result++;
            }else{
                result = 1;
            }
            preNum = num;
            longestResult = longestResult>result?longestResult:result;
        }
        return longestResult;

    }
}