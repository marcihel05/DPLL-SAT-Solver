package dpll;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
    private int numOfColors;
    private ArrayList<ArrayList<Integer>> edges;
    
    public GraphColoring(){
        numOfNodes = 0;
        numOfEdges = 0;
    }
    
    public GraphColoring(ArrayList<ArrayList<Integer>> al){
        graph = al;
        numOfNodes = al.get(0).size();
        /*for(int i = 0; i < numOfNodes; ++i){
            ArrayList<Integer> edge = new ArrayList<>();
            for(int j = i; j < numOfNodes; ++j){
                if(graph.get(i).get(j) == 1){
                     edge.add(i+1);
                     edge.add(j+1);
                }
                edges.add(edge);
            }
        }*/
    }
    
    public int getNumOfNodes(){
        return numOfNodes;
    }
    
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
    public void setNumOfColors(int k){
        numOfColors = k;
    }
    
    public Formula generateFormula(){      
        int id = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> prop = new ArrayList<>();
        for(int i = 1; i <= graph.get(0).size(); ++i){ //every vertex must be colored
            ArrayList<Integer> c = new ArrayList<>();
            for(int j = 1; j <= numOfColors; ++j){
                prop.add(Integer.parseInt("" + i + j));
                c.add(Integer.parseInt("" + i+ j));
            }
            map.put(id,c);
            ++id;
        }
        
        for(int i = 1; i <= numOfNodes; ++i){
            ArrayList<Integer> c = new ArrayList<>();
            for(int j = 1; j <= numOfColors; ++j){ //every vertex can be colored with no more than one color
               c.add(Integer.parseInt("-"+ i + j));
            }
            map.put(id,c);
            ++id;
        }
        
        for(int i = 0; i< numOfNodes; ++i){
            for(int k = 1; k <= numOfColors; ++k){
                for(int j = i; j < numOfNodes; ++j){
                    ArrayList<Integer> c = new ArrayList<>();
                    if(graph.get(i).get(j) == 1){
                        c.add(Integer.parseInt("-"+(i+1)+(k)));
                        c.add(Integer.parseInt("-"+(j+1)+(k)));
                        map.put(id,c);
                        ++id;
                    }
                    
                }
            }
        }
        
        Formula f = new Formula(prop, map);
        return f;
    }
    
    public ArrayList<ArrayList<Integer>> getMatrix(){
        return graph;
    }
    
    public GraphColoring randomGraphGenerator(int num){
        Random rnd = new Random();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i = 0; i < num; ++i){
            ArrayList<Integer> row = new ArrayList<>();
            for( int j = 0; j <num; ++j){
                if(j >= i) {
                    if(rnd.nextDouble() >= 0.5) row.add(1);
                    else row.add(0);
                }
                else{
                    row.add(mat.get(j).get(i));
                }
            }
            mat.add(row);
        }
        //spremi graf u fajl
        GraphColoring g = new GraphColoring(mat);
        return g;
    }
    
}
