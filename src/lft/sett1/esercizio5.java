package lft.sett1;

import java.util.Scanner;

/**
 * (opzionale). Progettare e implementare un DFA che riconosca il linguaggio dei
 * numeri binari (stringhe di 0 e 1) il cui valore e multiplo di 3. Per esempio,
 * 110 e 1001 sono stringhe del linguaggio (rappresentano rispettivamente i
 * numeri 6 e 9), mentre 10 e 111 no (rappresentano rispettivamente i numeri 2
 * e 7). Suggerimento: usare tre stati per rappresentare il resto della
 * divisione per 3 del numero.
 * 
 * Prendiamo 4 stati: iniziale e uno per ogni resto possibile della divisione
 * per 3 del numero binario che andiamo a leggere, proseguiamo ragionando
 * come segue. (s1: resto 0, s2: resto 1, s3: resto 2)
 * Dallo stato iniziale (resto 0) possiamo passare agli stati:
 * s1 se leggiamo uno 0 (0%3 = 0)
 * s2 se leggiamo un 1 (1%3 = 1)
 * Ora lo stato 1 deve essere finale (resto 0 appunto), ma la stringa potrebbe
 * non essere finita, abbiamo quindi
 * s1 se leggiamo un ulteriore 0 (significa moltiplicare per 2 il numero letto
 * precedentemente e quindi raddoppiare anche il resto 0*2 = 0)
 * s2 se leggiamo un ulteriore 1 (raddoppio e aggiungo 1 al numero precedente
 * e quindi anche al resto 0*2 + 1 = 1)
 * Con lo stesso ragionamento controlliamo lo stato s2
 * s3 se leggo uno 0 ( 1*2 = 2)
 * s1 se leggo un 1 ( 1*2 + 1 = 3 = 0 )
 * Mentre per s3
 * s2 se leggo uno 0 ( 2*2 = 4 = 1)
 * s3 se leggo un 1 ( 2*2 + 1 = 5 = 2 )
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
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String iao = scan.next();
        System.out.println(iao);
        System.out.println(scan(iao) ? " OK " : " NOPE ");
    }
}
