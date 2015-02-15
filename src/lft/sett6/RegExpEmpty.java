package lft.sett6;

public class RegExpEmpty implements RegExp{
  
    
    RegExpEmpty(){
        
    }
    
    @Override
    public NFA compile() {
        NFA a = new NFA(0);
	return a;
    }
    
}
