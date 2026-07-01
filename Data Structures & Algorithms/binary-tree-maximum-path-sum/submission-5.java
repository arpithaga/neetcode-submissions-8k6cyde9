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
        dfs(root,0);
		return max;
    }

	private int dfs(TreeNode root, int currentSum){
		if(root==null) return 0;

		int left= Math.max(dfs(root.left,currentSum),0);
		int right= Math.max(dfs(root.right,currentSum),0);

		int current=root.val+left+right;
		max=Math.max(max,current);

		return root.val+Math.max(left,right);

	}
}
