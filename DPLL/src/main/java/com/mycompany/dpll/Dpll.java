/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dpll;

import static java.lang.Math.abs;
import java.util.Map;

/**
 *
 * @author helena
 */
public class Dpll {
    private Formula formula;

    public Dpll(Formula f){
        formula = f;
    }
    
    public Pair start(){
        return dpllAlgorithm(formula);
    }

    private Pair dpllAlgorithm(Formula form){
        System.out.println("pocetak");
        System.out.println("broj disj na pocetku je " + form.size());
        satPosibilities r = form.unitPropagate();
        System.out.println("broj disj nakon unit je " + form.size());
        if( r == satPosibilities.unsat) return new Pair(false, form.getInterpretation());
        form.pureLiteral();
        System.out.println("broj disj nakon pure je " + form.size());
        if(form.isEmpty()) return new Pair(true, form.getInterpretation());
        if(form.checkIfSat()) return new Pair(true, form.getInterpretation());
        if(form.doesEmptyClauseExists()) return new Pair(false, form.getInterpretation());
        int l = form.chooseLiteral();
        Formula f1 = form.copy();
        Formula f2 = form.copy();
        System.out.println("odabrani literal je " + l);
        f1.assignLiteral(l, false);
        f2.assignLiteral(l, true);
        Pair p1 = dpllAlgorithm(f1);
        if(p1.getDecision()) return p1;
        else {System.out.println("probam s true za " + l); return dpllAlgorithm(f2);}
    }
}
