package lft.sett4;

/**
 * Aggiungere un metodo minimize alla classe DFA che implementa l’algoritmo di
 * minimizzazione (Tabella 2). Verificare il corretto funzionamento del metodo
 * minimize su alcuni DFA appositamente costruiti. Nota: l'input dell'algoritmo
 * in Tabella 2 e l'istanza di DFA su cui minimize viene invocato.
 * In altri termini, minimize e un metodo di DFA senza argomenti.
 * 
 * @author simone
 */
public class esercizio1 {
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
        
        DFA out = in.minimize();
        out.toDOT("out");
        
        
        
        DFA in2 = new DFA(5);
        in2.addFinalState(0);
        in2.addFinalState(4);
        
        in2.setMove(3, 'a', 3);
        in2.setMove(3, 'b', 3);
        in2.setMove(0, 'a', 2);
        in2.setMove(0, 'b', 1);
        in2.setMove(1, 'a', 3);
        in2.setMove(1, 'b', 0);
        in2.setMove(2, 'a', 4);
        in2.setMove(2, 'b', 3);
        in2.setMove(4, 'a', 2);
        in2.setMove(4, 'b', 1);
        
        in2.toDOT("in");
        
        DFA out2 = in2.minimize();
        out2.toDOT("out2");
        
    }
}
