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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder,int start,int end)
    {
        // if(start>=preorder.length) return root; 
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[start++]);
        int i;
        for(i=start;i<preorder.length;i++)
        {
            if(preorder[i]>root.val)
            {
                break;
            }
        }
        TreeNode left = helper(preorder,start,i-1);
        TreeNode right = helper(preorder,i,end);
        if(left!=null) root.left = left;
        if(right!=null) root.right = right;
        return root;
    }
}