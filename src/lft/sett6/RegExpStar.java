package lft.sett6;

public class RegExpStar implements RegExp{
    private RegExp e1;
    
    RegExpStar(RegExp e1) {
	this.e1 = e1;
    }

    @Override
    public NFA compile() {
        NFA a = new NFA(2);
	final int n = a.append(e1.compile());
	a.addMove(0, NFA.EPSILON, n);
        a.addMove(0, NFA.EPSILON, 1);
        a.addMove(n + 1, NFA.EPSILON, 1);
	a.addMove(n + 1, NFA.EPSILON, n);
	a.addFinalState(1);
	return a;
    }
    
}
