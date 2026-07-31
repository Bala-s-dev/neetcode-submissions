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
    // int level = 0;
    public void findView(TreeNode root, List<Integer> ans, int level){
        if(root == null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.val);
        }
        findView(root.right, ans, level + 1);
        findView(root.left, ans, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        findView(root, ans, level);
        return ans;
    }
}
