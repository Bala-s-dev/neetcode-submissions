class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }        
        TreeNode root = treeBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode treeBuild(int[] preorder, int prestart, int preend,int[] inorder, int instart, int inend, HashMap<Integer, Integer> map){
        if(prestart > preend || instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - instart;
        root.left = treeBuild(preorder, prestart + 1, prestart + numsLeft,inorder, instart, inRoot - 1, map);
        root.right = treeBuild(preorder, prestart + numsLeft + 1, preend,inorder, inRoot + 1, inend, map);
        return root;
    }
}
