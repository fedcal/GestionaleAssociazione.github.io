package com.gestionaleonstage.entity;

import java.util.Date;
import java.util.Map;

/**
 * Classe per rappresentare l'entità Socio
 */
public class Soci implements Comparable<Soci>{
   /**
    * Numero di tessera del socio
    */
   private int tessera;
   /**
    * Data di iscrizione
    */
   private Date dataIscrizione;
   /**
    * Data di approvazione della domanda
    */
   private Date dataApprovazione;
   /**
    * Cognome del socio
    */
   private String cognome;
   /**
    * Nome del socio
    */
   private String nome;
   /**
    * Data di nascita del socio
    */
   private Date nascita;
   /**
    * Luogo di nascita del socio
    */
   private String luogoNascita;
   /**
    * Via di residenza
    */
   private String via;
   /**
    * Città di residenza del socio
    */
   private String citta;
   /**
    * Cap della città di residenza del socio
    */
   private String cap;
   /**
    * Numero di telefono del socio
    */
   private String telefono;
   /**
    * Provincia di residenza del socio
    */
   private String provincia;
   /**
    * Email di recapito del socio
    */
   private String email;
   /**
    * Data annullamento dell'iscrizione del socio
    */
   private Date dataAnnullamento;
   /**
    * Consenso del socio al trattamento dei dati personali
    */
   private String consenso;
   /**
    * Verifica se il socio è minorenne
    */
   private String minorenne;
   /**
    * Note relative al socio
    */
   private String note;

   /**
    * Costruttore di base di classe
    */
   public Soci(){}

   /**
    * Costruttore di classe che avvalora gli attributi di classe
    * @param tessera int Numero identificativo di tessera
    * @param dataIscrizione Date Data di iscrizione, nel formato "yyyy-mm-dd"
    * @param dataApprovazione Date Data di approvazione dell'iscrizione, nel formato "yyyy-mm-dd"
    * @param cognome String Cognome del socio
    * @param nome String Nome del socio
    * @param nascita Date Data di nascita del socio, nel formato "yyyy-mm-dd"
    * @param luogoNascita String Luogo di nascita del socio
    * @param via String Indirizzo di residenza del socio
    * @param citta String Città di residenza
    * @param cap String Cap relativo alla città di residenza
    * @param telefono String Numero di telefono
    * @param provincia String Provincia di residenza del socio
    * @param email String Email di recapito del socio
    * @param dataAnnullamento Date Data di annullamento della richiesta del socio, nel formato "yyyy-mm-dd"
    * @param consenso String Consenso del socio al trattamento dei dati personali
    * @param minorenne String Verifica se il socio è minorenne
    * @param note String Note particolari relative al socio
    */
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

   /**
    * Metodo per ottenere il numero di tessera
    * @return int
    */
   public int getTessera() {
      return tessera;
   }

   /**
    * Metodo per impostare il numero di tessera del socio
    * @param tessera int
    */
   public void setTessera(int tessera) {
      this.tessera = tessera;
   }

   /**
    * Metodo per ottenere la data di iscrizione del socio
    * @return Date Formato "yyyy-mm-dd"
    */
   public Date getDataIscrizione() {
      return dataIscrizione;
   }

   /**
    * Metodo per impostare la data di iscrizione del socio
    * @param dataIscrizione   Date Formato "yyyy-mm-dd"
    */
   public void setDataIscrizione(Date dataIscrizione) {
      this.dataIscrizione = dataIscrizione;
   }

   /**
    * Metodo per ottenere la data di approvazione della richiesta di iscrizione del socio
    * @return String
    */
   public Date getDataApprovazione() {
      return dataApprovazione;
   }

   /**
    * Metodo per impostare la data di approvazione della richiesta di iscrizione del socio
    * @param dataApprovazione String
    */
   public void setDataApprovazione(Date dataApprovazione) {
      this.dataApprovazione = dataApprovazione;
   }

   /**
    * Metodo per ottenere il cognome del socio
    * @return String
    */
   public String getCognome() {
      return cognome;
   }

   /**
    * Metodo per impostare il cognome del socio
    * @param cognome String
    */
   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   /**
    * Metodo per ottenere il nome del socio
    * @return  String
    */
   public String getNome() {
      return nome;
   }

   /**
    * Metodo per impostare il nome del socio
    * @param nome String
    */
   public void setNome(String nome) {
      this.nome = nome;
   }

   /**
    * Metodo per ottenere la data di nascita
    * @return Date Formato "yyyy-mm-dd"
    */
   public Date getNascita() {
      return nascita;
   }

   /**
    * Metodo per impostare la data di nascita del socio
    * @param nascita Date Formato "yyyy-mm-dd"
    */
   public void setNascita(Date nascita) {
      this.nascita = nascita;
   }

   /**
    * Metodo per ottenere il luogo di nascita del socio
    * @return String
    */
   public String getLuogoNascita() {
      return luogoNascita;
   }

   /**
    * Metodo per impostare il luogo di nascita del socio
    * @param luogoNascita String
    */
   public void setLuogoNascita(String luogoNascita) {
      this.luogoNascita = luogoNascita;
   }

   /**
    * Metodo per ottenere l'indirizzo di residenza del socio
    * @return
    */
   public String getVia() {
      return via;
   }

   /**
    * Metodo per impostare l'indirizzo di residenza del socio
    * @param via String
    */
   public void setVia(String via) {
      this.via = via;
   }

   /**
    * Metodo per ottenere la città di residenza del socio
    * @return String
    */
   public String getCitta() {
      return citta;
   }

   /**
    * Metodo per impostare la città di residenza di un socio
    * @param citta String
    */
   public void setCitta(String citta) {
      this.citta = citta;
   }

   /**
    * Metodo per ottenere il cap relativo a un socio
    * @return String
    */
   public String getCap() {
      return cap;
   }

   /**
    * Metodo per impostare il cap relativo al paese di residenza di un socio
    * @param cap String
    */
   public void setCap(String cap) {
      this.cap = cap;
   }

   /**
    * Metodo per ottenere il recapito telefonico di un socio
    * @return String
    */
   public String getTelefono() {
      return telefono;
   }

   /**
    * Metodo per impostare il recapito telefonico di un socio
    * @param telefono String
    */
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   /**
    * Metodo per ottenere la provincia di residenza del socio
    * @return  String
    */
   public String getProvincia() {
      return provincia;
   }

   /**
    * Metodo per impostare la provincia di residenza del socio
    * @param provincia  String
    */
   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }

   /**
    * Metodo per ottenere il recapito E-mail del socio
    * @return  String
    */
   public String getEmail() {
      return email;
   }

   /**
    * Metodo per impostare il reacpito E-mail del socio
    * @param email String
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * Metodo per ottener la data di annullamento del socio
    * @return Date Formato data "yyyy-mm-dd"
    */
   public Date getdataAnnullamento() {
      return dataAnnullamento;
   }

   /**
    * Metodo per impostare la data di annullamento della domanda di iscrizione del socio
    * @param dataAnnullamento Date Formato data "yyyy-mm-dd"
    */
   public void setdataAnnullamento(Date dataAnnullamento) {
      this.dataAnnullamento = dataAnnullamento;
   }

   /**
    * Metodo per conoscere se l'utente ha prestato il consenso per il trattamento dei dati personali
    * @return String "Si" o "No"
    */
   public String getConsenso() {
      return consenso;
   }

   /**
    * Metodo per impostare se l'utente ha prestato il consenso per il trattamento dei dati personali
    * @param consenso String "Si" o "No"
    */
   public void setConsenso(String consenso) {
      this.consenso = consenso;
   }

   /**
    * Metodo che restituisce se un socio è minorenne o meno
    * @return String "Si" o "No"
    */
   public String getMinorenne() {
      return minorenne;
   }

   /**
    * Metodo per impostare se il socio è minorenne o meno
    * @param minorenne String "Si" o "No"
    */
   public void setMinorenne(String minorenne) {
      this.minorenne = minorenne;
   }

   /**
    * Metodo per ottenere le note relativo ad un socio
    * @return  String
    */
   public String getNote() {
      return note;
   }

   /**
    * Metodo per impostare le note di un socio
    * @param note String note
    */
   public void setNote(String note) {
      this.note = note;
   }

   /**
    * Override del toString per la visualizzazione di alcuni dati degli oggetti di tipo Soci
    * @return String
    */
   public String toString(){
      String x="Nome: "+this.nome+" Cognome: "+this.cognome;
      return x;
   }

   /**
    * Funzione che compara due oggetti di tipo Soci per stabilire il maggiore e il minore
    * @param o oggetto da comparare
    * @return int -1 se l'oggetto in input è maggiore, 0 se sono uguali oppure 1 se l'oggetto corrente è maggiore
    */
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