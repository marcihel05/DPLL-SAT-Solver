/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpll;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author helena
 */
public class DrawGraph {
    
    GraphColoring g;
    
    public DrawGraph(GraphColoring g)
    {
        this.g = g;
    }
    public void draw() 
    {
        System.setProperty("org.graphstream.ui", "swing");	
	org.graphstream.graph.Graph graph = new SingleGraph("Graph");
        for(int i = 0; i < g.getN(); ++i)
           graph.addNode(Integer.toString(i)).setAttribute("label", Integer.toString(i));
	for(int i = 0; i < g.getN(); ++i){
            for( int j = 0; j< g.getN(); ++j){
                var w = g.getWeightBetween(i,j);
                if( w != null){
                    String is = Integer.toString(i);
                    String js = Integer.toString(j);
                    Node n = graph.getNode(is);
                    if( !n.hasEdgeToward(js))
                        graph.addEdge(is+js, is, js).setAttribute("length", w);
                }
            }
        }
        graph.nodes().forEach(n -> n.setAttribute("ui.style", "fill-color: lightblue; size: 20; text-size: 13;"));
        graph.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("length")));
        graph.edges().forEach(e -> e.setAttribute("ui.style", "text-color: darkred; text-size: 13; fill-color: darkgrey; size:1.5;"));
                
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
	}
}
