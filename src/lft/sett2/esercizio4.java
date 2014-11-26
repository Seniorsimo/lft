/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett2;

import java.util.Scanner;

/**
 *
 * @author Simone
 */
public class esercizio4 {
    public static void main(String args[]){
        DFA dfa = new DFA(2);
        
        //finali
        dfa.addFinalState(1);
        
        dfa.setMove(0, '1', 1);
        dfa.setMove(0, '0', 0);
        dfa.setMove(1, '1', 1);
        dfa.setMove(1, '0', 1);
        
        
        
        //scan
        
        System.out.println("Complete? " + dfa.complete());
    }
}
