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

    public TreeNode solve(Map<Integer, Integer> map, int[] pre, int[] in, int preIndex, int inStart, int inEnd){

        if(preIndex >= pre.length || inStart > inEnd) return null;

        TreeNode node = new TreeNode(pre[preIndex]);

        int mid = map.get(pre[preIndex]);
        int len = mid - inStart;

        node.left = solve(map, pre, in, preIndex+1, inStart, mid-1);
        node.right = solve(map, pre, in, preIndex+len+1, mid+1, inEnd);

        return node;



    }

    public TreeNode buildTree(int[] pre, int[] in) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<in.length;i++) map.put(in[i], i);

        TreeNode root = solve(map, pre, in, 0, 0, in.length-1);

        return root;
        
    }
}
