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

    public Pair dpllAlgorithm(Formula form){
        if(form.isEmpty()) return new Pair(true, form.getInterpretation());
        if(form.checkIfSat()) return new Pair(true, form.getInterpretation());
        if(form.doesEmptyClauseExists()) return new Pair(false, form.getInterpretation());
        satPosibilities r = form.unitPropagate();
        if( r == satPosibilities.unsat) return new Pair(false, form.getInterpretation());
        form.pureLiteral();
        int l = form.chooseLiteral();
        Formula f1 = form.copy();
        Formula f2 = form.copy();
        f1.assignLiteral(abs(l), true);
        f2.assignLiteral(abs(l), false);
        Pair p1 = dpllAlgorithm(f1);
        if(p1.getDecision()) return p1;
        else return dpllAlgorithm(f2);
    }
}
