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

    int ans = Integer.MIN_VALUE;

    public int solve(TreeNode root){

        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        ans = Math.max(ans, left+right);

        return 1+Math.max(left, right);


    }

    public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            solve(root);
            return ans;
        


    }
}
