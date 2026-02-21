package again;

import java.util.Scanner;

public class java回文数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int number = sc.nextInt();
            solution(number);
        }
    }

    public static void solution(int number){
        String strNumber = Integer.toString(number);
        char[] chars = strNumber.toCharArray();
        int length = strNumber.length();
        for(int i=0;i<length/2;i++){
            if(chars[i]!=chars[length-1-i]){
                System.out.println("false");
                return ;
            }
        }
        System.out.println("true");
    }
}