/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett2;

/**
 *
 * @author anna
 */
public class esercizio7 {
    public static void main(String []args){
        DFA tz = new DFA(4);
        tz.setMove(0, '1', 0);
        tz.setMove(0, '0', 1);
        tz.setMove(1, '1', 0);
        tz.setMove(1, '0', 2);
        tz.setMove(2, '1', 0);
        tz.setMove(2, '0', 3);
        tz.setMove(3, '1', 3);
        tz.setMove(3, '0', 3);
        tz.addFinalState(3);
        tz.toJava("trezeri");
    }
}
