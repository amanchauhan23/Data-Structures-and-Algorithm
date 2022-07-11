import java.util.*;

public class BridgesInGraph {
    private int V;

    private LinkedList<Integer> adj[];
    int time = 0;

    BridgesInGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridge() { // O(V + E) | O(V)
        int time = 0;
        int disc[] = new int[V];
        int low[] = new int[V];
        int visited[] = new int[V];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0)
                dfs(i, -1, time, visited, low, disc, hm);
        }

        for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
            System.out.println(h.getKey() + " -- " + h.getValue());
        }

    }

    void dfs(int node, int parent, int time, int visited[], int low[], int disc[], HashMap<Integer, Integer> hm) {
        visited[node] = 1;
        disc[node] = low[node] = ++time;

        for (int v : adj[node]) {
            if (parent == v)
                continue;
            if (visited[v] == 0) {
                dfs(v, node, time, visited, low, disc, hm);
                low[node] = Math.min(low[node], low[v]);

                if (low[v] > disc[node]) {
                    int min = Math.min(v, node);
                    int max = Math.max(v, node);
                    if (!hm.containsKey(min) || (hm.containsKey(min) && hm.get(min) != max)) {
                        hm.put(min, max);
                    }
                }
            }
            low[node] = Math.min(low[node], disc[v]); // we need to go to, lowest possible node, only using one back-edge, that is why we consider disc[v], rather than low[v]
        }
    }

    public static void main(String args[]) {
        System.out.println("Bridges in first graph ");
        // var g = new BridgesInGraph(5);
        // g.addEdge(1, 0);
        // g.addEdge(0, 2);
        // g.addEdge(2, 1);
        // g.addEdge(0, 3);
        // g.addEdge(3, 4);
        // g.bridge();

        // var g2 = new BridgesInGraph(7);
        // g2.addEdge(0, 1);
        // g2.addEdge(0, 3);
        // g2.addEdge(1, 2);
        // g2.addEdge(1, 4);
        // g2.addEdge(2, 3);
        // g2.addEdge(4, 5);
        // g2.addEdge(6, 5);
        // g2.addEdge(6, 4);
        // g2.bridge();

        var g3 = new BridgesInGraph(8);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 3);
        g3.addEdge(4, 5);
        g3.addEdge(5, 6);
        g3.addEdge(4, 6);
        g3.addEdge(6, 7);
        g3.bridge();
    }

}
