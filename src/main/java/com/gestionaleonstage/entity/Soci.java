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
     * Luogo di nascita
     */
    private String luogoNascita;
    /**
     * Indirizzo di residenza
     */
    private String via;
    /**
     * Città di residenza
     */
    private String citta;
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

    private Boolean minorenne;

    private Boolean consenso;

    public Soci(){

    }

    public Soci(int tessera, String nome, String cognome, String luogoNascita, String via, String citta, String cap, String provincia, String cellulare, String email, Date annullamentoIscrizione, Date dataPresentazione, Date dataApprovazione, Date dataNascita, Boolean minorenne, Boolean consenso) {
        this.tessera = tessera;
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.via = via;
        this.citta = citta;
        this.cap = cap;
        this.provincia = provincia;
        this.cellulare = cellulare;
        this.email = email;
        this.annullamentoIscrizione = annullamentoIscrizione;
        this.dataPresentazione = dataPresentazione;
        this.dataApprovazione = dataApprovazione;
        this.dataNascita = dataNascita;
        this.minorenne = minorenne;
        this.consenso = consenso;
    }

    public Boolean getMinorenne() {
        return minorenne;
    }

    public void setMinorenne(Boolean minorenne) {
        this.minorenne = minorenne;
    }

    public Boolean getConsenso() {
        return consenso;
    }

    public void setConsenso(Boolean consenso) {
        this.consenso = consenso;
    }

    public int getTessera() {
        return tessera;
    }

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

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
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
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
}