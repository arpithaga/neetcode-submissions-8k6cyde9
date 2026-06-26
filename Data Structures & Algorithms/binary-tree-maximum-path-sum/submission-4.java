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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        dfsPathSumMax(root);
        return max;
    }

	private int dfsPathSumMax(TreeNode root) {
		
		if(root==null) return 0;	
		int left=Math.max(dfsPathSumMax(root.left),0);
		int right=Math.max(dfsPathSumMax(root.right),0);
		
		max = Math.max(max, right+root.val+left);
		
		return root.val+Math.max(left,right);
		
	}
}
