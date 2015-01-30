/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett3;

import java.util.HashSet;

public class esercizio1 {
    public static void main(String[] args){
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
        
        
//scan

        DFA Edfa = new DFA(0);
        dfa.toDOT("dfa");
//        HashSet temp = dfa.reach(0);
//        for(Object i : temp){
//            System.out.println((Integer)i + "");
//        }
        System.out.println(dfa.reach(0));
        System.out.println(dfa.empty());
        System.out.println(Edfa.empty());
        System.out.println(dfa.sink());
        
        

    }
}
