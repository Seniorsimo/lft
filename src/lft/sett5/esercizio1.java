package lft.sett5;

import java.util.HashSet;

/**
 * Implementare tutti i metodi incompleti della classe NFA mostrata nel Listato
 * 3. Per l'implementazione del metodo epsilonClosure fare riferimento
 * all'algoritmo in Tabella 3. Verificare il funzionamento del metodo dfa su
 * alcune istanze di NFA rappresentanti automi non deterministici, alcuni con
 * ed altri senza epsilon-transizioni.
 * 
 */
public class esercizio1 {
    public static void main(String[] args) {
        NFA automata = new NFA(7);
        automata.addMove(0, '\0', 1);
        automata.addMove(1, '\0', 2);
        automata.addMove(2, '\0', 5);
        automata.addMove(0, '\0', 3);
        automata.addMove(0, '0', 4);
        automata.addMove(4, '1', 5);
        automata.addMove(4, '\0', 6);
        automata.addFinalState(6);
//automata.toDOT("NFA");
        HashSet out = automata.epsilonClosure(0);

        System.out.println(out);
    }
    
}
