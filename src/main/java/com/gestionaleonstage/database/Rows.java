package com.gestionaleonstage.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rows implements Comparable<Rows>,Iterable<Object>{
    private List<Object> rows = new ArrayList<Object>();
    public Rows(){}
    public void add(Object o){
        this.rows.add(o);
    }
    public Object get(int i){
        return this.rows.get(i);
    }

    public int compareTo(Rows ex){
        int i=0;
        for (Object o:ex.rows){
            if(!o.equals(this.rows.get(i)))
                return ((Comparable)o).compareTo(this.rows.get(i));
            i++;
        }
        return 0;
    }

    public String toString(){
        String str="";
        for(Object o:rows)
            str+=o.toString()+ " ";
        return str;
    }

    @Override
    public Iterator<Object> iterator() {

        return null;
    }
}
