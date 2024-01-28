class Solution {
    public int countPaths(int n, int[][] roads) {
        // Creating Adj List
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList();
        for(int i = 0; i < n; i++) adj.add(new ArrayList());
        for(int[] arr:roads){
            adj.get(arr[0]).add(new Integer[]{arr[1], arr[2]});
            adj.get(arr[1]).add(new Integer[]{arr[0], arr[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //int [W, V]
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean fin[] = new boolean[n];
        int ways[] = new int[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int []Node = pq.poll();
            int W = Node[0];
            int V = Node[1];

            if(fin[V]) continue;
            fin[V] = true;

            for(Integer[] pair:adj.get(V)){
                int adjV = pair[0];
                int adjW = pair[1];
                if(!fin[adjV]){
                    if(W + adjW < dist[adjV]){
                        dist[adjV] = W + adjW;
                        ways[adjV] = ways[V];
                        pq.add(new int[]{dist[adjV], adjV});
                    }else if(W + adjW == dist[adjV]){
                        ways[adjV] = (ways[V]+ways[adjV])%(int)(1e9+7);
                    }
                }
            }
        }

        return ways[n-1];
        
    }
}
