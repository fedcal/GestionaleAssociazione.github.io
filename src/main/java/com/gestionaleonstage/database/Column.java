package com.gestionaleonstage.database;

public class Column {
    private String name;
    private String type;

    Column(String name, String type){
        this.name=name;
        this.type=type;
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

    public boolean isNumber() {
        return this.type.equals("number");
    }
    public boolean isDate() {
        return this.type.equals("date");
    }
    public boolean isString() {
        return this.type.equals("string");
    }
}
