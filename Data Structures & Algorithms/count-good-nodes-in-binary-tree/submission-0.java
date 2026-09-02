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
    int count = 0;
    public void inorder(TreeNode root, int maxVal){
        if(root==null) return;
        maxVal = Math.max(maxVal, root.val);

        inorder(root.left, maxVal);
        if(maxVal <= root.val) count++;
        inorder(root.right, maxVal);
    }

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;

        inorder(root, root.val);

        return count;
    }
}
