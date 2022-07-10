import java.util.Arrays;
import java.util.LinkedList;

public class ArticulationPoint {
    private int V;

    private LinkedList<Integer> adj[]; // adj list
    static int time = 0;
    static final int NIL = -1;

    ArticulationPoint(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void AP() { // O(V*(V + E)) | O(h)

        for (int index = 0; index < V; index++) {
            int count = -1;
            boolean visited[] = new boolean[V];
            visited[index] = true;
            for (int i = 0; i < adj[index].size(); i++) {
                if (visited[adj[index].get(i)] == false) {
                    count++;
                    // System.out.println("Calling for " + index + " node " + adj[index].get(i));
                    dfs(visited, adj[index].get(i), index);
                    if (count == 1) {
                        System.out.print(index + " ");
                    }
                }
            }
        }
    }

    void dfs(boolean visited[], int node, int parent) {
        if (visited[node] == true)
            return;
        visited[node] = true;
        for (int i = 0; i < adj[node].size(); i++) {
            if (adj[node].get(i) != parent)
                dfs(visited, adj[node].get(i), node);
        }
    }

    public static void main(String args[]) {
        System.out.println("Articulation points in graph ");
        var g = new ArticulationPoint(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.AP();

        // var g2 = new ArticulationPoint(7);
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

        // g2.addEdge(0, 1);
        // g2.addEdge(0, 2);
        // g2.addEdge(2, 1);
        // g2.addEdge(2, 3);
        // g2.addEdge(4, 3);
        // g2.addEdge(2, 4);
        // g2.AP();
    }
}
