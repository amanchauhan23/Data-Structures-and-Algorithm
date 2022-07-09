import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Gfg { 
	
    static final int V=4;
	public static int[] djikstra(int graph[][], int src) // use adj List to get, O((V + E)logE) ~ O(ElogE)
    { 
    
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // int[weight, node]
    	int[] dist=new int[V];
    	Arrays.fill(dist,Integer.MAX_VALUE);
    	dist[src]=0;
    	pq.add(new int[]{0, src});
    	boolean[] fin=new boolean[V]; 
    
        while(!pq.isEmpty()){
            int[] pop = pq.poll();
            int node = pop[1];
            int weight = pop[0];
            if(fin[node] == true)
                continue;
            fin[node] = true;
            for(int i = 0; i < V; i++){  // Relaxing nodes
                if(graph[node][i] != 0 && fin[i] == false){
                    dist[i] = Math.min(dist[i], graph[node][i] + weight); // finding optimal min dist
                    pq.add(new int[]{graph[node][i] + weight, i}); 
                }
            }
        }
        return dist;
    } 

	public static void main(String[] args) 
	{  
		int graph[][] = new int[][] { { 0, 50, 100, 0}, 
            						{ 50, 0, 30, 200 }, 
            						{ 100, 30, 0, 20 }, 
            						{ 0, 200, 20, 0 },};  

        for(int x: djikstra(graph,0)){
    	    System.out.print(x+" ");
    	}     
		
	} 
} 
