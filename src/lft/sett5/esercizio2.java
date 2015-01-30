/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett5;

/**
 * DFA: trasformando in dfa il nfa viene ridotto di stati
 * MIN: minimizzando arrivo sempre al minimo numero di stati
 * @author anna
 */
public class esercizio2 {
    public static void main(String[] args){
        for(int i=0; i<10; i++){
            NFA test = NFA.nth(i);
            System.out.println("NFA: " + test.numberOfStates() + "; DFA: " + test.dfa().numberOfStates() + "; MIN: " + test.dfa().minimize().numberOfStates());
        }
    }
}
