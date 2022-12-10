package com.gestionaleonstage.exception;

/**
 * Classe per la gestione dell'eccezione relativa a un set di dati vuoto
 */
public class EmptySetException extends Exception{
    /**
     * Costruttore di classe vuoto
     */
    public EmptySetException(){}

    /**
     * Costruttore di classe con un messaggio in input per visualizzarlo in caso di errore
     * @param msg String
     */
    public EmptySetException(String msg) {
        super(msg);
    }
}
