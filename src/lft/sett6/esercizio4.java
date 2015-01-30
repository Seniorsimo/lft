/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett6;

/**
 *genera (1+2+3+4+5+6+7+8+9)
 * @author anna
 */
public class esercizio4 {
    public static void main(String args[]){
        new RegExpRange('1', '9').compile().dfa().minimize().toDOT("64");
    }
}
