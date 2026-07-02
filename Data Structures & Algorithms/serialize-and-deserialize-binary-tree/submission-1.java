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
	StringBuilder sb = new StringBuilder();

	public String serialize(TreeNode root) {
		dfsSerializer(root);
		return sb.toString();
	}

	public void dfsSerializer(TreeNode root) {
		if (root == null) {
			sb.append("N,");
			return;
		}
		sb.append(root.val).append(",");
		dfsSerializer(root.left);
		dfsSerializer(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		
		String[] d =data.split(",");
		int[] index=new int[1];
		
		return dfsDeserializer(d, index);

	}

	private TreeNode dfsDeserializer(String[] s, int[] index) {
		
			if(index[0]>s.length) {
				return null;
			}
		
			if(s[index[0]].equals("N")){
				index[0]++;
				return null;
			}
			
			TreeNode curr = new TreeNode(Integer.parseInt(s[index[0]]));
			index[0]++;
			curr.left= dfsDeserializer(s,index);
			curr.right= dfsDeserializer(s,index);
			
			return curr;
		}
}
