package lft.sett4;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

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
        // DA IMPLEMENTARE 2.2
        int index = 0;
        int state = 0;
        while (state >= 0 && index < s.length()) {
            state = move(state, s.charAt(index++));
        }
        return finalStates.contains(state);
    }

     /**
     * Restituisce true nel caso l'automa sia completo
     * @return true se da ogni stato esce una transizione con ogni lettera 
     * dell'alfabeto
     */
    public boolean complete() {
        // DA IMPLEMENTARE 2.4
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
     * <a href="http://graphviz-dev.appspot.com/">GraphViz</a>.
     *
     * @param name Nome dell'automa.
     */
    public void toDOT(String name) {
        // DA IMPLEMENTARE 2.5
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
	// DA IMPLEMENTARE 2.6
        boolean init= false;
        String out = "public class " + name + "{ \n\n";
        
        out += "        public static boolean Scan (String s) { \n\n" +
               "            int state = 0; \n" +
               "            int i = 0; \n\n";
        
        out += "            while (state >=0 && i<s.length()){ \n" +
               "                final char ch = s.charAt(i++); \n\n" +
               "                switch (state) { \n";
        
        for (int j=0; j< numberOfStates; j++){
            out += "                    case "+ j+ ":\n";
            for(Move m :transitions.keySet()){
                if (m.start == j && init == false){
                    out += "                    if (ch == " +  m.ch + ")\n "+ 
                           "                        state = " + transitions.get(m) + ";\n";
                    init = true;
                } 
                
                else if (m.start == j && init == true){
                    out += "                    else if (ch == " +  m.ch + ")\n "+ 
                           "                        state = " + transitions.get(m) + ";\n";
                }
            }
            out += "\n                    else state = -1;\n"+
                   "                    break; \n\n";
            init = false;
            }
        out += "                }\n             }\n";
        
        for(Integer i : finalStates){
            out += "        return state == "+ i + "; \n    }\n\n";
        }
        
        out +="     public static void main(String [] args){\n" +
              "         System.out.println(Scan(args[0]) ? \"OK\" : \"NOPE\");\n"+
              "     }\n"+
              "}";
        
        System.out.println(out);
    }
    
    /**
     * Controlla se lo stato è raggiungibile dallo stato iniziale
     * @param input stato di partenza
     * @return <code>HashSet<Integer> result </code> insieme degli stati raggiunti da input
     */
    public HashSet<Integer> reach(int input){
        // DA IMPLEMENTARE 3.1
        if (numberOfStates==0) return null; //GESTISCE IL DFA VUOTO
        boolean[] r = new boolean[numberOfStates];
        for(boolean b:r) b = false; //tutto a false
        r[input] = true; //lo stato di partenza è true
        
        
        int i = 0;
        boolean modificato = false;
        /*cicla finchè modifichi qualcosa*/
                /*i < numberOfStates*/
        do{
            
            if(r[i]){//se r[i] è raggiungibile
                for(Move m:transitions.keySet()){ //cicla tutte le mosse possibili
                    if(m.start == i && !r[transitions.get(m)]){ //prendi quelle che interessano
                        r[transitions.get(m)] = true; //se non era ancora a true mettilo a true
                        modificato = true;
                        
                    }
                }
            }
            i++;
            if(i==numberOfStates&&modificato==true){ //se sono alla fine ma ho fatto modifiche
                modificato = false;//continua a ciclare 
                i = 0;//resetta
            }
        }
        while(i<numberOfStates);
        
        HashSet<Integer> result = new HashSet<>();
        for(int ii=0; ii<r.length; ii++){
            if(r[ii]){
                
                result.add(ii);
            }
        }
        
        return result;
    }

    /**
     * Controlla se il DFA è vuoto
     * 
     * @return true se reach(start) non contiene stati finali
     */
    public boolean empty() {
       //DA IMPLEMENTARE 3.1
        HashSet temp = reach(0);
        if (temp==null)
            return true;
        return false;
    }

    /**
     * Controlla se il DFA ha uno stato pozzo
     * uno stato è pozzo se da esso non escono transizioni verso altri stati
     * @return l'insieme stati pozzo
     */
        public HashSet<Integer> sink() {
        //DA IMPLEMENTARE 3.1
        HashSet<Integer> out = new HashSet<>();
        for (int i = 0; i < numberOfStates; i++) {
            if (!finalStates.contains(i) && reach(i).size() == 1) { //se non è finale ma raggiunge solo sè stesso
                out.add(i);//allora è pozzo
            }
        }
        return out;
    }
    
    /**
     * Controlla se lo stato è raggiungibile dallo stato iniziale e si memorizza 
     * una striga usata per arrivarci
     * @param input stato di partenza
     * @return <code>HashSet<Integer> result </code> insieme degli stati raggiunti da input
     */
    public HashSet<StateWithExample> samples(int input) {
            //DA IMPLEMENTARE 3.2
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

    /**
     * minimizza l'automa, cioè trova gli stati equicìvalenti fra loro
     * @return 
     */
    public DFA minimize() {
        boolean bool = true;
        HashSet<Character> alfabeto = this.alphabet();
        Iterator<Character> itAlfabeto;

        boolean eq[][] = new boolean[numberOfStates][numberOfStates];
        for (int i = 0; i < numberOfStates; i++) {
            for (int j = 0; j < numberOfStates; j++) {
                if ((finalState(i) && finalState(j)) || (!finalState(i) && !finalState(j))){
                    eq[i][j] = true;
                } else {
                    eq[i][j] = false;
                }
            }
        } 
        while (bool) {
            bool = false;
            for (int i = 0; i < numberOfStates; i++) {
                for (int j = 0; j < numberOfStates; j++) {
                    itAlfabeto = alfabeto.iterator();
                
                while (itAlfabeto.hasNext()) {
                    char ch = itAlfabeto.next();
                    
                    if (eq[i][j] == true && eq[move(i, ch)][move(j, ch)] == false) {
                        eq[i][j] = false;
                        bool = true;
                    }
                }
            }
        }
    }// 5 - trovare rappresentante stati indistinguibili uso le classi di equivalenza con rappresentante indice più piccolo
    int[] m = new int[numberOfStates];
    int max = -1;
    for(int i = 0;i< numberOfStates ;i++){ 
    for (int j = 0; j < numberOfStates; j++) {
        // prende la prima j sulla colonna che, incrociato con i, ha valore true(indistinguibile)
            if (eq[i][j] == true) {
                m[i] = j; //nell'array di costruzione mettiamo j nella posizione i
                if (j > max) {
                    max = j; //num. stati da costruire
                }
                break;
            }
        }
    }//6: DFA B tc per ogni mossa i-ch->j in A ci sia m[i] -ch-> m[j] in B
    DFA b = new DFA(max + 1);
    Move move; 
    for(int i = 0;i< numberOfStates;i++){ 
        itAlfabeto = alfabeto.iterator();
        while (itAlfabeto.hasNext()) {
            char ch = itAlfabeto.next();
            move = new Move(i, ch); 
            if (transitions.get(move) != null) { //se esiste in transitions il risultato della mossa move
                b.setMove(m[i], ch, m[transitions.get(move)]);
                if (this.finalState(i)) {
                    b.addFinalState(m[i]);
                }
            }
        }
    }
    return b ;
}

    /**
     * verifica se due automi sono equivalenti
     * @param target il secondo automa
     * @return 
     */
    public boolean equivalentTo(DFA target) { //SBAGLIATO BASTA VERIFICARE L'EQUIVALENZA DEI DUE STATI INIZIALI
        //DA IMPLEMENTARE 4.2
        DFA a = this.minimize();
        DFA b = target.minimize();

        boolean eq = true;

        if (a.numberOfStates != b.numberOfStates) {//min1 e min2 devono avere lo stesso num di stati
            eq = false;
        }
        if (a.finalStates.size() == b.finalStates.size()) {//se stessu num di finali
            for (Integer i : a.finalStates) {
                if (!b.finalStates.contains(i)) {
                    eq = false;
                }
            }
        } else {
            eq = false;
        }
        if (a.transitions.size() == b.transitions.size()) { //se hanno lo stesso numero di transizioni
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
