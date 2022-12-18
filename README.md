# Gestionale associazione

Questo progetto nasce con l'intenzione di creare una desktop application che aiuti nella gestione
organizzativa di un'associazione. L'implementazione è fatta basandomi sull'associazione [OnStage](https://www.instagram.com/onstageaps/),
di cui faccio parte.

In questa sezione descrivo il setup dell'ambiente e come installarlo. Per la documentazione del codice ho creato la seguente
[pagina](https://fedcal.github.io/GestionaleAssociazione.github.io/com.gestionaleonstage/module-summary.html) consultabile, mentre la descrizione del progetto comprensiva di analisi dei requisiti e successivi sviluppi
viene riportata nel mio [blog personale](https://www.federicocalo.dev/blog).

Se si vuole utilizzare il programma seguire i seguenti step:

**STEP 1**

Installa MySQL e crea in locale il database "associazione". Ricorda di impostare come utente primario l'usurname root con password root.
In caso contrario bisogna modificare gli attributi USER_ID e PASSWORD nella classe DbConnection.

**STEP 2**

Clonare il progetto e aprirlo con un IDE che supporta Java. Eseguire il comando ```mvn clean install``` per scaricare tutte le 
dipendenze, successivamente eseguire il commando ```mvn package``` per generare il jar all'interno della cartella "eseguibile".
Infine entrate nella cartella "eseguibile" e avviate lo script avvio.bat che si occuperà di avviare il programma.