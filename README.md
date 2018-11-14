##Progetto FOOL COMPILER

Corso: Compilatori e Interpreti

Anno Accademico: 2017/2018

Laurea Magistrale in Informatica, Università di Bologna











Realizzato da:

| Vito Vincenzo Covella | Lorenzo Massimiliani | Lorenzo Vainigli |


## Istruzioni per utilizzare il progetto con Eclipse

- Importare il progetto in eclipse:
File → Open projects from file system → Directory → Selezionare la cartella del progetto → Finish.

- Scrivere il codice fool:

Aprendo e modificando il file src/code.fool è possibile scrivere il codice fool che si vuole compilare ed eseguire.

- Eseguire il codice:

Attraverso il Navigator di Eclipse fare click con il tasto destro del mouse sul file src/Main.java e selezionare Run As → Java Application.

Lo stesso procedimento si può fare per lanciare gli unit test della semantica e della code generation, basta eseguire, rispettivamente, src/unitTestSemantics/TestSemantics.java e src/unitTestCodeGen/TestCodeGeneration.java

- Visione del risultato:

Una volta eseguito il codice, mediante la console di Eclipse è possibile osservare eventuali errori trovati durante le diverse fasi della compilazione, il tipo dell&#39;espressione principale del programma, il codice generato nella fase di code generation e, infine, l&#39;ultimo valore presente nello stack, che corrisponderà, al risultato del programma se il tipo del programma non è di tipo void. In quest&#39;ultimo caso si suggerisce di di usare il comando print, ad esempio dopo un comando di assegnamento, per visualizzare il valore di parametri passati a quel comando.









## Struttura del progetto

Il progetto consiste in un compilatore per il linguaggio FOOL, ed è stato realizzato partendo dal codice messo a disposizione per il corso di Compilatori 2017/2018.

Il progetto è così strutturato:

- lib: contiene alcune librerie che sono state utilizzate.
- src/visitors: sono presenti due visitors del codice fool, che visitano il programma e creano l&#39;AST. Inoltre, è presente la classe SVMVisitor, che visitando il codice assembly e producendo il bytecode, ha permesso di eliminare gli attributi della grammatica SVM.
- src/ast: include tutti i nodi dell&#39;albero sintattico astratto e per ognuno di essi è presente il controllo semantico, il controllo dei tipi e la code generation.
- src/exception: contiene tutte le varie eccezioni che possono essere sollevate in seguito al riconoscimento di un errore.
- src/type: contiene le classi java che corrispondono ai tipi del linguaggio.
- src/lib: contiene librerie di supporto alle diverse fasi di compilazione.
- src/parser: al suo interno sono presenti le grammatiche g4 e g4 e tutti i file connessi ad esse generati attraverso Antlr.
- src/vm: racchiude la virtual machine e altre classi per la gestione della memoria.
- src/util: include la virtual table, l&#39;environment.
- src/testDebuggingGeneric: racchiude alcuni programmi di test.
- src/unitTestSemantics:  questa cartella è stata utilizzata per effettuare unit test sui diversi file.fool presenti al suo interno. In particolare i test sono stati effettuati sulla semantica dei programmi.
- src/unitTestCodeGen: cartella di unit test in cui l&#39;oggetto del testing è il risultato dei programmi presenti nella cartella.



















## Analisi lessicale e sintattica

L&#39;analisi lessicale e sintattica viene effettuata automaticamente da ANTLR sfruttando le informazioni della grammatica FOOL.g4 fornita. Le modifiche e aggiunte effettuate su questa grammatica sono discusse nella seguente sezione.

Grammatica FOOL

Per realizzare ed implementare le direttive del progetto sono state effettuate le seguenti modifiche e aggiunte alla grammatica originariamente fornita:

- per impedire la possibilità di dichiarare funzioni annidate, è stata aggiunta una **funlet** diversa dalla **let****.**
- aggiunta di una regola per la dichiarazione di classi
- aggiunta di una regola per utilizzare le classi nella parte **let** e **in** di un programma
- nella regola **value** sono state inserite ulteriori regole per poter effettuare la chiamata di metodi, l&#39;istanziazione di nuovi metodi e l&#39;uso del valore **null**
- regole per i comandi di assegnamento **varasm** e **memberasm**
- regola per poter usare una sequenza di comandi; ogni comando può a sua volta essere un **varasm** , **memberasm** , una **print** , o un **if-then-else** i cui rami sono comandi
- aggiunta di operatori aritmetici e logici (≤, ≥, \&lt;, \&gt;, &amp;&amp;, ||, not, -).



## Visitor della grammatica

Per costruire l&#39;albero sintattico astratto utilizzando l&#39;albero sintattico fornito da FOOLParser è stata implementata l&#39;interfaccia FOOLVisitor, costruita da ANTLR.

L&#39;implementazione del visitor si trova nel file visitors.FOOLVisitorImpl e permette di manipolare e mappare i nodi dell&#39;albero sintattico generato dal parser di ANTLR (indicati con un identificativo nella grammatica FOOL) con i nodi dell&#39;abstract syntax tree, generando l&#39;albero che poi sarà processato dall&#39;analizzatore semantico.

Inoltre, è stato creato un altro visitor, FunctionVisitor, con lo scopo di effettuare una visita anticipata delle funzioni, in modo da poter permettere la ricorsione delle funzioni e la chiamata di una funzione prima della sua dichiarazione.

## Analisi semantica - Scope checking

Dopo che è stato creato l&#39;albero sintattico utilizzando il visitor predisposto da ANTLR, si procede alla fase di scope-checking dell&#39;analisi semantica.

L&#39;interfaccia INode fornisce il metodo checkSemantics() che controlla, tramite una discesa dell&#39;albero sintattico e una seguente verifica bottom-up, la validità semantica del programma.

Secondo l&#39;implementazione delle procedure di controllo semantico, per ogni nodo, in base alla sua tipologia, si controllano il numero di errori seguendo una logica precisa. Se il numero di errori è pari a zero, la fase di analisi semantica è andata a buon fine, altrimenti si arresta il compilatore lanciando delle eccezioni e stampando su terminale gli errori riscontrati.

Le tipologie di analisi semantica più importanti sono riportate di seguito:

- **Espressioni e comandi** : in linea generale, un&#39;espressione o un comando sono corretti se sono corretti le sotto-espressioni o i sotto-comandi che le compongono. Analizzando la singola espressione o il singolo comando, il controllo sulla correttezza semantica varia in base alla tipologia di espressione/comando.
- **Assegnamenti** : l&#39;analisi semantica controlla che la variabile left-hand side sia già stata dichiarata. Controllare che il valore assegnato (right-hand side) sia di un tipo che si può assegnare alla variabile è compito della fase di type checking.
- **Operatori binari** : il nodo che rappresenta un&#39;operazione binaria è semanticamente corretto se lo sono i due operandi coinvolti.
- **Dichiarazione di variabile** : la variabile viene aggiunta alla symbol table dello scope corrente; se è già presente una variabile con quel nome, viene restituito un errore (VariableAlreadyDefinedException). Se la variabile ha il tipo di una classe, la classe deve essere già stata definita, altrimenti è un&#39;errore di UndefinedClassException.
- **Dichiarazione di funzione** : il controllo semantico è corretto se il nome della funzione non è già stato dichiarato, tipo ritornato dichiarato e tipo ritornato effettivo coincidono e l&#39;analisi semantica del body della funzione non produce errori.
- **Chiamata di funzione** : la funzione in questione deve essere stata definita nel codice, non necessariamente prima della chiamata, il numero dei parametri attuali deve essere coerente con quanto espresso nella dichiarazione di funzione e il controllo semantico su di essi deve essere corretto.
- **Dichiarazione di classe** : il nome della classe deve essere univoco e l&#39;analisi semantica sui membri deve essere corretta. Nel caso che la classe estenda una superclasse, viene controllato che la superclasse sia stata dichiarata e che la sottoclasse contenga tutti i membri della superclasse, ai quali se ne possono aggiungere altri.
- **Istanziazione di oggetti** : un oggetto creato con l&#39;operatore new deve essere istanza di una classe già dichiarata e inizializzare i membri secondo le direttive della sintassi FOOL. Come nella chiamata di funzione, il numero dei parametri attuali e il controllo semantico su di essi deve essere corretto.
- **Chiamata di metodi** : l&#39;oggetto che si utilizza per chiamare il metodo deve essere istanza di una classe nella quale è dichiarato quel metodo, oppure il metodo deve appartenere ad una sua superclasse. Il numero dei parametri attuali deve coincidere con il numero dei parametri formali e il controllo semantico su di essi deve essere corretto.

























## Analisi semantica - Type checking

Il type checking viene effettuato in ogni nodo dell&#39;AST in maniera bottom-up. Nello specifico, ogni nodo, che estende l&#39;interfaccia INode, implementa il metodo typeCheck() all&#39;interno del quale sono inserite le regole di inferenza. I tipi sono a loro volta implementati in classi separate da quelle che implementano i nodi e sono i seguenti:

- IntType
- BoolType
- FunctionType (rappresenta il tipo funzione (D1 x D2 x … x Dn) -\&gt; T )
- ClassType
- NullType
- VoidType

Ognuno dei tipi menzionati, implementati estendendo l&#39;interfaccia IType, fornisce i metodi TypeID getTypeID() e boolean isSubtypeOf(IType type), quest&#39;ultimo usato per le regole di subtyping.

Il metodo isSubtypeOf di NullType è implementato in maniera tale da rendere questo tipo subtype di qualunque ClassType, consentendo quindi all&#39;utente di non inizializzare subito le classi nelle dichiarazioni e permettendogli di assegnare null.

Lato utente, la grammatica rende disponibile le seguenti keywords per i tipi:

- int
- bool
- qualunque identificatore che cominci con un carattere e contenga caratteri e cifre per indicare ClassType
- null
- void









## Code generation

Ogni nodo dell&#39;albero sintattico, generato dalla grammatica FOOL.g4 e presente nella cartella src/ast, ha un proprio metodo di code generation. Qui di seguito verranno presentate le nuove istruzioni inserite nel progetto allo scopo di gestire le classi e gli oggetti.

**NEW** : istruzione che viene inserita da NewNode, al momento della creazione di un oggetto.

**CALCHOFF** : istruzione inserita da IdNode nel caso in cui l&#39;Id in questione rappresenti un attributo. Permette di convertire l&#39;offset logico nell&#39;offset fisico all&#39;interno di una classe.

**LC** : istruzione aggiunta da MethodCallNode, che serve per trovare l&#39;indirizzo del metodo chiamato.

**COPY** : istruzione aggiunta da MethodCallNode, che copia il valore sopra allo stack.

**MM** : istruzione aggiunta da MemberAsmNode, che permette di aggiornare il valore di celle di memoria di un oggetto all&#39;interno delle quali sono memorizzati i dati dei campi.

## Grammatica SVM

La grammatica SVM.g4 è stata resa senza attributi. Al suo posto è stata aggiunta una classe java al percorso visitors/SVMVisitor.  Essa fa una visita al codice generato dal processo di code generation e genera il bytecode che verrà eseguito dalla virtual Machine.

Ad esempio l&#39;istruzione che originariamente era:

POP                   {code[i++] = POP;}

E&#39; stata rimpiazzata con la seguente visita:

            public Object visitPop(SVMParser.PopContext ctx)
            {       addCode(SVMParser.POP);
                        return null;        }

## Esecuzione del codice

La classe vm/VirtualMachine esegue il bytecode. Verrà mostrato il comportamento della virtual machine con le istruzioni presentate nella sezione della code generation.

**NEW** : vengono fatte due pop per ottenere il valore della dispatch table e il numero di argomenti passati al costruttore, allo scopo di ottenere sempre tramite pop tutti gli argomenti. Questi elementi vengono allocati nello heap e rappresentano l&#39;oggetto in memoria. Il new gestisce anche il caso di una mancata inizializzazione della classe, in questo caso viene inserito nello stack il valore -1, che per convenzione è stato associato al tipo NULL e verrà gestito di conseguenza

**CALCHOFF** : vengono recuperate con delle pop e degli accessi nello heap le informazioni riguardanti l&#39;offset dell&#39;oggetto e del campo a cui si vuole accedere. Viene poi fatto il push sullo stack di questi dati.

**LC** : con una pop si ottiene l&#39;indirizzo a cui si vuole accedere e viene fatta, in seguito, una push del codice trovato all&#39;indirizzo precedente.

**COPY** : si accede in memoria all&#39;indirizzo puntato dallo stack pointer, che viene poi inserito nello stack.

**MM** : vengono recuperate con delle pop il nuovo valore da assegnare al campo dell&#39;oggetto, l&#39;indirizzo dell&#39;oggetto in memoria e l&#39;indice che indica la posizione del campo rispetto allo start address dell&#39;oggetto. Si ricava l&#39;indirizzo fisico del campo dagli ultimi due valori precedentemente menzionati e viene aggiornato il contenuto della memoria puntata da quell&#39;indirizzo. Viene quindi effettuato il push del nuovo valore del campo sullo stack (questa push serve per i successivi pezzi di codegen che caricano valori sul registro rv per il return value).







## Dispatch table

Ad ogni classe definita in FOOL dall&#39;utente è associata una dispatch table contenente le label dei metodi che possono essere chiamati con oggetti della specifica classe. Il layout della dispatch table è realizzato in maniera tale da mantenere inalterato l&#39;offset (distanza dall&#39;inizio della dispatch table) dei metodi ereditati e dei metodi definiti tramite overriding; per questi ultimi, pur mantenendo inalterato il precedentemente citato offset, ci sarà una nuova label relativa al metodo che sovrascrive quello di uno dei parent.

Quando il codice viene eseguito, il metodo patchCodeWithIndexes() rimpiazza tutte le label con gli indirizzi a cui fanno riferimento, comprese le label dei metodi della dispatch table. Quindi, supponendo che non siano rilevati errori da checkSemantics() e typeChecking(), quando viene effettuata la chiamata di un metodo in sintesi avvengono i seguenti eventi:

1. si risale all&#39;indirizzo dell&#39;oggetto in memoria, presente nel frame in cui è stato istanziato;
2. si ottiene dalla prima cella dell&#39;oggetto l&#39;indirizzo della dispatch table dell&#39;oggetto che sta chiamando il metodo (quindi si ottiene l&#39;indirizzo della dispatch table del tipo dinamico); tale indirizzo è stato precedentemente memorizzato dalle istruzioni che si occupano di gestire l&#39;operatore new;
3. si somma a questo indirizzo l&#39;offset del metodo rispetto all&#39;inizio della dispatch table, ottenendo l&#39;indirizzo della cella di memoria in cui è memorizzato l&#39;indirizzo del metodo;
4. si carica l&#39;indirizzo del metodo sullo stack per poter effettuare il salto all&#39;indirizzo del metodo.

In questo modo, come accennato nel punto 2, risulta implementato il dynamic dispatching, permettendo all&#39;utente di invocare il metodo della child class, che può sovrascrivere quello della parent class, usando una variabile di tipo superclasse.







## Licenza

Quest&#39;opera è distribuita con Licenza Creative Commons Attribuzione - Non commerciale 4.0 Internazionale.