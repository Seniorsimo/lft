package lft.sett2;

import java.util.Scanner;

/**
 * (opzionale). Aggiungere alla classe DFA un metodo complete che ritorna true
 * se la funzione di transizione di un DFA e definita per tutti gli stati
 * dell'automa e i simboli del suo alfabeto di riferimento, false altrimenti
 * 
 */
public class esercizio4 {
    public static void main(String args[]){
        
        // DFA completo
        DFA dfa = new DFA(2);
        
        //finali
        dfa.addFinalState(1);
        
        dfa.setMove(0, '1', 0);
        dfa.setMove(0, '0', 1);
        dfa.setMove(1, '1', 1);
        dfa.setMove(1, '0', 1);
        
        //DFA incompleto
        DFA dfaincomplete = new DFA(2);
        
        //finali
        dfaincomplete.addFinalState(1);
        
        dfaincomplete.setMove(0, '0', 1);
        dfaincomplete.setMove(1, '1', 1);
        dfaincomplete.setMove(1, '0', 1);
        
        
        //scan
        System.out.println("dfa Complete? " + dfa.complete());
        System.out.println("dfaincomplete Complete? " + dfaincomplete.complete());
    }
}
