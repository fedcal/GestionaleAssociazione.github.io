package com.gestionaleonstage.entity;

import java.util.Date;

public class Soci {
    private int tessera;
    private String nome;
    private String cognome;
    private String luogoNascita;
    private String indirizzo;
    private String localita;
    private String cap;
    private String provincia;
    private String cellulare;
    private String email;
    private String scopo;
    private Date annullamentoIscrizione;
    private Date dataPresentazione;
    private Date dataApprovazione;
    private Date dataNascita;

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
