package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class java547省份数量 {
    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
        int[][] numbers =new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][] numbers1 =new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int[][] numbers2 = new int[][]{{1},{0,3},{4},{1},{2},{}};
        int circleNum = solution547.findCircleNum(numbers2);
//        System.out.println(circleNum);
    }
}

class Solution547 {

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        //所有子集
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                //子集
                ArrayList<Integer> list = new ArrayList<>();
                Deque<Integer> deque = new ArrayDeque<>();
                deque.offer(i);
                list.add(i);
                while(!deque.isEmpty()){
                    int j = deque.poll();
                    visited[j] = true;
                    for(int k=0;k<isConnected[j].length;k++){
                        if(!visited[isConnected[j][k]]){
                            visited[isConnected[j][k]] = true;
                            deque.offer(isConnected[j][k]);
                            list.add(isConnected[j][k]);
                        }
                    }
                }
                lists.add(list);
            }
        }
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        return 0;
    }

//    public int findCircleNum(int[][] isConnected) {
//        int count = 0;
//        int n = isConnected.length;
//        boolean[] visited = new boolean[n];
//        List<List<Integer>> lists = new ArrayList<>();
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        for(int i=0;i<n;i++){
//            if(!visited[i]){
//                ArrayList<Integer> list = new ArrayList<>();
//                deque.offer(i);
//                list.add(i);
//                while(!deque.isEmpty()){
//                    int j = deque.poll();
//                    visited[j] =true;
//                    for(int k=0;k<n;k++){
//                        if(isConnected[j][k] ==1 && !visited[k]){
//                            visited[k] = true;
//                            deque.offer(k);
//                            list.add(k);
//                        }
//                    }
//                }
//                lists.add(list);
//                count++;
//            }
//        }
//        for (List<Integer> list : lists) {
//            System.out.println(list);
//        }
//        return count;
//    }
}
