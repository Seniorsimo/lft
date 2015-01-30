package lft.sett5;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * Un oggetto della classe NFA rappresenta un automa a stati finiti non
 * deterministico con epsilon transizioni
 */
public class NFA {

    /**
     * Usiamo il carattere nullo per rappresentare una epsilon transizione
     */
    public static final char EPSILON = '\0';

    /**
     * Numero degli stati dell'automa. Ogni stato e` rappresentato da un numero
     * interno non negativo, lo stato con indice 0 e` lo stato iniziale.
     */
    private int numberOfStates;

    /**
     * Insieme degli stati finali dell'automa.
     */
    private HashSet<Integer> finalStates;

    /**
     * Funzione di transizione dell'automa, rappresentata come una mappa da
     * mosse a insiemi di stati di arrivo.
     */
    private HashMap<Move, HashSet<Integer>> transitions;

    /**
     * Crea un NFA con un dato numero di stati.
     *
     * @param n Il numero di stati dell'automa.
     */
    public NFA(int n) {
        numberOfStates = n;
        finalStates = new HashSet<Integer>();
        transitions = new HashMap<Move, HashSet<Integer>>();
    }

    /**
     * Aggiunge uno stato all'automa.
     *
     * @return L'indice del nuovo stato creato
     */
    public int newState() {
        return numberOfStates++;
    }

    /**
     * Aggiunge uno stato finale.
     *
     * @param p Lo stato che si vuole aggiungere a quelli finali.
     * @return <code>true</code> se lo stato e` valido, <code>false</code>
     * altrimenti.
     */
    public boolean addFinalState(int p) {
        if (validState(p)) {
            finalStates.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determina se uno stato e` valido oppure no.
     *
     * @param p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` valido, <code>false</code>
     * altrimenti.
     * @see #numberOfStates
     */
    public boolean validState(int p) {
        return (p >= 0 && p < numberOfStates);
    }

    /**
     * Determina se uno stato e` finale oppure no.
     *
     * @param p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` finale, <code>false</code>
     * altrimenti.
     * @see #finalStates
     */
    public boolean finalState(int p) {
        return finalStates.contains(p);
    }

    /**
     * Restituisce il numero di stati dell'automa.
     *
     * @return Numero di stati.
     */
    public int numberOfStates() {
        return numberOfStates;
    }

    /**
     * Aggiunge una transizione all'automa.
     *
     * @param p Lo stato di partenza della transizione.
     * @param ch Il simbolo che etichetta la transizione.
     * @param q Lo stato di arrivo della transizione.
     * @return <code>true</code> se lo stato di partenza e lo stato di arrivo
     * sono validi, <code>false</code> altrimenti.
     */
    public boolean addMove(int p, char ch, int q) {
        //DA IMPLEMENTARE 5.1
        if (validState(p) && validState(q)) {
            Move m = new Move(p, ch);
            if (!transitions.containsKey(m)) {
                transitions.put(m, new HashSet<Integer>());
            }
            transitions.get(m).add(q);
            return true;
        }
        return false;
    }

    /**
     * Determina se c'e` uno stato finale in un insieme di stati.
     *
     * @param s L'insieme di stati da controllare.
     * @return <code>true</code> se c'e` uno stato finale in <code>s</code>,
     * <code>false</code> altrimenti.
     * @see #finalStates
     */
    private boolean finalState(HashSet<Integer> s) {
        for (int i : s) {
            if (finalState(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Restituisce l'alfabeto dell'automa, ovvero l'insieme di simboli che
     * compaiono come etichette delle transizioni dell'automa. Notare che
     * <code>EPSILON</code> non e` un simbolo.
     *
     * @return L'alfabeto dell'automa.
     */
    public HashSet<Character> alphabet() {
        //DA IMPLEMENTARE 5.1
        HashSet out = new HashSet<>();
        for (Move m : transitions.keySet()) {
            out.add(m.ch);
        }
        if (out.contains(EPSILON)) {
            out.remove(EPSILON);
        }
        return out;
    }

    /**
     * Esegue una mossa dell'automa.
     *
     * @param p Stato di partenza prima della transizione.
     * @param ch Simbolo da riconoscere.
     * @return Insieme di stati di arrivo dopo la transizione. Questo insieme
     * puo` essere vuoto.
     */
    public HashSet<Integer> move(int p, char ch) {
        //DA IMPLEMENTARE 5.1
        return transitions.get(new Move(p, ch));
    }

    /**
     * Esegue una mossa dell'automa.
     *
     * @param s Insieme di stati di partenza prima della transizione.
     * @param ch Simbolo da riconoscere.
     * @return Insieme di stati di arrivo dopo la transizione. Questo insieme
     * puo` essere vuoto.
     */
    public HashSet<Integer> move(HashSet<Integer> s, char ch) {
        HashSet out = new HashSet<>();
        for (int i : s) {
            HashSet temp = transitions.get(new Move(i, ch));
            
                if (transitions.containsKey(temp))
                out.addAll(temp);
            
        }
        return out;
    }
    
    /**
     * Calcola la epsilon chiusura di un insieme di stati dell'automa.
     * @param s  Insieme di stati di cui calcolare l'epsilon chiusura.
     * @return Insieme di stati raggiungibili da quelli contenuti in
     *         <code>s</code> per mezzo di zero o piu` epsilon
     *         transizioni.
     */
    public HashSet<Integer> epsilonClosure(HashSet<Integer> s) {
	HashSet<Integer> qset = new HashSet<Integer>();
	for (int p : s)//per tutti gli int dell'hashset
	    qset.addAll(epsilonClosure(p));//fanne l'epsilon-c individuale e poi metti tutti gli hashset risultato insieme
	return qset;
        
    }
    
    /**
     * Calcola la epsilon chiusura di uno stato dell'automa. E` un
     * caso specifico del metodo precedente.
     * @param p  Insieme di cui calcolare l'epsilon chiusura.
     * @return Insieme di stati raggiungibili da <code>p</code> per
     *         mezzo di zero o piu` epsilon transizioni.
     * @see #epsilonClosure
     */    
    public HashSet<Integer> epsilonClosure(int p) {
	// IMPLEMENTARE 5.2
        HashSet<Integer> closure = new HashSet<Integer>();
        boolean[] r = new boolean[this.numberOfStates];
        
        for(int i = 0; i < this.numberOfStates; i++)
            r[i] = false;
        r[p] = true; //per ora solo lo stato stesso è raggiunto con eps
        closure.add(p);
        
        Move move;
        boolean bool = true;
        while(bool){
            bool = false;
            for(int i = 0; i < this.numberOfStates; i++){ //tutti gli stati
                move = new Move(i, EPSILON); //tutte le mosse epsilon con i
                if(r[i] == true && this.transitions.get(move) != null){//se è e.closed e ha e-transizioni
                    // insieme di stati raggiunti con la mossa (statoI - epsilon)
                    HashSet<Integer> j = this.transitions.get(move);
                    Iterator<Integer> it = j.iterator();
                    // scorro tutte le destinazioni
                    while(it.hasNext()){ //insieme di tutte le e.trans dallo stato
                        int state = it.next();
                        if(!closure.contains(state)){//se closure non ha ancora lo stato 
                            r[state] = true; //segno che lo aggiungo e che è e.closed per poterlo esplorare al prossimo giro
                            closure.add(state); //lo aggiungo all'hashsetdei raggiunti con epsilon
                            bool = true; //ho fatto qualcosa
                        }
                    }
                }
            }
        }
        return closure;
    }
    
    /**
     * Calcola l'automa a stati finiti deterministico equivalente.
     *
     * @return DFA equivalente.
     */
    public DFA dfa(){
	// la costruzione del DFA utilizza due tabelle hash per tenere
	// traccia della corrispondenza (biunivoca) tra insiemi di
	// stati del NFA e stati del DFA
    	HashMap<HashSet<Integer>, Integer> indexOfSet =
	    new HashMap<HashSet<Integer>, Integer>();    // NFA -> DFA
    	HashMap<Integer, HashSet<Integer>> setOfIndex =
	    new HashMap<Integer, HashSet<Integer>>();    // DFA -> NFA
	
    	DFA dfa = new DFA(1);                            // il DFA
    	Stack<Integer> newStates = new Stack<Integer>(); // nuovi stati del DFA
    	HashSet<Character> alphabet = alphabet();

    	indexOfSet.put(epsilonClosure(0), 0); // stati dell'NFA corrisp. a q0
    	setOfIndex.put(0, epsilonClosure(0));
    	newStates.push(0);                    // nuovo stato da esplorare

    	while (!newStates.empty()) { // finche' ci sono nuovi stati da visitare
    	    final int p = newStates.pop(); // ne considero uno e lo visito
    	    final HashSet<Integer> pset = setOfIndex.get(p); // stati del NFA corrisp.
    	    for (char ch : alphabet) { // considero tutte le possibili transizioni
    		HashSet<Integer> qset = epsilonClosure(move(pset, ch));
    		if (indexOfSet.containsKey(qset)) { // se qset non e` nuovo...
    		    final int q = indexOfSet.get(qset); // recupero il suo indice
    		    dfa.setMove(p, ch, q);          // aggiungo la transizione
    		} else {                            // se invece qset e` nuovo
    		    final int q = dfa.newState();   // creo lo stato nel DFA
    		    indexOfSet.put(qset, q);        // aggiorno la corrispondenza
    		    setOfIndex.put(q, qset);
    		    newStates.push(q);              // q e` da visitare
    		    dfa.setMove(p, ch, q);          // aggiungo la transizione
    		}
    	    }
    	}

	// stabilisco gli stati finali del DFA
    	for (int p = 0; p < dfa.numberOfStates(); p++)
	    if (finalState(setOfIndex.get(p)))
		dfa.addFinalState(p);

    	return dfa;
    }
    
    /**
     * Calcola l'automa dfa con n+1 stati che riconosce le stringhe 0 e 1 
     * tali che l'nesimo simbolo da dx sia 1
     * @param n il numero di stai dell'nfa
     * @return DFA equivalente con n+1 stati.
     */
    public static NFA nth(int n) {
        //DA IMPLEMENTARE 5.2
        NFA out = new NFA(n + 1);
        out.addMove(0, '1', 0);
        out.addMove(0, '0', 0);
        //out.addMove(0, EPSILON, 0);
        int i = 0;

        if (n != 0) {
            out.addMove(0, '1', 1);
            i++;
            while (i < n - 1) {
                out.addMove(i, '1', i + 1);
                out.addMove(i, '0', i + 1);
                //out.addMove(i, EPSILON, i);
                i++;
            }
            //out.addMove(i, EPSILON, i);
        }

        out.addFinalState(i);
        return out;
    }

    public void toDOT(String name) {
        //DA IMPLEMENTARE 5.4
        String out = "digraph " + name + "{\n";

        out += "rankdir=LR;\n";
        out += "node [shape = doublecircle];\n";

        for (Integer i : finalStates) {
            out += "q" + i + ";\n";
        }

        out += "node [shape = circle];\n";

        for (Move m : transitions.keySet()) {
            for (int i : transitions.get(m)) {
                if(m.ch == EPSILON)
                    out += "q" + m.start + " -> q" + i + " [ label = \"" + "ɛ" + "\" ];\n";
                else out += "q" + m.start + " -> q" + i + " [ label = \"" + m.ch + "\" ];\n";
            }
        }

        out += "}";
        System.out.println(out);
    }
}
