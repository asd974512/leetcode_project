package com.ning.hot100;

import java.util.*;

public class java49字母异位词分组 {
    public static void main(String[] args) {
        char[] c = {'c','a','e','d'};
        System.out.println(String.valueOf(c));
        System.out.println(c.toString());
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            //下面不能写成c.toString()
            String key = new String(c);
//            String key = c.toString();
            List<String> list = hashmap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hashmap.put(key,list);
        }
        List<List<String>> lists = new ArrayList<>();
        Collection<List<String>> values = hashmap.values();
        for (List<String> value : values) {
            lists.add(value);
        }
        return lists;
    }
}