package com.ning;

import java.util.Objects;

public class Student {
    int a;
    Student(int a ){
        this.a = a;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
