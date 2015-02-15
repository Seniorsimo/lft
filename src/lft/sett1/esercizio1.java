package lft.sett1;

import java.util.Scanner;

/**
 * Copiare il codice in Figura 2, compilarlo e accertarsi che funzioni
 * correttamente testandolo su un insieme significativo di stringhe,
 * per es. 010101, 1100011001, 10214, ecc.
 * 
 * Come deve essere modificato il codice per riconoscere il linguaggio
 * complementare, ovvero il linguaggio delle stringhe di 0 e 1 che non
 * contengono 3 zeri consecutivi? 
 * Semplicemente è sufficiente negare il valore booleano restituito dal
 * metodo scan: accettare tutte le strignhe tranne quelle contenenti 3 zeri
 * consecutivi.
 */

public class esercizio1 {

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
                        state = 0;
                    } else {
                        state = -1;
                    }
                    break;
                case 1:
                    if (ch == '0') {
                        state = 2;
                    } else if (ch == '1') {
                        state = 0;
                    } else {
                        state = -1;
                    }
                    break;
                case 2:
                    if (ch == '0') {
                        state = 3;
                    } else if (ch == '1') {
                        state = 0;
                    } else {
                        state = -1;
                    }
                    break;
                case 3:
                    if (ch == '0' || ch == '1') {
                        state = 3;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }
        return state == 3;
        
        //esempio pratico alla domanda posta:
        //return state != 3;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(scan(iao) ? " OK " : " NOPE ");
    }
}