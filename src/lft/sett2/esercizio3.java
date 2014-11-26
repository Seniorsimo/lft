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
public class esercizio3 {
    public static void main(String args[]){
        DFA dfa = new DFA(8);
        
        //finali
        dfa.addFinalState(2);
        dfa.addFinalState(4);
        dfa.addFinalState(7);
        
        //0
        for(char i='0'; i<='9'; i++)
            dfa.setMove(0,i, 2);
        dfa.setMove(0, '+', 1);
        dfa.setMove(0, '-', 1);
        dfa.setMove(0, '.', 3);
        
        //1
        for(char i='0'; i<='9'; i++)
            dfa.setMove(1,i, 2);
        dfa.setMove(1, '.', 3);
        
        //2
        for(char i='0'; i<='9'; i++)
            dfa.setMove(2,i, 2);
        dfa.setMove(2, '.', 3);
        dfa.setMove(2, 'e', 5);
        
        //3
        for(char i='0'; i<='9'; i++)
            dfa.setMove(3,i, 4);
        
        //4
        for(char i='0'; i<='9'; i++)
            dfa.setMove(4,i, 4);
        dfa.setMove(4, 'e', 5);
        
        //5
        for(char i='0'; i<='9'; i++)
            dfa.setMove(5,i, 7);
        dfa.setMove(5, '+', 6);
        dfa.setMove(5, '-', 6);
        
        //6
        for(char i='0'; i<='9'; i++)
            dfa.setMove(6,i, 7);
        
        //7
        for(char i='0'; i<='9'; i++)
            dfa.setMove(7,i, 7);
        
        
        //scan
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(dfa.scan(iao) ? " OK " : " NOPE ");
    }
}
