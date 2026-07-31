
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode val = q.peek();
                q.poll();
                if(val.left != null){
                    q.offer(val.left);
                }
                if(val.right != null){
                    q.offer(val.right);
                }
                temp.add(val.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}
