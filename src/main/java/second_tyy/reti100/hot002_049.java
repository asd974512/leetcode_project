package second_tyy.reti100;

//49. 字母异位词分组

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 解释：
 *
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 */
// test

/**
 * 如果字符包含 Unicode 怎么办？
 *
 * 如果字符串非常长怎么办？
 *
 * 如果数据量 10^6 怎么优化？
 *
 * 如果要保持原顺序怎么做？
 */
public class hot002_049 {

    public static void main(String[] args) {
        Solution49 solution = new Solution49();

        String[] params = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> list = solution.groupAnagrams(params);
        System.out.println(list.toString());
    }
}


class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(int index = 0;index<strs.length;index++){
            char[] chars = strs[index].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(hashMap.containsKey(key)){
                hashMap.get(key).add(strs[index]);
            }else{
                hashMap.put(key,new ArrayList<>(Arrays.asList(strs[index])));
            }
        }

        return new ArrayList<>(hashMap.values());
    }
}
