package lft.sett5;

import java.util.HashSet;

/**
 * (opzionale). Dotare la classe NFA di un metodo toDOT analogo a quello gia
 * realizzato per la classe DFA. Ha senso dotare la classe NFA anche del metodo
 * toJava? Argomentare.
 * 
 * Non è strettamente necessario dotare la classe del metodo toJava in quanto
 * per ogni NFA esiste sempre un DFA equivalente che già possiede quel metodo.
 */
public class esericizio4 {

    public static void main(String[] args) {

        NFA test = NFA.nth(4);
        test.toDOT("Test");

        test.dfa().toDOT("TestDFA");
        
    }
}
