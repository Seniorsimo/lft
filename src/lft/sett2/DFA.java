package lft.sett2;


import java.util.HashSet;
import java.util.HashMap;

/**
 * Un oggetto della classe DFA rappresenta un automa a stati finiti
 * deterministico
 */
public class DFA
{
    /** 
     * Numero degli stati dell'automa. Ogni stato e` rappresentato da
     * un numero interno non negativo, lo stato con indice 0 e` lo
     * stato iniziale.
     */
    private int numberOfStates;

    /** Insieme degli stati finali dell'automa. */
    private HashSet<Integer> finalStates;

    /**
     * Funzione di transizione dell'automa, rappresentata come una
     * mappa da mosse a stati di arrivo.
     */
    private HashMap<Move, Integer> transitions;

    /**
     * Crea un DFA con un dato numero di stati.
     * @param  n Il numero di stati dell'automa.
     */
    public DFA(int n) {
	numberOfStates = n;
	finalStates = new HashSet<Integer>();
	transitions = new HashMap<Move, Integer>();
    }

    /**
     * Aggiunge uno stato all'automa.
     * @return L'indice del nuovo stato creato
     */
    public int newState() {
	return numberOfStates++;
    }

    /**
     * Aggiunge una transizione all'automa.
     * @param  p  Lo stato di partenza della transizione.
     * @param  ch Il simbolo che etichetta la transizione.
     * @param  q  Lo stato di arrivo della transizione.
     * @return <code>true</code> se lo stato di partenza e lo stato di
     *         arrivo sono validi, <code>false</code> altrimenti.
     */
    public boolean setMove(int p, char ch, int q) {
	if (!validState(p) || !validState(q))
	    return false;

	transitions.put(new Move(p, ch), q);
	return true;
    }

    /**
     * Aggiunge uno stato finale.
     * @param  p Lo stato che si vuole aggiungere a quelli finali.
     * @return <code>true</code> se lo stato e` valido,
     *         <code>false</code> altrimenti.
     */
    public boolean addFinalState(int p) {
	if (validState(p)) {
	    finalStates.add(p);
	    return true;
	} else
	    return false;
    }

    /**
     * Determina se uno stato e` valido oppure no.
     * @param  p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` valido,
     *         <code>false</code> altrimenti.
     * @see #numberOfStates
     */
    public boolean validState(int p) {
	return (p >= 0 && p < numberOfStates);
    }

    /**
     * Determina se uno stato e` finale oppure no.
     * @param  p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` finale,
     *         <code>false</code> altrimenti.
     * @see #finalStates
     */
    public boolean finalState(int p) {
	return finalStates.contains(p);
    }

    /**
     * Restituisce il numero di stati dell'automa.
     * @return Numero di stati.
     */
    public int numberOfStates() {
	return numberOfStates;
    }

    /**
     * Restituisce l'alfabeto dell'automa, ovvero l'insieme di simboli
     * che compaiono come etichette delle transizioni dell'automa.
     * @return L'alfabeto dell'automa.
     */
    public HashSet<Character> alphabet() {
	HashSet<Character> alphabet = new HashSet<Character>();
	for (Move m : transitions.keySet())
	    alphabet.add(m.ch);
	return alphabet;
    }

    /**
     * Esegue una mossa dell'automa.
     * @param p  Stato di partenza prima della transizione.
     * @param ch Simbolo da riconoscere.
     * @return Stato di arrivo dopo la transizione, oppure
     *         <code>-1</code> se l'automa non ha una transizione
     *         etichettata con <code>ch</code> dallo stato
     *         <code>p</code>.
     */
    public int move(int p, char ch) {
	Move move = new Move(p, ch);
	if (transitions.containsKey(move))
	    return transitions.get(move);
	else
	    return -1;
    }

    /**
     * Verifica se una stringa e` riconosciuta dall'automa.
     * @param  s  Stringa da riconoscere.
     * @return <code>true</code> se la stringa e` stata riconosciuta,
     *         <code>false</code> altrimenti.
     */
    public boolean scan(String s) {
	// DA IMPLEMENTARE 2.2
        
        // Inizializzazione delle variabili
        int index = 0;
        int state = 0;  // state indica lo stato in cui ci troviamo al momento
                        // usando i caratteri della stringa s
        // per ogni caratte della stringa eseguo una transazione partendo dallo
        // stato corrente. Nel caso una transazione ritorni un errore mi fermo.
        while(state>=0&&index<s.length()){
            state = move(state,s.charAt(index++));
        }
        return finalStates.contains(state);
    }
    
    /**
     * Restituisce true nel caso l'automa sia completo
     * @return true se da ogni stato esce una transizione con ogni lettera 
     * dell'alfabeto
     */
    public boolean complete(){
        // DA IMPLEMENTARE 2.4
        
        // Partendo dal presupposto che sia completo, mi basta trovare uno stato
        // con almeno una transazione per un simbolo dell'alfabeto non definita
        // per dire che è incompleto
        boolean complete = true;
        HashSet alph = alphabet();
        int i=0;
        while(complete&&i<numberOfStates){
            for(Object c : alph){
                if(move(i,(Character)c)==-1) complete = false;
            }
            i++;
        }
        return complete;
    }

    /**
     * Stampa una rappresentazione testuale dell'automa da
     * visualizzare con <a href="http://graphviz-dev.appspot.com/">GraphViz</a>.
     * @param name Nome dell'automa.
     */
    public void toDOT(String name) {
        // DA IMPLEMENTARE 2.5
	String out = "digraph " + name + "{\n";
        
        out += "rankdir=LR;\n";
        out += "node [shape = doublecircle];\n";
        
        for(Integer i : finalStates){ //iniz. stati finali
            out += "q" + i + ";\n";
        }
        
        out += "node [shape = circle];\n";
        
        for(Move m :transitions.keySet()){
            out += "q" + m.start + " -> q" + transitions.get(m) + " [ label = \"" + m.ch + "\" ];\n";
        } //q[stato di inizio mossa] -> q[valore associato alla mossa] [ label = \carattere di transizione
        
        out += "}";
        System.out.println(out);
    }
    
    
    
    public void toDOTMod(String name) {
        //DA COMPLETARE 2.6
        /**
         * Inizializza il grafo
         */
        String output = "digraph " + name + "{\nrankdir=LR;\nnode[shape = doublecircle];\n";
        /**
         * Inserisce gli stati finali
         */
        for (Integer fin : this.finalStates) {
            output += "q" + fin + ";\n";
        }
        /**
         * Inserisce la forma del nodo
         */
        output += "node [shape = circle];\n";
        /**
         * Associa ad una mossa uno stato
         */
        HashMap<Move, Integer> tmp = new HashMap<Move, Integer>();
        HashSet<Character> result;
        /**
         * cicla su tutte le mosse
         */
        for (Move move : transitions.keySet()) {
            result = new HashSet<Character>();
            /**
             * se mossa gia' analizzata, salta iterazione
             */
            if (tmp.containsKey(move)) {
                continue;
            }
            result.add(move.ch);
            /**
             * ri-cicla su tutte le mosse
             */
            for (Move mv : transitions.keySet()) {
                /**
                 * cicla e confronta se ci sono delle corrispondenze tra stato
                 * di partenza e di arrivo
                 */
                if (move.start == mv.start && transitions.get(move) == transitions.get(mv)) {
                    tmp.put(mv, transitions.get(mv));
                    result.add(mv.ch);
                }
            }
            /**
             * aggiunge la nuova transizione al grafo
             */
            output += "q" + move.start + " -> q" + transitions.get(move) + " [ label = \"";
            int j = 0;
            /**
             * Stampa i caratteri utilizzati dalla transizione sull'arco che
             * connette due stati
             */
            for (Character c : result) {
                if (j != 0) {
                    output += "," + c;
                } else {
                    output += c;
                    j++;
                }
            }
            output += "\" ];\n";
            tmp.put(move, transitions.get(move));
        }
        output += "}";
        System.out.println(output);
    }
        
    

    /**
     * Stampa una classe Java con un metodo <code>scan</code> che implementa 
     * l'automa.
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
              "         System.out.println(Scan(args[0]) ? \"OK\" : \"NOPE\""
                + ");\n"+
              "     }\n"+
              "}";
        
        System.out.println(out);
    }
}