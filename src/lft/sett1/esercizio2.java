package lft.sett1;

import java.util.Scanner;

/**
 * Progettare un DFA che riconosca il linguaggio delle costanti numeriche in
 * virgola mobile. Esempi di tali costanti sono:
 * 123 123.5 .567 +7.5 -.7 67e10 1e-2 -.7e2
 * 
 * Realizzare il DFA in Java seguendo la costruzione vista in Figura 2,
 * assicurarsi che l’implementazione riconosca il linguaggio desiderato.
 * 
 * In base al particolare stato finale in cui si trova l’automa al termine del
 * riconoscimento, cosa si puo dire della costante numerica riconosciuta? 
 * Si può distinguere fra numeri senza parte decimale (stato 2), con parte
 * decimale (stato 4), con parte esponenziale (stato7, con o senza parte
 * decimale)
 */
public class esercizio2 {

    public static boolean scan(String s) {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0:
                    if (ch >= '0' && ch <= '9') {
                        state = 2;
                    } else if (ch == '.') {
                        state = 3;
                    } else if (ch == '+' || ch == '-') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;

                case 1:
                    if (ch >= '0' && ch <= '9') {
                        state = 2;
                    } else if (ch == '.') {
                        state = 3;
                    } else {
                        state = -1;
                    }
                    break;

                case 2:
                    if (ch >= '0' && ch <= '9') {
                        state = 2;
                    } else if (ch == '.') {
                        state = 3;
                    } else if (ch == 'e') {
                        state = 5;
                    } else {
                        state = -1;
                    }
                    break;

                case 3:
                    if (ch >= '0' && ch <= '9') {
                        state = 4;
                    } else {
                        state = -1;
                    }
                    break;

                case 4:
                    if (ch >= '0' && ch <= '9') {
                        state = 4;
                    } else if (ch == 'e') {
                        state = 5;
                    } else {
                        state = -1;
                    }
                    break;

                case 5:
                    if (ch >= '0' && ch <= '9') {
                        state = 7;
                    } else if (ch == '+' || ch == '-') {
                        state = 6;
                    } else {
                        state = -1;
                    }
                    break;

                case 6:
                    if (ch >= '0' && ch <= '9') {
                        state = 7;
                    } else {
                        state = -1;
                    }
                    break;

                case 7:
                    if (ch >= '0' && ch <= '9') {
                        state = 7;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }
        return state == 2 || state == 4 || state == 7;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(scan(iao) ? " OK " : " NOPE ");
    }
}
