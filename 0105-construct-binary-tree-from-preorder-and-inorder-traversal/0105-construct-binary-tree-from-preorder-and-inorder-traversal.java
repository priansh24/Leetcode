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
    public TreeNode helper(int[] preorder,HashMap<Integer,Integer> map,int left,int right,int[] index)
    {
        if(left>right)
        {
            return null;
        }
        int current = preorder[index[0]];
        index[0]++;
        TreeNode curr = new TreeNode(current);
        if(left==right)
        {
            return curr;
        }
        int inorderIndex = map.get(current);
        curr.left = helper(preorder,map,left,inorderIndex-1,index);
        curr.right = helper(preorder,map,inorderIndex+1,right,index);
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        int[] index = new int[1];
        index[0] = 0;
        return helper(preorder,map,0,preorder.length-1,index);
    }
}