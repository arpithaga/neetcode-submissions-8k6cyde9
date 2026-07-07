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
        Map<Node,Node> map=new HashMap<>();
    dfs(node,map);
    return map.get(node);
}
private void dfs(Node node, Map<Node,Node> map) {
	
	if(node==null) return;
	
	
	if(map.containsKey(node)) return;
	
	Node copy = new Node(node.val);
    map.put(node,copy);
	for(Node c: node.neighbors) {
		
			dfs(c,map);
            copy.neighbors.add(map.get(c));
		
	}
	
}
}