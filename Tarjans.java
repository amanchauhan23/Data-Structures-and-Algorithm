import java.util.ArrayList;
import java.util.Stack;

public class Tarjans {

    ArrayList<ArrayList<Integer>> adj;
    int V;

    Tarjans(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void getSCC() { // O(V + E) | O(V)
        boolean visited[] = new boolean[V];
        int low[] = new int[V];
        int disc[] = new int[V];
        boolean inStack[] = new boolean[V]; // used in checking cross-edge
        Stack<Integer> st = new Stack<>();
        int time = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfsTarjans(i, time, visited, low, disc, inStack, st);
            }
        }
    }

    void dfsTarjans(int node, int time, boolean visited[], int low[], int disc[], boolean inStack[],
            Stack<Integer> st) {

        visited[node] = true;
        low[node] = disc[node] = time++;
        inStack[node] = true;
        st.push(node);

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i);

            if (visited[v] == false) {

                dfsTarjans(v, time, visited, low, disc, inStack, st);
                low[node] = Math.min(low[node], low[v]);

            } // Diffrentiate b/w cross-edge and back-edge
            else if (inStack[v] == true) { // for only considering back edges, as only back edges will be present in
                                           // the inStack, not cross-edges.

                low[node] = Math.min(low[node], disc[v]);

            }
        }

        if (low[node] == disc[node]) { //  condition for encountering head of SCC
            while (st.peek() != node) { // popping until node is encountered in stack
                int pop = st.pop();
                System.out.print(pop + " ");
                inStack[pop] = false;
            }
            inStack[st.peek()] = false; 
            System.out.print(st.pop() + "\n");
        }
    }

    public static void main(String[] args) {

        System.out.println("SCC are: ");

        // var graph = new Tarjans(6);
        // graph.addEdge(0, 1);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 1);
        // graph.addEdge(0, 4);
        // graph.addEdge(4, 5);
        // graph.addEdge(5, 4);
        // graph.getSCC();

        var g = new Tarjans(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.getSCC();

    }
}
