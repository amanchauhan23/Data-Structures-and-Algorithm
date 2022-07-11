import java.util.LinkedList;

public class ArticulationPointEfficient {
    private int V;

    private LinkedList<Integer> adj[]; // adj list
    static int time = 0;

    ArticulationPointEfficient(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void AP() { // O(V + E) | O(V)

        int visited[] = new int[V];
        int low[] = new int[V];
        int disc[] = new int[V];
        int articulations[] = new int[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(visited, low, disc, articulations, time, i, -1);
            }
        }

        for (int i = 0; i < articulations.length; i++) {
            if (articulations[i] == 1)
                System.out.print(i + " ");
        }
    }

    void dfs(int visited[], int low[], int disc[], int articulations[], int time, int node, int parent) {
        visited[node] = 1;
        disc[node] = low[node] = ++time;
        int child = 0;

        for (int i = 0; i < adj[node].size(); i++) {
            int u = adj[node].get(i);
            if (u == parent)
                continue;

            if (visited[u] == 0) {
                child++;
                dfs(visited, low, disc, articulations, time, u, node);
                low[node] = Math.min(low[node], low[u]); 

                if (low[u] >= disc[node] && parent != -1)
                    articulations[node] = 1;
            } else {
                low[node] = Math.min(low[node], disc[u]); // we need to go to, lowest possible node, only using one back-edge, that is why we consider disc[u], rather than low[u]
            }
        }
        if (parent == -1 && child > 1) { // for root
            articulations[node] = 1;
        }
    }

    public static void main(String args[]) {
        System.out.println("Articulation points in graph ");
        // var g = new ArticulationPointEfficient(5);
        // g.addEdge(1, 0);
        // g.addEdge(0, 2);
        // g.addEdge(2, 1);
        // g.addEdge(0, 3);
        // g.addEdge(3, 4);
        // g.AP();

        var g2 = new ArticulationPointEfficient(7);
        // g2.addEdge(0, 1);
        // g2.addEdge(0, 3);
        // g2.addEdge(1, 2);
        // g2.addEdge(1, 4);
        // g2.addEdge(2, 3);
        // g2.addEdge(4, 5);
        // g2.addEdge(6, 5);
        // g2.addEdge(6, 4);
        // g2.AP();

        // g2.addEdge(0, 1);
        // g2.addEdge(0, 2);
        // g2.addEdge(1, 2);
        // g2.addEdge(2, 3);
        // g2.AP();

        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(2, 3);
        g2.addEdge(4, 3);
        g2.addEdge(2, 4);
        g2.AP();
    }
}
