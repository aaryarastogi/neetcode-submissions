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
    public boolean isSameTree(TreeNode root, TreeNode subroot){
        if(root==null && subroot==null) return true;
        if((root==null && subroot != null) || (root!=null && subroot==null)) return false;

        return (root.val == subroot.val) && isSameTree(root.left, subroot.left) && isSameTree(root.right, subroot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==subRoot) return true;
        if((root==null && subRoot != null) || (root!=null && subRoot==null)) return false;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
