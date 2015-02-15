package lft.sett3;

/**
 * Implementare un metodo samples che ritorna un insieme di stringhe campione
 * accettate dall'automa, una per ogni stato finale dell'automa.
 * Suggerimento: La struttura del metodo samples e fondamentalmente identica a
 * quella del metodo reach: basta raffinare l'algoritmo di raggiungibilita in
 * modo da tenere traccia, per ogni stato p raggiungibile dallo stato iniziale
 * q0 dell'automa, di un esempio di stringa w che consente di raggiungere p da
 * q0, ovvero tale che ˆδ(q0, w) = p.
 * Per fare cio, cambiare il vettore r in modo che contenga stringhe invece
 * che boolean e in questo vettore usare il valore null invece che false per
 * marcare gli stati irraggiungibili.
 * 
 */
public class esercizio2 {

    public static void main(String[] args) {
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
        


        System.out.println(dfa.samples(0));
    }
}
