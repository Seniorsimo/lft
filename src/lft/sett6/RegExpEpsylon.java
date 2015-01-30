/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett6;


public class RegExpEpsylon implements RegExp {

    RegExpEpsylon(){
        
    }
    
    @Override
    public NFA compile() {
        NFA a = new NFA(2);
	a.addMove(0, NFA.EPSILON, 1);
	a.addFinalState(1);
	return a;
    }
    
}
