/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lft;

import lft.sett4.DFA;

/**
 *
 * @author Simone
 */
public class Lft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DFA in = new DFA(3);
        in.addFinalState(0);
        
        in.setMove(0, 'c', 0);
        in.setMove(0, 'd', 1);
        in.setMove(1, 'd', 0);
        in.setMove(1, 'c', 2);
        in.setMove(2, 'c', 1);
        in.setMove(2, 'd', 2);
        
        in.minimize().toDOT("in");
        
        DFA out = new DFA(4);
        out.addFinalState(0);
        out.setMove(0, 'c', 0);
        out.setMove(0, 'd', 1);
        out.setMove(1, 'c', 2);
        out.setMove(1, 'd', 0);
        out.setMove(2, 'd', 2);
        out.setMove(2, 'c', 3);
        out.setMove(3, 'c', 2);
        out.setMove(3, 'd', 0);
        out.minimize().toDOT("out");
        
        System.out.println(in.equivalentTo(out));
    }
}
