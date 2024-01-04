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

    void solve(TreeNode root, int max){

        if(root == null) return;

        if(root.val >= max) {
            ans++;
            max = root.val;
        }

        solve(root.left, max);
        solve(root.right, max);

    }

    public int goodNodes(TreeNode root) {

        if(root == null) return 0;

        ans = 0;

        solve(root, root.val);

        return ans;
        
    }
}
