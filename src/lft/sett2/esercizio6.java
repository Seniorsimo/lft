package lft.sett2;

/**
 * Aggiungere alla classe DFA un metodo toDOT che stampa una rappresentazione
 * testuale dell’automa compatibile con l’input del tool dot di GraphViz
 * (vedi http://www.graphviz.org).
 * 
 * Link per la visualizzazione
 * http://graphviz-dev.appspot.com
 * 
 */
public class esercizio6 {
    public static void main(String args[]){
        DFA dfa = new DFA(4);
        
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
        dfa.setMove(2, '1', 0);
        
        //3
        dfa.setMove(3, '0', 3);
        dfa.setMove(3, '1', 3);
        
        //print
        dfa.toDOTMod("provamod");

    }
}
