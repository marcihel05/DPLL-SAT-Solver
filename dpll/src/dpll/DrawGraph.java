/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpll;
import java.util.ArrayList;
import java.util.HashMap;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 * @source - https://graphstream-project.org/
 * @author helena
 */
public class DrawGraph {
    
    GraphColoring g;
    String[] colors = {"IndianRed", "LightGreen",  "LightCyan",  "orange", "yellow", "LightPink", "ForestGreen", "SteelBlue", "purple",  "PeachPuff"};
    
    public DrawGraph(GraphColoring g)
    {
        this.g = g;
    }
    public void draw() 
    {
        System.setProperty("org.graphstream.ui", "swing");	
	org.graphstream.graph.Graph graph = new SingleGraph("Graph");
        for(int i = 0; i < g.getNumOfNodes(); ++i)
           graph.addNode(Integer.toString(i+1)).setAttribute("label", Integer.toString(i+1));
        ArrayList<ArrayList<Integer>> matrix = g.getMatrix();
	for(int i = 0; i < g.getNumOfNodes(); ++i){
            for( int j = i; j< g.getNumOfNodes(); ++j){
                if(matrix.get(i).get(j) == 1){
                    String is = Integer.toString(i+1);
                    String js = Integer.toString(j+1);
                    graph.addEdge(is+js, is, js);
                }
                    
                
            }
        }
        graph.nodes().forEach(n -> n.setAttribute("ui.style", "fill-color: white; size: 25; text-size: 13; stroke-mode: plain; stroke-color: black;"));
        graph.edges().forEach(e -> e.setAttribute("ui.style", "fill-color: darkgrey; size:2;"));
                
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    public void color(int numOfColors, HashMap<Integer,Integer> howToColor){
        System.setProperty("org.graphstream.ui", "swing");	
	org.graphstream.graph.Graph graph = new SingleGraph("Graph");
        for(int i = 0; i < g.getNumOfNodes(); ++i){
            graph.addNode(Integer.toString(i+1)).setAttribute("label", Integer.toString(i+1));
            String atr = "fill-color:" + colors[howToColor.get(i+1)-1] +"; size: 25; text-size: 13; stroke-mode: plain; stroke-color: black;";
            graph.getNode(Integer.toString(i+1)).setAttribute("ui.style", atr);
        }
           
        ArrayList<ArrayList<Integer>> matrix = g.getMatrix();
	for(int i = 0; i < g.getNumOfNodes(); ++i){
            for( int j = i; j< g.getNumOfNodes(); ++j){
                if(matrix.get(i).get(j) == 1){
                    String is = Integer.toString(i+1);
                    String js = Integer.toString(j+1);
                    graph.addEdge(is+js, is, js);
                }
                    
                
            }
        }
        graph.edges().forEach(e -> e.setAttribute("ui.style", "fill-color: darkgrey; size:1.5;"));
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
}
