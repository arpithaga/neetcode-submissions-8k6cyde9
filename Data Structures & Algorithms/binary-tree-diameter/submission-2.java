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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){

        if(root==null) return 0;
        
        int h1=dfs(root.left);
        int h2=dfs(root.right);

        max=Math.max(h1+h2,max);

        return 1+Math.max(h1,h2);
    }
}
