package nowcode;
import java.util.*;

public class java字符串最后一个长度{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split(" ");
            System.out.println(str[str.length-1].length());
        }
    }
}
