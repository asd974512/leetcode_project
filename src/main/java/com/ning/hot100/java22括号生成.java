package com.ning.hot100;


import java.util.ArrayList;
import java.util.List;

public class java22括号生成 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> list = solution22.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        dfs(list, str,0,0,n);
        return list;
    }
    public void dfs(List<String> list,StringBuffer str,int left,int right,
                    int depth){
        if(left<right || left>depth){
            return;
        }
        if(left==right && left ==depth){
            String s = str.toString();
            list.add(s);
            return;
        }
        str.append('(');
        dfs(list,str,left+1,right,depth);
        str.deleteCharAt(str.length()-1);
        str.append(')');
        dfs(list,str,left,right+1,depth);
        str.deleteCharAt(str.length()-1);
    }
}
