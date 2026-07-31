class Solution {

    public int findGood(TreeNode node, int maxVal) {

        if (node == null) {
            return 0;
        }

        int count = 0;

        // Check if current node is good
        if (node.val >= maxVal) {
            count = 1;
        }

        // Update maximum value seen so far
        maxVal = Math.max(maxVal, node.val);

        // Traverse left and right
        count += findGood(node.left, maxVal);
        count += findGood(node.right, maxVal);

        return count;
    }

    public int goodNodes(TreeNode root) {

        return findGood(root, root.val);
    }
}