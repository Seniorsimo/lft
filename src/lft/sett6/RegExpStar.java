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
public class RegExpStar implements RegExp{
    private RegExp e1;
    
    RegExpStar(RegExp e1) {
	this.e1 = e1;
    }

    @Override
    public NFA compile() {
        NFA a = new NFA(2);
	final int n = a.append(e1.compile());
	a.addMove(0, NFA.EPSILON, n);
        a.addMove(n + 1, NFA.EPSILON, n);
        a.addMove(n, NFA.EPSILON, n + 1);
	a.addMove(n + 1, NFA.EPSILON, 1);
	a.addFinalState(1);
	return a;
    }
    
}
