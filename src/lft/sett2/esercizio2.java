package lft.sett2;

import java.util.Scanner;

/**
 * Aggiungere alla classe DFA un metodo scan che accetta una stringa s e ritorna
 * true se s e riconosciuta dall’automa, false altrimenti. Scrivere un semplice
 * programma di prova che crea una istanza della classe DFA, costruisce la
 * rappresentazione del DFA mostrato in Figura 1, e verifica se una stringa
 * data in input (passata dalla linea di comando o letta da tastiera) e o meno
 * riconosciuta dall’automa. 
 * 
 */
public class esercizio2 {
    public static void main(String args[]){
        DFA dfa = new DFA(4);
        dfa.addFinalState(3);
        dfa.setMove(0, '1', 0);
        dfa.setMove(0, '0', 1);
        dfa.setMove(1, '1', 0);
        dfa.setMove(1, '0', 2);
        dfa.setMove(2, '1', 0);
        dfa.setMove(2, '0', 3);
        dfa.setMove(3, '1', 3);
        dfa.setMove(3, '0', 3);
        
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(dfa.scan(iao) ? " OK " : " NOPE "); 
        }
}
