package com.gestionaleonstage.database;

public class Column {
    private String name;
    private String type;

    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public boolean isNumber(){
        return this.type.equals("number");
    }
    public boolean isVarChar(){
        return this.type.equals("string");
    }
    public boolean isDate(){
        return this.type.equals("date");
    }

    public String toString(){
        return this.name+":"+this.type;
    }

    public boolean isFloater() {
        return this.type.equals("floater");
    }
}
