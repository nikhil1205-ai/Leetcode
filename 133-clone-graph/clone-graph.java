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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Integer, Node> hs = new HashMap<>();

        Node ans = new Node(node.val);
        hs.put(node.val, ans);

        Queue<Node> que = new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()) {
            Node curr = que.remove();
            Node clone = hs.get(curr.val);

            for(Node v : curr.neighbors) {

                if(!hs.containsKey(v.val)) {
                    Node newNode = new Node(v.val);
                    hs.put(v.val, newNode);
                    que.add(v);
                }

                clone.neighbors.add(hs.get(v.val));
            }
        }

        return ans;
    }
}