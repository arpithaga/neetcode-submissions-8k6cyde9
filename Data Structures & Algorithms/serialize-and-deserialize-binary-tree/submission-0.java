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

public class Codec {

    // Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		dfsSerialize(root, sb);
		return sb.toString();
	}

	private void dfsSerialize(TreeNode root, StringBuilder sb) {

		if (root == null) {
			sb.append("N").append(",");
			return;
		}

		sb.append(root.val).append(",");
		dfsSerialize(root.left, sb);
		dfsSerialize(root.right, sb);

	}

	// Decodes your encoded data to tree.
	int i = 0;

	public TreeNode deserialize(String data) {
		i = 0;
		String[] commaSep=data.split(",");
		TreeNode root = dfsDerialize(commaSep);
		return root;

	}

	private TreeNode dfsDerialize(String[] commaSep) {

		if (commaSep[i].equals("N")) {
			i++;
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(commaSep[i++]));
		root.left = dfsDerialize(commaSep);
		root.right = dfsDerialize(commaSep);

		return root;

	}
}
