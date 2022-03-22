package dpll;


import java.io.File;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helena
 */
public class GraphColoring {
    
    private int numOfNodes;
    private int numOfEdges;
    private ArrayList<ArrayList<Integer>> graph;
    
    public GraphColoring(){
        numOfNodes = 0;
        numOfEdges = 0;
    }
    
    public GraphColoring(ArrayList<ArrayList<Integer>> al){
        graph = al;
    }
    
    public int getNumOfNodes(){
        return numOfNodes;
    }
    
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
    public Formula generateFormula(){
        Formula f = new Formula();
        
        return f;
    }
}
