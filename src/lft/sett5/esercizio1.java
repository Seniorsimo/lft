/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett5;

import java.util.HashSet;

/**
 *
 * @author anna
 */
public class esercizio1 {
    public static void main(String[] args) {
        NFA automata = new NFA(7);
        automata.addMove(0, '\0', 1);
        automata.addMove(1, '\0', 2);
        automata.addMove(2, '\0', 5);
        automata.addMove(0, '\0', 3);
        automata.addMove(0, '0', 4);
        automata.addMove(4, '1', 5);
        automata.addMove(4, '\0', 6);
        automata.addFinalState(6);
//automata.toDOT("NFA");
        HashSet out = automata.epsilonClosure(0);

        System.out.println(out);
    }
    
}
