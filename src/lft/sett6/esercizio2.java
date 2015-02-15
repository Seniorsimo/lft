package lft.sett6;

/**
 * Individuare un'espressione regolare E definita sull'alfabeto {/, *, c} che
 * generi le sequenze di almeno 4 caratteri che iniziano con / *, che finiscono
 * con * /, e che contengono una sola occorrenza della sequenza * /, quella
 * finale. Istanziare oggetti delle classi RegExp* per rappresentare E in Java
 * e produrre l'epsilon-NFA corrispondente attraverso il metodo compile.
 * Verificare la correttezza dell'espilon-NFA corrispondente, nonche del DFA
 * equivalente, e del DFA minimo corrispondente a quest'ultimo. Per esempio,
 * verificare che il DFA accetti le stringhe / **** / e / *c*c* / ma non / * /
 * oppure / ** /** /
 * 
 * NB: nella descrizione gli spazi fra * e / soo da togliere
 */
public class esercizio2 {
    public static void main(String args[]){
        new RegExpSequence(
                new RegExpSequence(
                        new RegExpSequence(
                                new RegExpSymbol('/'),
                                new RegExpSymbol('*')
                        ),
                        new RegExpStar(
                            new RegExpChoice(
                                    new RegExpSymbol('c'),
                                    new RegExpSymbol('*')
                            )
                        )
                ),
                new RegExpSequence(
                        new RegExpSymbol('*'),
                        new RegExpSymbol('/')
                )
        ).compile().dfa().minimize().toDOT("grafo");
    }
}
