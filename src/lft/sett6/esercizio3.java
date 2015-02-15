package lft.sett6;

/**
 * Giustificare l’apparente stranezza del DFA ottenuto eseguendo l’istruzione:
 * 
 * Legge tutte e sole le stringhe formate da 'a' o da 'b' in un qualsiasi ordine
 * e numero.
 * 
 */
public class esercizio3 {
    public static void main(String args[]){
        
        new RegExpStar(new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b'))).compile().dfa().minimize().toDOT("prova");
    }
}
