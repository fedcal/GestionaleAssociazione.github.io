package com.gestionaleonstage.entity;

import java.util.Date;
import java.util.Map;

/**
 * Classe perr rappresentare l'entità Socio
 */
public class Soci {
    /**
     * Numero della tesserra del socio
     */
    private int tessera;
    /**
     * Nome del socio
     */
    private String nome;
    /**
     * Cognome del socio
     */
    private String cognome;
    /**
     *Luogo di nascita
     */
    private String luogoNascita;
    /**
     * Indirizzo di residenza
     */
    private String indirizzo;
    /**
     * Città di residenza
     */
    private String localita;
    /**
     * Cap della città
     */
    private String cap;
    /**
     * Provincia della città di residenza
     */
    private String provincia;
    /**
     * Numero di cellulare
     */
    private String cellulare;
    /**
     * Email del socio
     */
    private String email;
    /**
     * Scopo: se è un socio o ha una carica nel direttivo
      */
    private String scopo;
    /**
     * Data di annullamento iscrizione
     */
    private Date annullamentoIscrizione;
    /**
     * Data presentazione domanda
     */
    private Date dataPresentazione;
    /**
     * Data di approvazione della domanda
     */
    private Date dataApprovazione;
    /**
     * Data di nascita
     */
    private Date dataNascita;

    /**
     * Cotruttore di classe per valorizzare i campi
     *
     * @param tessera Numero della tesserra del socio
     * @param nome Nome del socio
     * @param cognome Cognome del socio
     * @param luogoNascita Luogo di nascita
     * @param indirizzo Indirizzo di residenza
     * @param localita Città di residenza
     * @param cap Cap della città
     * @param provincia Provincia della città di residenza
     * @param cellulare Numero di cellulare
     * @param email Email del socio
     * @param scopo Scopo: se è un socio o ha una carica nel direttivo
     * @param annullamentoIscrizione Data di annullamento iscrizione
     * @param dataPresentazione Data presentazione domanda
     * @param dataApprovazione Data di approvazione della domanda
     * @param dataNascita Data di nascita
     */
    public Soci(int tessera, String nome, String cognome, String luogoNascita, String indirizzo, String localita, String cap, String provincia, String cellulare, String email, String scopo, Date annullamentoIscrizione, Date dataPresentazione, Date dataApprovazione, Date dataNascita) {
        this.tessera = tessera;
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.indirizzo = indirizzo;
        this.localita = localita;
        this.cap = cap;
        this.provincia = provincia;
        this.cellulare = cellulare;
        this.email = email;
        this.scopo = scopo;
        this.annullamentoIscrizione = annullamentoIscrizione;
        this.dataPresentazione = dataPresentazione;
        this.dataApprovazione = dataApprovazione;
        this.dataNascita = dataNascita;
    }

    /**
     * Ottenere il numero tessera
     *
     * @return int
     */
    public int getTessera() {
        return tessera;
    }

    /**
     * Impostare il numero della tessera
     *
     * @param tessera  int
     */
    public void setTessera(int tessera) {
        this.tessera = tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScopo() {
        return scopo;
    }

    public void setScopo(String scopo) {
        this.scopo = scopo;
    }

    public Date getAnnullamentoIscrizione() {
        return annullamentoIscrizione;
    }

    public void setAnnullamentoIscrizione(Date annullamentoIscrizione) {
        this.annullamentoIscrizione = annullamentoIscrizione;
    }

    public Date getDataPresentazione() {
        return dataPresentazione;
    }

    public void setDataPresentazione(Date dataPresentazione) {
        this.dataPresentazione = dataPresentazione;
    }

    public Date getDataApprovazione() {
        return dataApprovazione;
    }

    public void setDataApprovazione(Date dataApprovazione) {
        this.dataApprovazione = dataApprovazione;
    }

    public Date getDataNascita() {
        return this.dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
}
