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
    public int countNodes(TreeNode root) {
        int[] count = new int[1];
        count[0] = 0;
        countNodes(root,count);
        return count[0];
    }

    private void countNodes(TreeNode root,int[] count)
    {
        if(root==null) return;
        count[0]++;
        countNodes(root.left,count);
        countNodes(root.right,count);
    }

}