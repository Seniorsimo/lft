package lft.sett2;

/**
 * Aggiungere alla classe DFA un metodo toJava che accetta come argomento una
 * stringa name e stampa la classe Java di nome name con un metodo scan che
 * riconosce tutte e sole le stringhe accettate dall'automa, secondo lo schema
 * visto in Sezione 1.
 * 
 */
public class esercizio7 {
    public static void main(String []args){
        DFA tz = new DFA(4);
        tz.setMove(0, '1', 0);
        tz.setMove(0, '0', 1);
        tz.setMove(1, '1', 0);
        tz.setMove(1, '0', 2);
        tz.setMove(2, '1', 0);
        tz.setMove(2, '0', 3);
        tz.setMove(3, '1', 3);
        tz.setMove(3, '0', 3);
        tz.addFinalState(3);
        
        
        tz.toJava("trezeri");
    }
}
