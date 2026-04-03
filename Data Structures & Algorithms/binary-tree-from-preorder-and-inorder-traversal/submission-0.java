/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		p=0;
        Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<inorder.length;i++) {
			map.put(inorder[i], i);
		}

		return dfsConstruct(preorder,map,0,inorder.length-1);

	}
	int p=0;
	private TreeNode dfsConstruct(int[] preorder, Map<Integer, Integer> map, int i,
			int j) {
		
		if (i > j) return null;

    // Use the current value from preorder to create the root
    TreeNode r = new TreeNode(preorder[p++]);
    
    // Find where this root sits in the inorder array
    int rootIndex = map.get(r.val);
    
    // Left subtree: everything from current 'i' up to rootIndex - 1
    r.left = dfsConstruct(preorder, map, i, rootIndex - 1);
    
    // Right subtree: everything from rootIndex + 1 up to current 'j'
    r.right = dfsConstruct(preorder, map, rootIndex + 1, j);
    
    return r;
	}
}
