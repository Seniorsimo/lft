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
public class RegExpEmpty implements RegExp{

    RegExpEmpty(){
        
    }
    
    @Override
    public NFA compile() {
        NFA a = new NFA(0);
	return a;
    }
    
}
