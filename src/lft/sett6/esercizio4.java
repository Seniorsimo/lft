package lft.sett6;

/**
 * Implementare un metodo statico
 * che, dati due caratteri from e to, crea l'espressione regolare che genera
 * tutti i caratteri nell'intervallo da from a to, estremi inclusi. Utilizzando
 * tale metodo, costruire l'espressione regolare che genera le costanti
 * numeriche (Esercizio 1.2), ottenere il DFA minimo corrispondente e
 * verificarne la correttezza
 * 
 * genera (1+2+3+4+5+6+7+8+9)
 */
public class esercizio4 {
    public static void main(String args[]){
        
        new RegExpSequence(
            new RegExpChoice(
                new RegExpChoice(
                    new RegExpSymbol('+'),
                    new RegExpSymbol('-')
                ),
                new RegExpEpsylon()
            ),
            new RegExpSequence(
                new RegExpChoice(
                    new RegExpEpsylon(),
                    new RegExpSequence(
                        new RegExpSequence(
                            new RegExpRange('0','9'),
                            new RegExpStar(
                                new RegExpRange('0','9')
                            )
                        ),
                        new RegExpChoice(
                            new RegExpSequence(
                                new RegExpSymbol('e'),
                                new RegExpSequence(
                                    new RegExpChoice(
                                        new RegExpChoice(
                                            new RegExpSymbol('+'),
                                            new RegExpSymbol('-')
                                        ),
                                        new RegExpEpsylon()
                                    ),
                                    new RegExpSequence(
                                        new RegExpRange('0','9'),
                                        new RegExpStar(
                                            new RegExpRange('0','9')
                                        )
                                    )
                                )
                            ),
                            new RegExpEpsylon()
                        )
                    )
                ),
                new RegExpSequence(
                    new RegExpSymbol('.'),
                    new RegExpSequence(
                        new RegExpRange('0','9'),
                        new RegExpChoice(
                            new RegExpEpsylon(),
                            new RegExpSequence(
                                new RegExpStar(
                                    new RegExpRange('0','9')
                                ),
                                new RegExpSequence(
                                    new RegExpSymbol('e'),
                                    new RegExpSequence(
                                        new RegExpChoice(
                                            new RegExpChoice(
                                                new RegExpSymbol('+'),
                                                new RegExpSymbol('-')
                                            ),
                                            new RegExpEpsylon()
                                        ),
                                        new RegExpSequence(
                                            new RegExpRange('0','9'),
                                            new RegExpStar(
                                                new RegExpRange('0','9')
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ).compile().dfa().minimize().toDOTMod("Number");
                
    }
}
