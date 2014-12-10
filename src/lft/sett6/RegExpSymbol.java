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
public class RegExpSymbol implements RegExp {
    private char ch;

    RegExpSymbol(char ch) {
	this.ch = ch;
    }

    @Override
    public NFA compile() {
	NFA a = new NFA(2);
	a.addMove(0, ch, 1);
	a.addFinalState(1);
	return a;
    }
}
