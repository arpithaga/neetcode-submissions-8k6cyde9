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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return goodNodes(root,root.val);
    }

    public int goodNodes(TreeNode root,int val){
        if(root==null) return 0;
        int count=0;
        if(root.val>=val){
            count=1;
        } 

        int newVal=Math.max(val,root.val);
        count+=goodNodes(root.left,newVal);
        count+=goodNodes(root.right,newVal);
        return count;
    }
}
