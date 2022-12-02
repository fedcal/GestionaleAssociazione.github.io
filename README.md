# Gestionale associazione

Questo progetto nasce con l'intenzione di creare una desktop application che aiuti nella gestione
organizzativa di un'associazione. L'implementazione è fatta basasndomi sull'associazione [OnStage](https://www.instagram.com/onstageaps/),
di cui faccio parte.

In questa sezione descrivo il proggetto, annotando tutti gli sviluppi, il setup dell'ambiente e come installarlo.

## Analisi dei requisiti

Si sono individuate diverse aree da sviluppare, in base alle varie esigenze. La prima è l'aria **soci** che dovrà
possedere le seguenti funzionalità:
- Aggiungere un socio
- Visualizzare i soci con le relative informazioni
- Modificare o eliminare un socio

La seconda area individuata è l'area destinata agli **Eventi** con le seguenti funzionalità:
- Aggiungere un evento in programma
- Visualizzare gli eventi effettuati durante il corso del tempo
- Modificare le informazioni di un evento
- Gestire l'evento a livello di entrate, uscite e di organizzazione dei vari gruppi di lavoro.

L'area più importante è l'area **Gestione** che riguarda tutta la parte relativa all'area legale, economica e 
alle statistiche.

Infine viene prevista un'area per effettuare alcune operazioni a livello di codice.

## Gestione database

Riporto lo schema ER realizzato attraverso l'applicazione desktop di [draw.io](https://app.diagrams.net/).
![ER generale](./schema/Entity%20Relationship%20db-ER%20-%20view%201.drawio.png)

La prima entità che viene schematizzata è l'entità **socio**, la quale avrà i seguenti campi:
- **tessera**: numero prograssivo di tessera sociale
- **data_iscrizione**: data in cui viene presentata la domanda d'iscrizione
- **data_aaprovazione**: data in cui viene approvata la domanda d'iscrizione
- **cognome**: cognome dell'associato
- **nome**: nome dell'associato
- **nascita**: data di nascita dell'associato
- **luogo_nascita**: luogo di nascita dell'associato
- **idirizzo**: indirizzo di casa dell'associato composto da tre campi:
  - **citta**: la citrà di residenza
  - **cap**: il cap
  - **via**: la via comprensiva di civico
- **cellulare**: cellulare dell'associato
- **email**: email del socio
- **data_annullamento**: data annullamento iscrizione
- **note**: note sull'associato

Ogni associato ha un ruolo all'interno di un'associazione, in questo caso prevediamo come ruoli:
- *socio semplice*: il quale partecipa alle assemblee associative e alla vita associativa
- *il presidente*: il presidente dell'associazione che rappresenta l'associazione
- *il vicepresidente*: il vicepresidente dell'asociazione che svolge le veci del presidente in sua assenza
- *il segretariio*: i cui compiti sono quelli di verbalizzare le riunioni e altri compiti previsti dallo statuto

Per rappresentare questa entità all'interno del database viene creata la tabella **ruolo** con i seguenti ruoli:
- **id_ruolo**: chiave iidentificante il ruolo all'interno della tabella
- **titolo**: nome del ruolo
- **compito**: compiti a lui concessi, con una piccola descrizione

Per rappresentare la relazione tra le due entità ruoli e soci, si crea la tabella **stato**, formata dai seguenti compiti:
- **id_stato**: id della relazione
- **id_socio**: id del socio
- **id_ruolo**: id del ruolo associato al socio

Inoltre si cerca di rappresentare i vari eventi che vengono gestiti dall'associazione nei diversi loro aspetti sia economici
sia di gruppi creati per la gestione. In riferimento a questo viene rappresentata l'erntità evento attraverso la relativa tabella
**evento** con le seguenti proprietà:
- **id_eventp**: codice identificativo dell'evento
- **nome**: nome dell'evento
- **descrizione**: descrizione dell'evento

Si vuole rappresentare l'entità che andrà a collezionare tutti glii eventi creati durante l'arco dell'anno, iin questo caso vine 
istanziata l'entità **evento_creato** la quale possiede i seguentii campi:

- **id_creato**: id dell'evento creato in una certa data
- **id_evento**: id dell'evento che abbiamo creato
- **data**: data dell'evento

Molto importante, sia a livello di statistiche sia per migliorare l'organizzazione interna, è il fatto dii poter conoscere
le persone e i gruppii coinvolti all'interno di un evento. Rappresentiamo quindi la relazione **partecipazione**, con la relativa
tabella, nella quale inseriamo i seguentii campi:
- **id_partecipazione**: identificativo della partecipazione
- **id_creato**: identificativo dell'evento realizzato
- **id_soocio**: identificativo del socio che ha contribuito alla creazione dell'evento
- **gruppo**: gruppo di appertenza del socio che ha contribuito all'evento


## Installazione e Configurazione

## Linguaggi, librerie e tools utilizzati

Per il progetto si ho deciso di utilizzare JavaFX per lo sviluppo dell'interfaccia, in quanto avevo già 
esperienza con questo linguaggio; mentre per la gestione della business logic interna al programma ho utilizzato
il linguaggio Java. Lo strato di persistenza è stato creato con un database sviluppato con MySql, creando un
db in locale.

## Link consultati

- [[1]](https://stackoverflow.com/questions/4702728/relational-table-naming-convention) Best practice of naming DB.