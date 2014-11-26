/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lft.sett1;

import java.util.Scanner;
import static lft.sett1.esercizio1.scan;

/**
 *
 * @author Simone
 */
public class esercizio5 {

    public static boolean scan(String s) {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0:
                    if (ch == '0') {
                        state = 1;
                    } else if (ch == '1') {
                        state = 2;
                    } else {
                        state = -1;
                    }
                    break;
                case 1:
                    if (ch == '0') {
                        state = 1;
                    } else if (ch == '1') {
                        state = 2;
                    } else {
                        state = -1;
                    }
                    break;
                case 2:
                    if (ch == '0') {
                        state = 3;
                    } else if (ch == '1') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;
                case 3:
                    if (ch == '0') {
                        state = 2;
                    } else if (ch == '1') {
                        state = 3;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }
        return state == 1;
        //return state != -1 && state < 3;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(scan(iao) ? " OK " : " NOPE ");
    }
}
