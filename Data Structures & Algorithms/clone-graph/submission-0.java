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
		Map<Node, Node> copyNodes = new HashMap<>();
		return createCopy(node, copyNodes);
	}

	public Node createCopy(Node node, Map<Node, Node> copyNodes) {

		if (node == null) {
			return null;
		}
		
		if(copyNodes.containsKey(node)) {
			return copyNodes.get(node);
		}

		Node copy = new Node(node.val);
		copyNodes.put(node, copy);
		for(Node n:node.neighbors) {
			Node cp=createCopy(n,copyNodes);
			copy.neighbors.add(cp);
		}

		return copy;
	}
}