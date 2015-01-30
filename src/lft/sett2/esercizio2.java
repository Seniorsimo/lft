/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett2;

import java.util.Scanner;

/**
 *
 * dfa che riconosce stringhe con 3 0 consecutivi
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
