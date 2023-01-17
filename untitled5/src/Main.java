import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

import Models.Feature;
import Models.Root;


public class Main {
       private static final String neighbors = null;

	public static void main(String args[]) {
    	   try {
    		   
    		   ObjectMapper om=new ObjectMapper();
    		   Root root = om.readValue(new File("src/test-json.json"),Root.class);
    		   System.out.println("full_id :"+root.features.get(0).properties.full_id);
    		   System.out.println("full_id :"+root.features.get(0).geometry.coordinates);
    		   
    		   
    		   Iterator itr=root.features.iterator();
    		   
    		  /// neighborhood list /////
    		   Graph graph=new Graph();
    		   for(int j=0; j<root.features.size(); j++)
   			{
   				Feature obj = root.features.get(j);
   				System.out.println("======================================= " +"Name of road"+ obj);
   			 
      			 
      			Node node1 = new Node(obj);
      			graph.addNode(node1);
      			//Node node2 = new Node(neighbors);
      			//graph.addNode(node2);
   				ArrayList<ArrayList<Double>> coordinates = obj.geometry.coordinates;
   				ArrayList<ArrayList<Double>> neighbors = new ArrayList<ArrayList<Double>>();
   				for (int i = 1; i < coordinates.size(); i++) {
   					ArrayList<Double> currentPoint = coordinates.get(i);
   					ArrayList<Double> previousPoint = coordinates.get(i - 1);

   					neighbors.add(previousPoint);
   					System.out.print("previous"+previousPoint);

   					if (i < coordinates.size() - 1) {
   						ArrayList<Double> nextPoint = coordinates.get(i + 1);
   						System.out.println(" - next"+nextPoint);
   						neighbors.add(nextPoint);
   						
   					}else{
   						System.out.println(" - end (no next)");
   					}

   				}
   				/// Kordinatlar arası mesafe hesaplama
   				Coordinate[] coords = new Coordinate[coordinates.size()];
   				for (int i = 0; i < coordinates.size(); i++) {
   				    coords[i] = new Coordinate(coordinates.get(i).get(0), coordinates.get(i).get(1));
   				   
   				}

   				LineString line = new GeometryFactory().createLineString(coords);
   				double distance = line.getLength();
   			  System.out.println("Distance between the start and end of the road"+distance);
   			 
   		 		    

     		    graph.addEdge(node1, node1, distance);
     		     
     			  graph.printGraph();
   			  
   			}
    	   }catch (Exception e) {
    		   e.printStackTrace();
    	   }
    	   
       }
       
}

