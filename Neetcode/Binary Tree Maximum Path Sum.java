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

    int ans;

    public int solve(TreeNode root){

        if(root == null) return 0;

        int a = solve(root.left), b = solve(root.right);

        if(a<0 && b<0) {
            ans = Math.max(ans, root.val);
            return root.val;
            }

        if(a<0) {
            ans = Math.max(ans, root.val+b);
            return root.val + b;
            }

        if(b<0) {
            ans = Math.max(ans, root.val+a);
            return root.val + a;
            }
        
        ans = Math.max(ans, root.val+a+b);
        return Math.max(b+root.val, a+root.val);
    }

    public int maxPathSum(TreeNode root) {
        
        ans = root == null ? 0 : root.val;
        solve(root);
        return ans;

    }
}
