/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett2;

import java.util.Scanner;

/**
 * check se il dfa è completo
 * @author anna
 */
public class esercizio4 {
    public static void main(String args[]){
        DFA dfa = new DFA(2);
        
        //finali
        dfa.addFinalState(1);
        
        dfa.setMove(0, '1', 0);
        dfa.setMove(0, '0', 1);
        dfa.setMove(1, '1', 1);
        dfa.setMove(1, '0', 1);
        
        
        DFA dfaincomplete = new DFA(2);
        
        //finali
        dfaincomplete.addFinalState(1);
        
        
        dfaincomplete.setMove(0, '0', 1);
        dfaincomplete.setMove(1, '1', 1);
        dfaincomplete.setMove(1, '0', 1);
        
        
        //scan
        
        System.out.println("dfa Complete? " + dfa.complete());
        System.out.println("dfaincomplete Complete? " + dfaincomplete.complete());
    }
}
