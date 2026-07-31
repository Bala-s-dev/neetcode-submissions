public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                s.append("$ ");
                continue;
            }
            q.offer(node.left);
            q.offer(node.right);
            s.append(node.val + " ");
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] val = data.split(" ");
        int n = Integer.parseInt(val[0]);
        TreeNode root = new TreeNode(n);
        q.offer(root);

        for(int i = 1; i < val.length; i++){
            TreeNode node = q.poll();
            if(!(val[i].equals("$"))){
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                node.left = left;
                q.offer(left);
            }
            i++;
            if(!(val[i].equals("$"))){
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
