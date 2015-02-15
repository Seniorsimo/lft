package lft.sett5;

/**
 * DFA: trasformando in dfa il nfa viene ridotto di stati
 * MIN: minimizzando arrivo sempre al minimo numero di stati
 * 
 * Implementare un metodo statico nth della classe NFA che, dato un numero
 * naturale n, produce l'automa non deterministico avente n + 1 stati che
 * riconosce le stringhe di 0 e 1 tali che l'n-esimo simbolo da destra sia 1
 * (Figura 4). Verificare il fenomeno dell'esplosione degli stati stampando,
 * per ogni numero i in un intervallo [1, N] ragionevole, il numero di stati
 * dell'NFA ritornato da NFA.nth(i), il numero di stati di NFA.nth(i).dfa(),
 * ed il numero di stati di NFA.nth(i).dfa().minimize().
 * 
 */
public class esercizio2 {
    public static void main(String[] args){
        for(int i=0; i<10; i++){
            NFA test = NFA.nth(i);
            System.out.println("NFA: " + test.numberOfStates() + "; DFA: " + test.dfa().numberOfStates() + "; MIN: " + test.dfa().minimize().numberOfStates());
        }
    }
}
