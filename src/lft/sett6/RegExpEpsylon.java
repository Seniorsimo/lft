package lft.sett6;

public class RegExpEpsylon implements RegExp {

    RegExpEpsylon(){
        
    }
    
    @Override
    public NFA compile() {
        NFA a = new NFA(2);
	a.addMove(0, NFA.EPSILON, 1);
	a.addFinalState(1);
	return a;
    }
    
}
