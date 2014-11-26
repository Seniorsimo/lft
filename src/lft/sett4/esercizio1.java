/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett4;

/**
 *
 * @author simone
 */
public class esercizio1 {
    public static void main(String[] args){
        DFA in = new DFA(4);
        in.addFinalState(1);
        in.addFinalState(3);
        
        in.setMove(0, '0', 0);
        in.setMove(0, '1', 1);
        in.setMove(1, '1', 1);
        in.setMove(1, '0', 2);
        in.setMove(2, '1', 3);
        in.setMove(2, '0', 2);
        in.setMove(3, '1', 3);
        in.setMove(3, '0', 2);
        
        in.toDOT("in");
        
        DFA out = in.minimize();
        out.toDOT("out");
        
    }
}
