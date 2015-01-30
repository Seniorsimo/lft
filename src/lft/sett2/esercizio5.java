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
public class esercizio5 {
    public static void main(String args[]){
        DFA dfa = new DFA(4);
        
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
        dfa.setMove(2, '1', 0);
        
        //3
        dfa.setMove(3, '0', 3);
        dfa.setMove(3, '1', 3);
        
        
        //scan

        dfa.toDOT("prova");
        //dfa.toDOTMod("provamod");

    }
}
