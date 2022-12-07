package com.gestionaleonstage.database;

import java.util.ArrayList;
import java.util.List;

public class Example {
    private List<Object> example=new ArrayList<Object>();

    public Example(){}

    public void add(Object o){
        this.example.add(o);
    }
    public Object get(int i){
        return this.example.get(i);
    }
}
