/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett6;

/**
 *accetta tutte le combinazioni di a/b + la stringa vuota
 * @author anna
 */
public class esercizio3 {
    public static void main(String args[]){
        
        new RegExpStar(new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b'))).compile().dfa().minimize().toDOT("prova");
    }
}