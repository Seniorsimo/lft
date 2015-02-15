package lft.sett3;

/**
 * Aggiungere un metodo reach alla classe DFA che implementa l’algoritmo di 
 * raggiungibilita (Tabella 1). Usare il metodo reach per implementare:
 * • un metodo empty che ritorna true se e solo se l’automa riconosce il
 * linguaggio vuoto.
 * • un metodo sink che ritorna l’insieme degli stati pozzo dell’automa.
 * Testare il corretto funzionamento dei metodi reach, empty e sink su alcuni
 * DFA appositamente costruiti.
 * 
 */
public class esercizio1 {
    public static void main(String[] args){
        DFA dfa = new DFA(5);
        
        //finali
        dfa.addFinalState(3);
        
        //0
        dfa.setMove(0, '0', 1);
        dfa.setMove(0, '1', 0);
        
        //1
        dfa.setMove(1, '0', 2);
        dfa.setMove(1, '1', 0);
        
        //2
        dfa.setMove(2, '0', 3);
        dfa.setMove(2, '1', 4);
        
        //3
        dfa.setMove(3, '0', 3);
        dfa.setMove(3, '1', 3);

        DFA Edfa = new DFA(1);
        dfa.toDOT("dfa");
        Edfa.toDOT("Edfa");
        
        System.out.println(dfa.reach(0));
        System.out.println(dfa.empty());
        System.out.println(Edfa.empty());
        System.out.println(dfa.sink());
    }
}
