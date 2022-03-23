package dpll;


import dpll.Formula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helena
 */
public class PigeonProblem {
    
    private int n;
    
    public PigeonProblem(int num){
        n = num;
    }
    
    public Formula generateFormula(){
        int id = 0;
        ArrayList<Integer> prop = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> f = new HashMap<>();
        int numOfProp = n*(n+1);
        for(int i = 1; i <= n+1; ++i){ //every pigeon must be in a pigeon hole
            ArrayList<Integer> c = new ArrayList<>();
            for(int j = 1; j <= n; ++j){
                prop.add(Integer.parseInt("" + j + i));
                c.add(Integer.parseInt("" + j + i));
            }
            f.put(id, c);
            ++id;
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j < n+1; ++j){
                
                for( int k = 1; k <=n+1-j; ++k){
                    ArrayList<Integer> c = new ArrayList<>();
                    c.add(Integer.parseInt("-" + i +j));
                    c.add(Integer.parseInt("-" + i +(j+k)));
                    f.put(id,c);
                    ++id;
                }
                
                
            }
        }
        //var lit = countLiterals(f,prop);
        Formula formula = new Formula(prop,f);
        return formula;
    }
    
    public HashMap<Integer,Set<Integer>> countLiterals(HashMap<Integer,ArrayList<Integer>> f, ArrayList<Integer> propVar){
        HashMap<Integer,Set<Integer>> ret = new HashMap<>();
        var keys = f.keySet().toArray(new Integer[0]);
        for(int p: propVar){
            Set<Integer> sp = new TreeSet<>();
            Set<Integer> sm = new TreeSet<>();
            for(int i = 0; i < keys.length; ++i){
                ArrayList<Integer> clause = f.get(keys[i]);
                for( int j = 0; j < clause.size(); ++j){
                    if(clause.get(j) == p){
                        sp.add(keys[i]);
                    }
                    if(clause.get(j) == -p){
                        sm.add(keys[i]);
                    }
                }
            }
            ret.put(p, sp);
            ret.put(-p,sm);
        }
        return ret;
    }
}
