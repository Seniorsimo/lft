/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett6;

/**
 *
 * @author simone
 */
public class esercizio1 {
    public static void main(String args[]){
        new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b')).compile().toDOT("grafo");
    }
}
