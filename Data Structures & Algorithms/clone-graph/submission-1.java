/*
Definition for a Node.
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

        if(node==null) return null;

		Map<Node, Node> copyNodes = new HashMap<>();

		Queue<Node> q = new ArrayDeque<>();
        copyNodes.put(node,new Node(node.val));
		q.add(node);

		while (!q.isEmpty()) {

			Node p = q.poll();

			for (Node c : p.neighbors) {

				if (!copyNodes.containsKey(c)) {
					copyNodes.put(c, new Node(c.val));
					q.add(c);
				}
				copyNodes.get(p).neighbors.add(copyNodes.get(c));
			}
		}

		return copyNodes.get(node);
	}
}