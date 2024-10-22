//A Java program for Dijkstra's single source shortest path algorithm.
import java.util.*;
import java.lang.*;
import java.io.*;
class ShortestPath {
	static final int V=9;
	int minDistance(int dist[],Boolean sptSet[]){
		int min=Integer.MAX_VALUE,min_index=-1;
		for(int v=0; v<V; v++)
			if(sptSet[v] == false && dist[v] <= min){
				min=dist[v];
				min_index=v;
      }
		return min_index;
	}
	void printSolution(int dist[], int n){
		System.out.println("Vertex Distance from Source");
		for(int i=0; i<V; i++)
			System.out.println(i+"tt"+dist[i]);
  }
	void dijkstra(int graph[][], int src)
	{
		int dist[]=new int[V];
		Boolean sptSet[]=new Boolean[V];
		for(int i=0; i<V; i++) {
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		dist[src] = 0;
		for (int count=0; count<V-1; count++) {
			int u=minDistance(dist, sptSet);
			sptSet[u]=true;
			for(int v=0; v<V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && 
				dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printSolution(dist, V);
	}
	public static void main(String[] args){
		int graph[][] = new int[][] { { -1, 3, -1, -1, -1, -1, -1, 7, -1 },  
    { 3, -1, 7, -1, -1, -1, -1, 10, 4 },  
    { -1, 7, -1, 6, -1, 2, -1, -1, 1 },  
    { -1, -1, 6, -1, 8, 13, -1, -1, 3 },  
    { -1, -1, -1, 8, -1, 9, -1, -1, -1 },  
    { -1, -1, 2, 13, 9, -1, 4, -1, 5 },  
    { -1, -1, -1, -1, -1, 4, -1, 2, 5 },  
    { 7, 10, -1, -1, -1, -1, 2, -1, 6 },  
    { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };  
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, 0);
	}
}
