/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett6;

/**
 *
 * @author anna
 */
public class esercizio2 {
    public static void main(String args[]){
        new RegExpSequence(
        new RegExpSequence(
                new RegExpSequence(
                    new RegExpSymbol('/'), new RegExpSymbol('*')), 
                
                new RegExpChoice(
                    new RegExpChoice(
                            new RegExpStar(new RegExpSymbol('*')),
                            new RegExpStar(
                            new RegExpSequence(new RegExpStar(new RegExpSymbol('*')), 
                                    new RegExpSequence(new RegExpSymbol('c'), 
                                            new RegExpSequence(new RegExpStar(new RegExpSymbol('*')), 
                                                    new RegExpStar(new RegExpSymbol('*')))))))

                    ,new RegExpSequence(new RegExpStar(new RegExpSymbol('c')), 
                        new RegExpStar(
                        new RegExpSequence(new RegExpStar(new RegExpSymbol('*')), 
                                new RegExpSequence(new RegExpSymbol('c'), 
                                        new RegExpSequence(new RegExpStar(new RegExpSymbol('c')), 
                                                new RegExpStar(new RegExpSymbol('/'))
                                                            )
                                                    )
                                            )
                                        )
                                )
                )),
        new RegExpSequence(new RegExpSymbol('*'), new RegExpSymbol('/'))
        ).compile().toDOT("grafo");
        
    }
}
