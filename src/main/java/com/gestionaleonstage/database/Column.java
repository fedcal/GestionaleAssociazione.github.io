package com.gestionaleonstage.database;

/**
 * Rappresentazione delle colonne all'interno di una tabella presente nel database
 */
public class Column {
    /**
     * Nome della colonna
     */
    private String name;
    /**
     * Tipo della colonna
     */
    private String type;

    /**
     * Costruttore di classe che valorizza gli attributi di classe
     * @param name String nome della colonna
     * @param type String tipo della colonna
     */
    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Restituisce il nome della colonna
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Impostare il nome della colonna
     * @param name String nome colonna
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il tipo della colonna
     * @return String
     */
    public String getType() {
        return type;
    }


    /**
     * Imposta il tipo della colonna
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Verifica se il tipo della colonna è un numero
     * @return boolean
     */
    public boolean isNumber(){
        return this.type.equals("number");
    }

    /**
     * Verifica se il tipo della colonna è una stringa
     * @return boolean
     */
    public boolean isVarChar(){
        return this.type.equals("string");
    }

    /**
     * Verifica se il tipo della colonna è di tipo Date
     * @return boolean
     */
    public boolean isDate(){
        return this.type.equals("date");
    }

    /**
     * Sovrascrive il metodo toString per poter rappresentare nella maniera corretta gli attributi di classe
     * @return String
     */
    @Override
    public String toString(){
        return this.name+":"+this.type;
    }

    /**
     * Verifica se una colonna contiene valori di tipo Float
     * @return boolean
     */
    public boolean isFloater() {
        return this.type.equals("floater");
    }
}
