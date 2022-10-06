/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// #1 BFS
class Solution { 
    public Node cloneGraph(Node node) { // O(V + E) || O(V)

        if(node == null) return null;
        HashMap<Node, Node> hm = new HashMap<>(); // 1 Node -> original graph, 2 Node -> new graph
        Queue<Node> q = new LinkedList<>();

        Node newNode = new Node(node.val);
        hm.put(node, newNode);
        q.offer(node);

        while(!q.isEmpty()){ // bfs
            Node pop = q.poll();
            for(int i = 0; i < pop.neighbors.size(); i++){
                Node popNbr = pop.neighbors.get(i);
                if(!hm.containsKey(popNbr)){
                    hm.put(popNbr, new Node(popNbr.val));
                    q.offer(popNbr);
                }
                hm.get(pop).neighbors.add(hm.get(popNbr)); // adding neighbours to new graph
            }
        }

        return hm.get(node);
    }
}

// #2 DFS
class Solution { 
    HashMap<Node, Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(hm.containsKey(node)) return hm.get(node);

        Node cloneNode = new Node(node.val);
        hm.put(node, cloneNode);

        for(Node n : node.neighbors)
            hm.get(node).neighbors.add(cloneGraph(n));

        return cloneNode;
    }
}
