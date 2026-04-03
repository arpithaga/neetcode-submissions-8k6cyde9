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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty())
		{
			int count = q.size();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				TreeNode p = q.pop();
				l.add(p.val);
				if (p.left != null)
					q.add(p.left);
				if (p.right != null)
					q.add(p.right);
			}

			res.add(l);

		}

		return res;
    }
}
