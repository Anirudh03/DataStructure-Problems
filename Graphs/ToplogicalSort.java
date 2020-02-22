/*Topological sort is only applicable for DAG's i.e. Directed acyclic graphs.
In DFS, we print a vertex and then recursively call DFS for its adjacent vertices. 
In topological sorting, we need to print a vertex before its adjacent vertices.

Applications:
Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs.
In computer science, applications of this type arise in instruction scheduling, ordering of
formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, 
determining the order of compilation tasks to perform in makefiles, data serialization, 
and resolving symbol dependencies in linkers .

*/

import java.util.*;
public class topologicalsort {
	private int V;
	private LinkedList<Integer> adj[];
	
	public  topologicalsort(int v)
	{
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList();
		}
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	public void topologicalSortUtil(int v,boolean[]visited,Stack stack)
	{
		visited[v]=true;
		Integer i;
		Iterator<Integer> it=adj[v].listIterator();
		while(it.hasNext())
		{
			i=it.next();
			if(!visited[i])
			{
				topologicalSortUtil(i,visited,stack);
			}
		}
		stack.push(new Integer(v));
	}
	public void topologicalSort()
	{
		Stack stack=new Stack();
		boolean []visited=new boolean[V];
		for(int i=0;i<V;i++)
		{
			visited[i]=false;
		}
		for(int i=0;i<V;i++)
		{
			if(visited[i]==false)
			{
				topologicalSortUtil(i,visited,stack);
			}
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
		public static void main(String[]args)
		{
			topologicalsort g=new topologicalsort(6);
			g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	  
	        System.out.println("Following is a Topological " + 
	                           "sort of the given graph"); 
	        g.topologicalSort(); 
			
		}
}
