import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {

        List<List<Integer>> adj;
        int dist[];

        public Graph(int size) {
            adj = new ArrayList<>();
            dist = new int[size];
            Arrays.fill(dist, -1); // initializing all distance to -1
            while (size-- > 0) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            adj.get(first).add(second);
            adj.get(second).add(first); // for undirected graph
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Queue<Integer> q = new LinkedList<>();
            q.offer(startId);
            dist[startId] = 0;

            while (!q.isEmpty()) {
                int index = q.poll();
                for (int i = 0; i < adj.get(index).size(); i++) {
                    if (dist[adj.get(index).get(i)] == -1) {
                        dist[adj.get(index).get(i)] = dist[index] + 6;
                        q.offer(adj.get(index).get(i));
                    }
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
