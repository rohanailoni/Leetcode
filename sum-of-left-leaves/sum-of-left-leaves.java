class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
		
		// Checking if left Node is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

		// Exploring the tree further.
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}