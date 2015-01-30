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


public class RegExpRange implements RegExp{
    //DA COMPLETARE 6.4
    
    private int s1;
    private int s2;
    
    public RegExpRange(char from, char to) {
	this.s1 = from;
	this.s2 = to;
    }

    @Override
    public NFA compile() {
        if((s1-s2) == 0){ //se from e to sono lo stesso simbolo
            return new RegExpSymbol((char)s2).compile();
        } else {
            int x = s1+1;
            char tmp = (char) x; //carattere successivo nella tavola dei caratteri
            return new RegExpChoice(
                    new RegExpSymbol((char)s1),
                    new RegExpRange(tmp, (char)s2)
            ).compile();
        }
        
    }
    
}
