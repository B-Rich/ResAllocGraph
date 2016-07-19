/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlo5;

/**
 *
 * @author Threadcount
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Graph {

  static class Node{
      
    public final String name;
    public final HashSet<Edge> inEdges;
    public final HashSet<Edge> outEdges;
    
    public Node(String name) {
      this.name = name;
      inEdges = new HashSet<Edge>();
      outEdges = new HashSet<Edge>();
    }
    public Node addEdge(Node node){
      Edge e = new Edge(this, node);
      outEdges.add(e);
      node.inEdges.add(e);
      return this;
    }
    
    public String toString() {
      return name;
    }
  }

  static class Edge{
      
    public final Node from;
    public final Node to;
    public Edge(Node from, Node to) {
      this.from = from;
      this.to = to;
    }

    public boolean equals(Object obj) {
      Edge e = (Edge)obj;
      return e.from == from && e.to == to;
    }
  }

  public static void main(String[] args) {
    Node P0 = new Node("P0");
    Node P1 = new Node("P1");
    Node P2 = new Node("P2");
    Node P3 = new Node("P3");
    Node R0 = new Node("R0");
    Node R1 = new Node("R1");
    Node R2 = new Node("R2");
    Node R3 = new Node("R3");
    //Requests
    P0.addEdge(R0).addEdge(R1);
    P1.addEdge(R1);
    P2.addEdge(R2).addEdge(R0);
    P3.addEdge(R1).addEdge(R2).addEdge(R3);
    System.out.println(P0.outEdges.toString());
    //Claims
    R0.addEdge(P0).addEdge(P2);

    Node[] allNodes = {P0, P1, P2, P3, R0, R1, R2, R3};
    //L <- Empty list that will contain the sorted elements
    ArrayList<Node> L = new ArrayList<Node>();

    //S <- Set of all nodes with no incoming edges
    HashSet<Node> S = new HashSet<Node>(); 
    for(Node n : allNodes){
      if(n.inEdges.size() == 0){
        S.add(n);
      }
    }

    //while S is non-empty do
    while(!S.isEmpty()){
      //remove a node n from S
      Node n = S.iterator().next();
      S.remove(n);

      //insert n into L
      L.add(n);

      //for each node m with an edge e from n to m do
      for(Iterator<Edge> it = n.outEdges.iterator();it.hasNext();){
        //remove edge e from the graph
        Edge e = it.next();
        Node m = e.to;
        it.remove();//Remove edge from n
        m.inEdges.remove(e);//Remove edge from m

        //if m has no other incoming edges then insert m into S
        if(m.inEdges.isEmpty()){
          S.add(m);
        }
      }
    }
    //Check to see if all edges are removed
    boolean cycle = false;
    for(Node n : allNodes){
      if(!n.inEdges.isEmpty()){
        cycle = true;
        break;
      }
    }
    if(cycle){
      System.out.println("Cycle present, topological sort not possible");
    }else{
      System.out.println("Topological Sort: "+Arrays.toString(L.toArray()));
    }
  }
}
