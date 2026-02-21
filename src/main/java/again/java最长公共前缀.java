package again;

import java.util.Scanner;

public class java最长公共前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            solution(strs);
        }
    }

    public static void solution(String[] strs) {
        int min = Integer.MAX_VALUE;
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return;
        }
        if (strs.length == 1) {
            System.out.println(strs[0]);
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (min >= strs[i].length()) {
                min = strs[i].length();
            }
        }
        if (min == 0) {
            System.out.println("");
            return;
        }
        boolean isSame = true;
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length - 2; j++) {
                if(strs[j].charAt(i)!=strs[j+1].charAt(i)){
                    isSame=false;
                    break;
                }
            }
            if(!isSame){
                min = i;
                break;
            }
        }
        System.out.println(strs[0].substring(0,min));
    }
}

