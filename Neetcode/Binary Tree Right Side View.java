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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        q.add(root);

        while (!q.isEmpty()){

            int size = q.size();

            while(size>0){
                TreeNode node = q.remove();
                if(size == 1) ans.add(node.val);
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                size--;

            }
        }

        return ans;
        
    }
}
