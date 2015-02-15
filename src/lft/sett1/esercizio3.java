package lft.sett1;

import java.util.Scanner;

/**
 * (opzionale) Modificare l’automa dell’esercizio precedente in modo che
 * riconosca costanti numeriche precedute e/o seguite da sequenze eventualmente
 * vuote di spazi. Modificare l’implementazione Java dell’automa conseguentemente.
 * 
 * L'automa è stato modificato aggiungendo uno stato 8 e 5 transazioni per " ":
 * da 0 a 0 per leggere gli spazi in testa alla costante
 * da 2 a 8, da 4 a 8 e da 7 a 8 per il primo spazio in coda
 * da 8 a 8 per i successivi spazi
 */
public class esercizio3 {

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
                    } else if (ch == ' ') {
                        state = 0;
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
                    } else if (ch == ' ') {
                        state = 8;
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
                    } else if (ch == ' ') {
                        state = 8;
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
                    } else if (ch == ' ') {
                        state = 8;
                    } else {
                        state = -1;
                    }
                    break;
                case 8:
                    if (ch == ' ') {
                        state = 8;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }
        return state == 2 || state == 4 || state == 7 || state == 8;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String iao = scan.nextLine();
        System.out.println(iao);
        System.out.println(scan(iao) ? " OK " : " NOPE ");
    }
}
