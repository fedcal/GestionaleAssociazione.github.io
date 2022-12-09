package com.gestionaleonstage.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta una riga all'interno di una tabella di un database
 */
public class Example {
    /**
     * Lista rappresentante la riga all'interno della tabella
     */
    private List<Object> example=new ArrayList<Object>();

    /**
     * Costruttore di base della classe
     */
    public Example(){}

    /**
     * Metodo per aggiungere un oggetto alla lista
     * @param o Object
     */
    public void add(Object o){
        this.example.add(o);
    }

    /**
     * Metodo per ottenere un dato elemento all'interno della lista
     * @param i int indice che rappresenta la posizione all'interno della lista
     * @return Object
     */
    public Object get(int i){
        return this.example.get(i);
    }
}
