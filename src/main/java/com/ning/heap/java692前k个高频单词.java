package com.ning.heap;

import java.util.*;

public class java692前k个高频单词 {
    public static void main(String[] args) {
        Solution692 solution692 = new Solution692();
        String[] strs = {"i","love","leetcode","i","love","coding"};
        List<String> strings = solution692.topKFrequent(strs, 1);
        System.out.println(strings);
    }
}

class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue =
                new PriorityQueue<>(k, new myComparator());
        for (int i = 0; i < words.length; i++) {
            if (hashMap.containsKey(words[i])) {
                hashMap.put(words[i], hashMap.get(words[i]) + 1);
            } else {
                hashMap.put(words[i], 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            if(queue.size()<k){
                queue.offer(next);
            }else{
                Map.Entry<String, Integer> topSet = queue.peek();
                if(next.getValue()>topSet.getValue()){
                    queue.poll();
                    queue.offer(next);
                }else if(next.getValue()==topSet.getValue()){
                    int stringCompare = topSet.getKey().compareTo(next.getKey());
                    if(stringCompare<0){
                        queue.poll();
                        queue.offer(next);
                    }
                }
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while(!queue.isEmpty()){
            String key = queue.poll().getKey();
            list.addFirst(key);
        }
        return list;
    }


    static class myComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            int num = o1.getValue() - o2.getValue();
            if (num != 0) {
                return num;
            } else {
                String key1 = o1.getKey();
                String key2 = o2.getKey();
                return -1*key1.compareTo(key2);
            }
        }
    }
}
