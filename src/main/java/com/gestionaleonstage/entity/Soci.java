package com.gestionaleonstage.entity;

import java.util.Date;
import java.util.Map;

/**
 * Classe perr rappresentare l'entità Socio
 */
public class Soci implements Comparable<Soci>{
   private int tessera;
   private Date dataIscrizione;
   private Date dataApprovazione;
   private String cognome;
   private String nome;
   private Date nascita;
   private String luogoNascita;
   private String via;
   private String citta;
   private String cap;
   private String telefono;
   private String provincia;
   private String email;
   private Date dataAnnullamento;
   private String consenso;
   private String minorenne;
   private String note;

   public Soci(){}
   public Soci(int tessera, Date dataIscrizione, Date dataApprovazione, String cognome, String nome, Date nascita, String luogoNascita, String via, String citta, String cap, String telefono, String provincia, String email, Date dataAnnullamento, String consenso, String minorenne, String note) {
      this.tessera = tessera;
      this.dataIscrizione = dataIscrizione;
      this.dataApprovazione = dataApprovazione;
      this.cognome = cognome;
      this.nome = nome;
      this.nascita = nascita;
      this.luogoNascita = luogoNascita;
      this.via = via;
      this.citta = citta;
      this.cap = cap;
      this.telefono = telefono;
      this.provincia = provincia;
      this.email = email;
      this.dataAnnullamento = dataAnnullamento;
      this.consenso = consenso;
      this.minorenne = minorenne;
      this.note = note;
   }

   public int getTessera() {
      return tessera;
   }

   public void setTessera(int tessera) {
      this.tessera = tessera;
   }

   public Date getDataIscrizione() {
      return dataIscrizione;
   }

   public void setDataIscrizione(Date dataIscrizione) {
      this.dataIscrizione = dataIscrizione;
   }

   public Date getDataApprovazione() {
      return dataApprovazione;
   }

   public void setDataApprovazione(Date dataApprovazione) {
      this.dataApprovazione = dataApprovazione;
   }

   public String getCognome() {
      return cognome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Date getNascita() {
      return nascita;
   }

   public void setNascita(Date nascita) {
      this.nascita = nascita;
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

   public String getTelefono() {
      return telefono;
   }

   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   public String getProvincia() {
      return provincia;
   }

   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Date getdataAnnullamento() {
      return dataAnnullamento;
   }

   public void setdataAnnullamento(Date dataAnnullamento) {
      this.dataAnnullamento = dataAnnullamento;
   }

   public String getConsenso() {
      return consenso;
   }

   public void setConsenso(String consenso) {
      this.consenso = consenso;
   }

   public String getMinorenne() {
      return minorenne;
   }

   public void setMinorenne(String minorenne) {
      this.minorenne = minorenne;
   }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

   public String toString(){
      String x="Nome: "+this.nome+" Cognome: "+this.cognome;
      return x;
   }

   @Override
   public int compareTo(Soci o) {
      if(this.nome.compareTo(o.getNome()) <0){
         return -1;
      } else if (this.nome.compareTo(o.getNome())>0) {
         return 1;
      }
      return 0;
   }
}