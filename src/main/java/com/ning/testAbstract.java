package com.ning;

public  abstract class testAbstract {

    int age = 19;

    public  void print(){
        System.out.println("这是一个抽象类");
    }

    public void grow(){
        age++;
    }
    public void printAge(){
        System.out.println(age);
    }
}
