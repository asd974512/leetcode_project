package second_tyy.other;

import java.util.*;

public class example {

    int x = 0;

    static  int staticX = 1;

    public static void main(String[] args){
        int y = 0;

        int[] arrys = {1,2,3};
        int[] xx = new int[3];

        String x = "123";
        String yy = "344";

        ArrayList<String> list = new ArrayList<>(Arrays.asList("apy","djio","cjeo"));

        Collections.sort(list,new Comparator<String>(){

            @Override
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });

//
//        Integer x1 = new Integer(100);
//        Integer x2 = new Integer(100);
//
//        System.out.println(x1==x2);
//
//        Integer x3 = 100;
//        Integer x4 = 100;
//
//        System.out.println(x3==x4);
//
//
//        Integer x5 = 200;
//        Integer x6 = 200;
//
//        System.out.println(x5==x6);

        HashSet<String> strings = new HashSet<>();

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();


    }


    public static void exceptionTest() {

        int a = 0;

        try {
            int x = a/0;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        throw new RuntimeException();
    }

}

