package lft.sett5;

import java.util.HashSet;
import java.util.HashMap;

/**
 * Un oggetto della classe DFA rappresenta un automa a stati finiti
 * deterministico
 */
public class DFA {

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
     * mosse a stati di arrivo.
     */
    private HashMap<Move, Integer> transitions;

    /**
     * Crea un DFA con un dato numero di stati.
     *
     * @param n Il numero di stati dell'automa.
     */
    public DFA(int n) {
        numberOfStates = n;
        finalStates = new HashSet<Integer>();
        transitions = new HashMap<Move, Integer>();
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
     * Aggiunge una transizione all'automa.
     *
     * @param p Lo stato di partenza della transizione.
     * @param ch Il simbolo che etichetta la transizione.
     * @param q Lo stato di arrivo della transizione.
     * @return <code>true</code> se lo stato di partenza e lo stato di arrivo
     * sono validi, <code>false</code> altrimenti.
     */
    public boolean setMove(int p, char ch, int q) {
        if (!validState(p) || !validState(q)) {
            return false;
        }

        transitions.put(new Move(p, ch), q);
        return true;
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
     * Restituisce l'alfabeto dell'automa, ovvero l'insieme di simboli che
     * compaiono come etichette delle transizioni dell'automa.
     *
     * @return L'alfabeto dell'automa.
     */
    public HashSet<Character> alphabet() {
        HashSet<Character> alphabet = new HashSet<Character>();
        for (Move m : transitions.keySet()) {
            alphabet.add(m.ch);
        }
        return alphabet;
    }

    /**
     * Esegue una mossa dell'automa.
     *
     * @param p Stato di partenza prima della transizione.
     * @param ch Simbolo da riconoscere.
     * @return Stato di arrivo dopo la transizione, oppure <code>-1</code> se
     * l'automa non ha una transizione etichettata con <code>ch</code> dallo
     * stato <code>p</code>.
     */
    public int move(int p, char ch) {
        Move move = new Move(p, ch);
        if (transitions.containsKey(move)) {
            return transitions.get(move);
        } else {
            return -1;
        }
    }

    /**
     * Verifica se una stringa e` riconosciuta dall'automa.
     *
     * @param s Stringa da riconoscere.
     * @return <code>true</code> se la stringa e` stata riconosciuta,
     * <code>false</code> altrimenti.
     */
    public boolean scan(String s) {
        // DA IMPLEMENTARE
        int index = 0;
        int state = 0;
        while (state >= 0 && index < s.length()) {
            state = move(state, s.charAt(index++));
        }
        return finalStates.contains(state);
    }

    /**
     * Restituisce true nel caso l'automa sia completo
     */
    public boolean complete() {
        boolean complete = true;
        HashSet alph = alphabet();
        int i = 0;
        while (complete && i < numberOfStates) {
            for (Object c : alph) {
                if (move(i, (Character) c) == -1) {
                    complete = false;
                }
            }
            i++;
        }
        return complete;
    }

    /**
     * Stampa una rappresentazione testuale dell'automa da visualizzare con
     * <a href="http://www.graphviz.org">GraphViz</a>.
     *
     * @param name Nome dell'automa.
     */
    public void toDOT(String name) {
        String out = "digraph " + name + "{\n";

        out += "rankdir=LR;\n";
        out += "node [shape = doublecircle];\n";

        for (Integer i : finalStates) {
            out += "q" + i + ";\n";
        }

        out += "node [shape = circle];\n";

        for (Move m : transitions.keySet()) {
            out += "q" + m.start + " -> q" + transitions.get(m) + " [ label = \"" + m.ch + "\" ];\n";
        }

        out += "}";
        System.out.println(out);
    }

    /**
     * Stampa una classe Java con un metodo <code>scan</code> che implementa
     * l'automa.
     *
     * @param name Nome della classe da generare.
     */
    public void toJava(String name) {
        // DA IMPLEMENTARE
    }

    public HashSet<Integer> reach(int input) {

        boolean[] r = new boolean[numberOfStates];
        for (boolean b : r) {
            b = false;
        }
        r[input] = true;

        int i = 0;
        boolean modificato = false;
        /*cicla finchè modifichi qualcosa*/
        /*i < numberOfStates*/
        do {

            if (r[i]) {
                for (Move m : transitions.keySet()) {
                    if (m.start == i && !r[transitions.get(m)]) {
                        r[transitions.get(m)] = true;
                        modificato = true;

                    }
                }
            }
            i++;
            if (i == numberOfStates && modificato == true) {
                modificato = false;
                i = 0;
            }
        } while (i < numberOfStates);

        HashSet<Integer> result = new HashSet<>();
        for (int ii = 0; ii < r.length; ii++) {
            if (r[ii]) {

                result.add(ii);
            }
        }

        return result;
    }

    public HashSet<StateWithExample> reachWithExaple(int input) {

        boolean[] r = new boolean[numberOfStates];
        String[] s = new String[numberOfStates];
        for (int i = 0; i < numberOfStates; i++) {
            r[i] = false;
            s[i] = "";
        }
        r[input] = true;

        int i = 0;
        boolean modificato = false;
        /*cicla finchè modifichi qualcosa*/
        /*i < numberOfStates*/
        do {

            if (r[i]) {
                for (Move m : transitions.keySet()) {
                    if (m.start == i && !r[transitions.get(m)]) {
                        r[transitions.get(m)] = true;
                        s[transitions.get(m)] = s[i] + " " + m.ch;
                        modificato = true;

                    }
                }
            }
            i++;
            if (i == numberOfStates && modificato == true) {
                modificato = false;
                i = 0;
            }
        } while (i < numberOfStates);

        HashSet<StateWithExample> result = new HashSet<>();
        for (int ii = 0; ii < r.length; ii++) {
            if (r[ii]) {

                result.add(new StateWithExample(ii, s[ii]));
            }
        }

        return result;
    }

    public boolean empty() {
        HashSet temp = reach(0);
        for (Object i : temp) {
            if (finalStates.contains((Integer) i)) {
                return false;
            }
        }
        return true;
    }

    public HashSet<Integer> sink() {
        HashSet<Integer> out = new HashSet<>();
        for (int i = 0; i < numberOfStates; i++) {
            if (!finalStates.contains(i) && reach(i).size() == 1) {
                out.add(i);
            }
        }
        return out;
    }

    public DFA minimize() {

        boolean[][] eq = new boolean[numberOfStates][numberOfStates];
        for (int i = 0; i < numberOfStates; i++) {
            for (int j = 0; j < numberOfStates; j++) {
                eq[i][j] = (finalStates.contains(i) && finalStates.contains(j)) || (!finalStates.contains(i) && !finalStates.contains(j));
            }
        }
        char[] alf = new char[alphabet().size()];

        boolean modificato;
        do {
            modificato = false;

            for (int i = 0; i < numberOfStates; i++) {
                for (int j = 0; j < numberOfStates; j++) {

                    boolean distinguibili = true;
                    int index = 0;

                    for (Object o : alphabet()) {
                        alf[index] = (Character) o;
                        index++;
                    }

                    index = 0;
                    while (distinguibili && index < alf.length) {
                        if (eq[i][j] && !eq[move(i, alf[index])][move(j, alf[index])]) {
                            eq[i][j] = false;
                            modificato = true;
                        }
                        index++;
                    }
                }
            }

        } while (modificato);

        int[] m = new int[numberOfStates];
        int k = 0;
        for (int i = 0; i < numberOfStates; i++) {
            m[i] = i;
            for (int j = 0; j < numberOfStates; j++) {
                if (eq[i][j] && j < i) {
                    m[i] = j;
                }
            }
            if (m[i] > k) {
                k = m[i];
            }
        }

        DFA out = new DFA(k + 1);
        for (Move move : transitions.keySet()) {
            out.setMove(m[move.start], move.ch, m[transitions.get(move)]);
        }
        for (int i = 0; i < numberOfStates; i++) {
            if (finalStates.contains(i)) {
                out.addFinalState(m[i]);
            }
        }
        return out;
    }

    public boolean equivalentTo(DFA target) {
        DFA a = this.minimize();
        DFA b = target.minimize();

        boolean eq = true;

        if (a.numberOfStates != b.numberOfStates) {
            eq = false;
        }
        if (a.finalStates.size() == b.finalStates.size()) {
            for (Integer i : a.finalStates) {
                if (!b.finalStates.contains(i)) {
                    eq = false;
                }
            }
        } else {
            eq = false;
        }
        if (a.transitions.size() == b.transitions.size()) {
            for (Move m : a.transitions.keySet()) {
                if (!b.transitions.containsKey(m) || ((int) b.transitions.get(m)) != ((int) a.transitions.get(m))) {
                    eq = false;
                }
            }
        } else {
            eq = false;
        }

        return eq;
    }

    private static class StateWithExample {

        private int state;
        private String example;

        public StateWithExample(int state, String example) {
            this.state = state;
            this.example = example;
        }

        @Override
        public String toString() {
            return "[state: " + state + "; example: \"" + example + "\"]";
        }
    }
}
