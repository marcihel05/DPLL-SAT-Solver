package dpll;

import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.Map;

public class Interpretation {
    private Map<Integer, Boolean> interp;

    public Interpretation(){
        interp = new HashMap<>();
    }

    public void addProp(int p, boolean a){
        interp.put(p, a);
    }

    public boolean doesPropExist(int p){
        return interp.containsKey(p);
    }

    public boolean getLiteralAssignment(int p){
        if(!interp.containsKey(abs(p))) {
            System.out.println(p + "ne postoji, ali vracam false");
            return false;
        }
        if(p < 0) return !interp.get(abs(p));
        return interp.get(p);

    }
    
    public int size(){
        return interp.size();
    }
    
    public Interpretation copy(){
        Interpretation i = new Interpretation();
        for(var p : interp.entrySet()){
            i.addProp(p.getKey(), p.getValue());
        }
        return i;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(var i: interp.entrySet()){
            if(i.getValue() == true) ret.append("I(P").append(i.getKey()).append(") = 1");
            else ret.append("I(P").append(i.getKey()).append(") = 0");
            ret.append("\n");
        }
        return ret.toString();
    }
    
}
