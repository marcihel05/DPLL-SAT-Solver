/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dpll;

/**
 *
 * @author helena
 */
public class Pair {
    private boolean decision;
    private Interpretation interpr;
    
    public Pair(boolean d, Interpretation i){
        decision = d;
        interpr = i;
    }
    
    boolean getDecision(){
        return decision;
    }
    
    Interpretation getInterpretation(){
        return interpr;
    }
}
