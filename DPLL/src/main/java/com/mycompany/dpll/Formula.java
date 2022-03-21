package com.mycompany.dpll;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.NaN;
import static java.lang.Math.abs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

enum satPosibilities{
    unsat,
    sat,
    normal
}

public class Formula {
    private ArrayList<ArrayList<Integer>> clauses;
    private ArrayList<Integer> prop;
    private Interpretation interp;
    private Map<Integer,Integer> counter;

    public Formula(){
        clauses = new ArrayList<ArrayList<Integer>>();
        prop = new ArrayList<Integer>();
        counter = new HashMap<Integer,Integer>();
        interp = new Interpretation();
    }
    public Formula(ArrayList<ArrayList<Integer>> c, ArrayList<Integer>p){
        clauses = c;
        prop = p;
        interp = new Interpretation();
        counter = new HashMap<Integer,Integer>();
        for(int p1 : prop){
            counter.put(p1,0);
        }
        count();
    }
    
    private void count(){
        for(int p: prop){
            for(ArrayList<Integer> c: clauses){
                for(int l: c){
                    if(p == l || p == -l) counter.replace(p, counter.get(p) + 1);
                }
            }
        }
    }

    public int doesUnitExist(){
        for(ArrayList<Integer>c: clauses){
            if(c.size() == 1) return c.get(0);
        }
        return 0;
    }

    public satPosibilities unitPropagate(){
        System.out.println("unit");
        boolean stop = false;
        while(!stop){
            stop = true;
            for(int j = 0; j < clauses.size(); ++j){
                if(clauses.get(j).size() == 1){
                    stop = false;
                    int l = clauses.get(j).get(0);
                    System.out.println("unit literal je " + l);
                    if(l > 0) interp.addProp(l, true);
                    else interp.addProp(-l, false);
                    for(int i = 0; i < clauses.size(); ++i){
                        if(clauses.get(i).contains(l)){
                            clauses.remove(i);
                            --i;
                        }
                        else if(clauses.get(i).contains(-l)){
                            clauses.get(i).remove(clauses.get(i).indexOf(-l));
                            if(clauses.get(i).isEmpty()) return satPosibilities.unsat;
                        }
                    }
                }
            }
        }
        return satPosibilities.normal;
    }

    public void pureLiteral(){
        System.out.println("pure literal");
        for(int p: prop){
            boolean positive = false;
            boolean negative = false;
            for(ArrayList<Integer> c : clauses){
                for(int l: c){
                    if(l == p) positive = true;
                    if(l == -p) negative = true;
                }
            }
            if(positive == true && negative == false){ // set I(p) = 1 and remove clauses containing p
                System.out.println("pure literal founded " + p);
                interp.addProp(p, true);
                removeClauses(p);
            }
            else if(positive == false && negative == true){ // set I(p) = 0 and remove clauses containing p
                System.out.println("pure literal founded " + (-p));
                interp.addProp(p, false);
                removeClauses(-p);
            }
        }
    }
    
    private void removeClauses(int p){
        for(int i = 0; i < clauses.size(); ++i){
            boolean remove = false;
            for(int j = 0; j < clauses.get(i).size(); ++j){
                boolean removeLit = false;
                if(clauses.get(i).get(j) == p) {
                    remove = true;
                    //break;
                }
                if(clauses.get(i).get(j) == -p){
                    removeLit = true;
                    //break;
                }
                if(removeLit){
                    clauses.get(i).remove(j);
                    --j;
                }
            }
            if(remove){
                clauses.remove(i);
                --i;
            }
        }
    }

    public boolean isEmpty(){ 
        return clauses.isEmpty();
    }

    public boolean doesEmptyClauseExists(){ // is there false disj
        for(ArrayList<Integer> c : clauses){
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
        for(ArrayList<Integer> c : clauses){
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
    
    public int size(){
        return clauses.size();
    }

    public Formula copy(){
        ArrayList<Integer> newProp = new ArrayList<Integer>();
        for(int p: prop) newProp.add(p);
        ArrayList<ArrayList<Integer>> newClauses = new ArrayList<ArrayList<Integer>> ();
        for(ArrayList<Integer> c:clauses){
            ArrayList<Integer> newC = new ArrayList<>();
            for(int p : c) newC.add(p);
            newClauses.add(newC);
        }
        Formula f = new Formula(newClauses, newProp);
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
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("F={");
        for(int i = 0; i < clauses.size(); ++i){
            if(i != 0) ret.append("     ");
            for(int j = 0; j < clauses.get(i).size(); ++j){
                if(clauses.get(i).get(j) < 0) ret.append("-");
                ret.append("P" + abs(clauses.get(i).get(j)));
                if(j!=clauses.get(i).size()-1) ret.append(" \\/ ");
            }
            if(i!=clauses.size()-1) ret.append(",\n");
        }
        ret.append("}");
        return ret.toString();
    }

}
