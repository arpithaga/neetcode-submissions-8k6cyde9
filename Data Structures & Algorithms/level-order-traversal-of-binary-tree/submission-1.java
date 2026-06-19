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

		List<List<Integer>> result = new ArrayList<>();
		if(root==null) return result;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while(!queue.isEmpty()){
			List<Integer> level = new ArrayList<>();
			int n = queue.size();

			while(n>0){
				TreeNode t = queue.poll();
				
				level.add(t.val);

				if(t.left != null)
					queue.add(t.left);
				if(t.right != null)
					queue.add(t.right);
				n--;
			}

			result.add(level);

		}

		return result;
        
    }
}
