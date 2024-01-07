/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder ans = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return ans.toString();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            while(size>0){

                TreeNode node = q.remove();
                if(node != null){
                    q.add(node.left);
                    q.add(node.right);
                }

                if(node != null) ans.append(String.valueOf(node.val)).append(',');
                else ans.append("@,");
                size--;
            }
        }

        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        TreeNode root = null;

        if(data.length() == 0) return root;

        String[] arr = data.split(",",-1);

        root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int c = 1;

        while(!q.isEmpty()){
                

                TreeNode node = q.remove();

                if(arr[c].equals("@")){
                    node.left = null;
                    c++;

                }
                else{

                    node.left = new TreeNode(Integer.parseInt(arr[c]));
                    q.add(node.left);
                    c++;

                }

                if(arr[c].equals("@")){
                    node.right = null;
                    c++;

                }
                else{

                    node.right = new TreeNode(Integer.parseInt(arr[c]));
                    q.add(node.right);
                    c++;

                }
            }
            return root;
        }

        
        
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
