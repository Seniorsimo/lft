package lft.sett6;

/**
 * Implementare le classi RegExpEpsilon, RegExpEmpty, RegExpChoice, RegExpStar
 * seguendo la traccia data qui sopra. Verificare il corretto funzionamento del
 * metodo compile producendo l'epsilon-NFA corrispondente a un insieme
 * ragionevole di espressioni regolari di complessita crescente
 * 
 */
public class esercizio1 {
    public static void main(String args[]){
        new RegExpSequence(new RegExpStar(
                new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b'))), 
                new RegExpStar(new RegExpSymbol('c')))
                .compile().toDOT("grafo");
        //new RegExpSequence(new RegExpSequence(new RegExpSymbol('a'), new RegExpStar(new RegExpSymbol('b'))), new RegExpSymbol('c')).compile().toDOT("star");
    }
}
