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
    public boolean checkValid(TreeNode root, int minVal, int maxVal){
        if(root == null){
            return true;
        }
        if(root.val <= minVal || root.val >= maxVal){
            return false;
        }
        return checkValid(root.left, minVal, root.val) && checkValid(root.right, root.val, maxVal);
    }
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
