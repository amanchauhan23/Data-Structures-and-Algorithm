import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
    int V;
    LinkedList<Integer> adj[];
    boolean visited[];
    boolean[] visitedDFS;

    Graph(int v) {
        this.V = v;
        visited = new boolean[V];
        visitedDFS = new boolean[V];
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    ArrayList<Integer> stepOne(Graph g) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++)
            dfs(st, i);
        ArrayList<Integer> ls = new ArrayList<>();
        while (st.empty() == false)
            ls.add(st.pop());
        return ls;
    }

    void dfs(Stack<Integer> st, int u) {
        if (visited[u] == true)
            return;
        visited[u] = true;
        for (int i = 0; i < adj[u].size(); i++)
            dfs(st, adj[u].get(i));
        st.push(u);
    }

    void StrongConnectedComponent(Graph g) {
        ArrayList<Integer> ls = stepOne(g);
        transPose(g);
        for (int i : ls) {
            if (visitedDFS[i] == false) {
                stepThree(i);
                System.out.println();
            }
        }
    }

    void stepThree(int node) {
        if (visitedDFS[node] == true)
            return;
        visitedDFS[node] = true;
        System.out.print(" " + node);
        for (int i = 0; i < adjTranspose[node].size(); i++)
            stepThree(adjTranspose[node].get(i));
    }

    LinkedList<Integer> adjTranspose[];

    void transPose(Graph g) {
        adjTranspose = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adjTranspose[i] = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                adjTranspose[adj[i].get(j)].add(i);
            }
        }
    }

}

public class Kosaraju { // O(V + E) | O(V + E)
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("Strong Connected Components are: ");
        g.StrongConnectedComponent(g);
    }
}
