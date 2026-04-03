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
  
  int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        dfsPathSum(root);
        return maxSum;
    }

	private int dfsPathSum(TreeNode root) {
		
		if(root==null) return 0;
		
		
		
		int l=Math.max(0, dfsPathSum(root.left));
		
		int r=Math.max(0, dfsPathSum(root.right));
		
		int currSum=root.val+l+r;
		
		maxSum=Math.max(maxSum, currSum);
		return root.val+Math.max(l, r);
		
	}

}
