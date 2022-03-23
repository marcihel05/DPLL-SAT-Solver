package dpll;

import java.util.ArrayList;

import static java.lang.Math.abs;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

enum satPosibilities{
    unsat,
    sat,
    normal
}

public class Formula {
    private HashMap<Integer,ArrayList<Integer>> clauses;
    private ArrayList<Integer> prop;
    private Interpretation interp;
    private Map<Integer,Integer> counter;
    private HashMap<Integer,Set<Integer>> literals;

    public Formula(){
        prop = new ArrayList<>();
        counter = new HashMap<>();
        interp = new Interpretation();
        literals = new HashMap<>();
        clauses = new HashMap<>();
    }
    public Formula(ArrayList<Integer>p, HashMap<Integer,ArrayList<Integer>> _c){;
        prop = p;
        interp = new Interpretation();
        counter = new HashMap<>();
        clauses = _c;
        countLiterals();
        for(int p1 : prop){
            counter.put(p1,0);
        }
        count();
    }
    
    private void count(){
        for(int p: prop){
            for(ArrayList<Integer> c: clauses.values()){
                for(int l: c){
                    if(p == l || p == -l) counter.replace(p, counter.get(p) + 1);
                    if(interp.doesPropExist(p)) counter.replace(p,-1);
                }
            }
        }
    }

    public int doesUnitExist(){
        for(ArrayList<Integer>c: clauses.values()){
            if(c.size() == 1) return c.get(0);
        }
        return 0;
    }

    public satPosibilities unitPropagate(){
        //System.out.println("unit");
        boolean stop = false;
        while(!stop){
            stop = true;
            var keys = clauses.keySet().toArray(new Integer[0]);
            for(int i = 0; i < clauses.keySet().size(); ++i){
                if(clauses.get(keys[i]).size() == 1){
                    stop = false;
                    int l = clauses.get(keys[i]).get(0);
                    System.out.println("unit literal je " + l);
                    if(l > 0) interp.addProp(l, true);
                    else interp.addProp(-l, false);
                    counter.replace(abs(l),-1);
                    for(int j = 0; j < clauses.keySet().size(); ++j){
                        if(clauses.containsKey(keys[j])){
                            if(clauses.get(keys[j]).contains(l)){
                                clauses.remove(keys[j]);
                                --j;
                                keys = clauses.keySet().toArray(new Integer[0]);
                            }
                            else if(clauses.get(keys[j]).contains(-l)){
                                //System.out.println("nasao suprotno od " + l);
                                clauses.get(keys[j]).remove((Integer)(-l));
                                if(clauses.get(keys[j]).isEmpty()) {
                                    System.out.println("gotovo");
                                    return satPosibilities.unsat;
                                }
                               
                            }
                            
                        }   
                    }
                }
            }
        }
        return satPosibilities.normal;
    }

    public void pureLiteral(){
        //System.out.println("pure literal");
        for(int p: prop){
            boolean positive = false;
            boolean negative = false;
            for(ArrayList<Integer> c : clauses.values()){
                for(int l: c){
                    if(l == p) positive = true;
                    if(l == -p) negative = true;
                }
            }
            if(positive == true && negative == false){ // set I(p) = 1 and remove clauses containing p
                System.out.println("pure literal founded " + p);
                interp.addProp(p, true);
                counter.replace(abs(p),-1);
                removeClauses(p);
            }
            else if(positive == false && negative == true){ // set I(p) = 0 and remove clauses containing p
                System.out.println("pure literal founded " + (-p));
                interp.addProp(p, false);
                counter.replace(abs(p),-1);
                removeClauses(-p);
            }
        }
    }
    
    private void removeClauses(int p){
        var c = literals.get(p).toArray(new Integer[0]);
        for(int i = 0; i < literals.get(p).size(); ++i) clauses.remove(c[i]);
        var negc = literals.get(-p).toArray(new Integer[0]);
        for(int i = 0; i < negc.length; ++i){
            if(clauses.containsKey(negc[i]))
            clauses.get(negc[i]).remove((Integer)(-p));
        }
    }

    public boolean isEmpty(){ 
        return clauses.isEmpty();
    }

    public boolean doesEmptyClauseExists(){ // is there false disj
        for(ArrayList<Integer> c : clauses.values()){
            boolean disj = false;
            boolean notDef = false;
            for(int l : c){
                if(interp.doesPropExist(abs(l))){
                    disj = disj || interp.getLiteralAssignment(l);
                }
                else {
                    notDef = true;
                    break;
                }
            }
            if(!notDef && !disj) return true;
        }
        return false;
    }

    public int chooseLiteral(){
        count();
        int maxValue = (Collections.max(counter.values()));
        for(int p : prop){
            if(maxValue == counter.get(p)) return p;
        }
        
        return 0;
    }
    
    public void assignLiteral(int l, boolean assignment){
        interp.addProp(l, assignment);
        counter.replace(abs(l),-1);
        if(assignment == true) removeClauses(l);
        else removeClauses(-l);
    }
    
    public boolean checkIfSat(){
        boolean sat = true;
        for(ArrayList<Integer> c : clauses.values()){
            boolean disj = false;
            for(int l : c){
                if(interp.doesPropExist(abs(l))){
                    disj = disj || interp.getLiteralAssignment(l);
                }
            }
            sat = sat && disj;
            if(sat == false) return false;
        }
        return true;
    }
    
    public void countLiterals(){
        literals = new HashMap<>();
        var keys = clauses.keySet().toArray(new Integer[0]);
        for(int p: prop){
            Set<Integer> sp = new TreeSet<>();
            Set<Integer> sm = new TreeSet<>();
            for(int i = 0; i < keys.length; ++i){
                ArrayList<Integer> clause = clauses.get(keys[i]);
                for( int j = 0; j < clause.size(); ++j){
                    if(clause.get(j) == p){
                        sp.add(keys[i]);
                    }
                    if(clause.get(j) == -p){
                        sm.add(keys[i]);
                    }
                }
            }
            literals.put(p, sp);
            literals.put(-p,sm);
        }
    }
    
    public int size(){
        return clauses.size();
    }
    
    public int numOfProp(){
        return prop.size();
    }

    public Formula copy(){
        ArrayList<Integer> newProp = new ArrayList<Integer>();
        for(int p: prop) newProp.add(p);
        HashMap<Integer,ArrayList<Integer>> new_clauses = new HashMap<>();
        for(var p: clauses.entrySet()){
            ArrayList<Integer> newSet = new ArrayList<>();
            newSet.addAll(p.getValue());
            new_clauses.put(p.getKey(), newSet);
        }
        
        
        HashMap<Integer,Set<Integer>> newLit = new HashMap<>();
        Formula f = new Formula(newProp, new_clauses);
        Interpretation inter = new Interpretation();
        f.setInterpretation(interp.copy());
        return f;
    }
    
    
    public Interpretation getInterpretation(){
        return interp;
    }
    
    public void setInterpretation(Interpretation i){
        interp = i;
    }
    
    public HashMap<Integer,ArrayList<Integer>> getClauses(){
        return clauses;
    }
    
    public ArrayList<Integer> getProp(){
        return prop;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("F = { ");
        var keys = clauses.keySet().toArray(new Integer[0]);
        for(int i = 0; i < clauses.size(); ++i){
            if(i != 0) ret.append("     ");
            for(int j = 0; j < clauses.get(keys[i]).size(); ++j){
                if(clauses.get(keys[i]).get(j) < 0) ret.append("-");
                ret.append("P" + abs(clauses.get(keys[i]).get(j)));
                if(j!= clauses.get(keys[i]).size()-1) ret.append(" \\/ ");
            }
            if(i!=clauses.size()-1) ret.append(",\n");
        }
        ret.append(" }");
        return ret.toString();
    }

}
