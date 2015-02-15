package lft.sett1;

import java.util.Scanner;

/**
 * (opzionale). Progettare e implementare un DFA che riconosca il linguaggio
 * degli identificatori in un linguaggio in stile Java: un identificatore e una
 * sequenza non vuota di lettere, numeri, ed il simbolo di sottolineatura _ che
 * non comincia con un numero e che non può essere composto solo da un _.
 * 
 * Trattandosi di una sequenza non vuota sono necessari minimo 2 stati.
 * Da S0 dobbiamo distinguere 2 casi: inisio per _ o con lettera.
 * Nel primo caso passo ad uno stato che non può essere finale, devo leggere
 * almeno un altro simbolo (qualsiasi) raggiungendo lo stato finale;
 * nel secondo caso invece raggiungo lo stato finale direttamente.
 */
public class esercizio4 {

    public static boolean scan(String s) {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0:
                    if (ch == '_') {
                        state = 2;
                    } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;
                case 1:
                    if (ch == '_') {
                        state = 1;
                    } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        state = 1;
                    } else if (ch >= '0' && ch <= '9') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;
                case 2:
                    if (ch == '_') {
                        state = 1;
                    } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        state = 1;
                    } else if (ch >= '0' && ch <= '9') {
                        state = 1;
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
