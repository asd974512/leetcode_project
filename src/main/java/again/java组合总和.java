package again;

import java.util.*;

public class java组合总和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            int target = Integer.parseInt(strs[strs.length - 1]);
            int[] nums = new int[strs.length - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            List<List<Integer>> lists = solution(nums, target);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
        }
    }

    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        if(nums.length==0 || nums==null){
            return lists;
        }
        Arrays.sort(nums);
        process(lists, path, nums, 0, target);
        return lists;
    }

    public static void process(List<List<Integer>> lists, Deque<Integer> path,
                               int[] nums, int index, int target) {
        if (target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target - index >= 0) {
                path.add(nums[i]);
                process(lists, path, nums, i, target - nums[i]);
                path.removeLast();
            }
        }
    }
}
