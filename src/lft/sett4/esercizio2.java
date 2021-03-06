package lft.sett4;

/**
 * Aggiungere un metodo equivalentTo alla classe DFA che determina se due DFA
 * sono equivalenti (fare riferimento al libro di testo per la descrizione
 * dell'algoritmo). Organizzare l'implementazione dell'algoritmo in modo da
 * evitare la duplicazione di parti consistenti di codice nella classe DFA,
 * eventualmente definendo opportuni metodi ausiliari privati.
 * 
 */
public class esercizio2 {
    public static void main(String[] args){
        DFA in = new DFA(4);
        in.addFinalState(1);
        in.addFinalState(3);
        
        in.setMove(0, '0', 0);
        in.setMove(0, '1', 1);
        in.setMove(1, '1', 1);
        in.setMove(1, '0', 2);
        in.setMove(2, '1', 3);
        in.setMove(2, '0', 2);
        in.setMove(3, '1', 3);
        in.setMove(3, '0', 2);
        
        in.toDOT("in");
        
        DFA out = new DFA(2);
        out.addFinalState(1);
        out.setMove(0, '0', 0);
        out.setMove(0, '1', 1);
        out.setMove(1, '1', 1);
        out.setMove(1, '0', 0);
        out.toDOT("out");
        
        System.out.println(in.equivalentTo(out));

    }
}
