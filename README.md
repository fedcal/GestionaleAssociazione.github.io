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

La prima entità che viene schematizzata è l'entità **socio**, la quale avrà i seguenti campi:
- **idTessera**: numero prograssivo di tessera sociale
- **dataPresentazione**: data in cui viene presentata la domanda d'iscrizione
- **dataApprovazione**: data in cui viene approvata la domanda d'iscrizione
- **cognome**: cognome dell'associato
- **nome**: nome dell'associato
- **dataNascita**: data di nascita dell'associato
- **luogoNascita**: luogo di nascita dell'associato
- **nazionalita**: nazionalità dell'associato
- **idirizzo**: indirizzo di casa dell'associato
- **localita**: città in cui risiede il socio
- **cap**: CAP della città in cui risiede l'associato
- **provincia**: provincia di residenza
- **cellulare**: cellulare dell'associato
- **email**: email del socio
- **dataAnnullamento**: data annullamento iscrizione
- **note**: note sull'associato

## Installazione e Configurazione

## Linguaggi, librerie e tools utilizzati

Per il progetto si ho deciso di utilizzare JavaFX per lo sviluppo dell'interfaccia, in quanto avevo già 
esperienza con questo linguaggio; mentre per la gestione della business logic interna al programma ho utilizzato
il linguaggio Java. Lo strato di persistenza è stato creato con un database sviluppato con MySql, creando un
db in locale.