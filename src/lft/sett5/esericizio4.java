/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett5;


public class esericizio4 {

    /**
     * 
     * non è strettamente necessario dotare NFA di toDOT poichè esiste sempre un DFA
     * equivalente che ha già un suo metodo toDOT, ma con l'nfa posso gestire le epsilon
     */
    public static void main(String[] args) {

        NFA test = NFA.nth(5);
        test.toDOT("Test");
       
        test.dfa().toDOT("TestDFA");
        
    }
}
