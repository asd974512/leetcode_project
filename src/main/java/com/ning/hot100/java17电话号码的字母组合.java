package com.ning.hot100;

import java.util.ArrayList;
import java.util.List;

public class java17电话号码的字母组合 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("23");
        for (String string : strings) {
            System.out.print (string+"  ");
        }
    }
}

class Solution17 {

    String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        ArrayList<String> list = new ArrayList<>();
        if(length==0){
            return list;
        }
        dfs(list,0,length,digits,"");
        return list;
    }

    public void dfs(List<String> list,int index,int length,String digits,String str){
        if(index==length){
            list.add(str);
            return;
        }
        int number = digits.charAt(index)-'0';
        String string = strings[number];
        for(int i=0;i<string.length();i++){
            dfs(list,index+1,length,digits,str+string.charAt(i));
        }
    }
}