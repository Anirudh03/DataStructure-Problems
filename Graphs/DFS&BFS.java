/* DFS Graph:DFS uses recursion 
Basic Back ground:
1) we use adjancecy list here.we will be having a private variable V which will be equal to total number of vertices in 
the graph.we will have a array of linkedlist.
2) we will be assigning intializing the array of linkedlist and the variable v in the constructor.
3) we will be adding the edges adj[v].add(w);

DFS function prototype: DFS(int vertice)
1)In this function we define the boolean array visited to mark the vertices which are visited.
2) we will pass this vertice and visited boolean array to the DFSUtil(boolean []visited,int vertice).
*/
/*
BFS:the function prototype bfs(int vertice)
1) we will be using a linkedlist like a queue and a boolean array called visited to mark the vertices which
  we visited during the BFS.This technique is used to avoid cycles in the graph.
2)  we will add the vertice into the queue and mark it as visitied.
3) we will loop through the queue until its size is empty.Inside the loop we will poll() the queue and assign it to m.Then we will
iterate through m 
*/

import java.util.*;
public class dfs {

	private int V;
	private LinkedList<Integer> adj[];
	public dfs(int v)
	{
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList();
	}
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	public void DFS()
	{
		boolean []visited=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(visited[i]!=true)
			DFSUtil(i,visited);	
		}
		
		
	}
	public void DFSUtil(int v,boolean []visited)
	{
		visited[v]=true;
		System.out.print(v+" ");
		Iterator<Integer> iterator=adj[v].listIterator();
		while(iterator.hasNext())
		{
			int n=iterator.next();
			if(visited[n]==false)
			{
				//visited[n]=true;
				DFSUtil(n,visited);
			}
		}
		
		
		
	}
	public void BFS(int v)
	{
		boolean []visited=new boolean[V];
		visited[v]=true;
		LinkedList<Integer> queue=new LinkedList();
		queue.add(v);
		while(!queue.isEmpty())
		{
			int k=queue.poll();
			Iterator<Integer> iterator=adj[k].listIterator();
			System.out.print(k+" ");
			while(iterator.hasNext())
			{
				int n=iterator.next();
				if(visited[n]!=true)
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String []args)
	{
		dfs g = new dfs(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal"); 
  
        g.DFS(); 
        System.out.println("Following is Breadth First Traversal"); 

        g.BFS(0);
	}
}
