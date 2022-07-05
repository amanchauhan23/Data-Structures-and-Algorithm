import java.util.PriorityQueue;

public class primsAlgo {
    static final int V = 4;

    public static int primMST(int graph[][]) { // O(V2 logV) | use adj. List to get T.C. O(Elog(V))
        PriorityQueue<int[]> minEdge = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [edge weight, node which it leads
                                                                                   // to];
        int mstSet[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (graph[0][i] != 0)
                minEdge.add(new int[] { graph[0][i], i });
        }
        mstSet[0] = 1;
        int res = 0;
        while (!minEdge.isEmpty()) {
            int[] poll = minEdge.poll();
            int node = poll[1];
            int min = poll[0];
            if (mstSet[node] == 1)
                continue;
            res += min;
            mstSet[node] = 1;
            for (int j = 0; j < V; j++) {
                if (graph[node][j] != 0 && mstSet[j] != 1)
                    minEdge.add(new int[] { graph[node][j], j });
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 8, 0 },
                { 4, 0, 10, 15 },
                { 8, 10, 0, 20 },
                { 0, 15, 20, 0 }, };
        System.out.print(primMST(graph));
    }
}
