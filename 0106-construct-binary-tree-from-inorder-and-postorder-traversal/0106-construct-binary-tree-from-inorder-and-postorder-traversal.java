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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length!=inorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        int[] index = {n-1};
        return helper(postorder,map,0,n-1,index);
    }
    public TreeNode helper(int[] postorder, HashMap<Integer,Integer> map, int left,int right,int[] index)
    {
        if(left>right) return null;

        int curr = postorder[index[0]];
        TreeNode current = new TreeNode(curr);
        if(index[0]>0) index[0]--;
        if(left==right) return current;

        int inorderIndex = map.get(curr);
        // current.right = helper(postorder,map,left,inorderIndex-1,index);
        // current.left = helper(postorder,map,inorderIndex+1,right,index);
        current.right = helper(postorder,map,inorderIndex+1,right,index);
        current.left = helper(postorder,map,left,inorderIndex-1,index);
        return current;
    }

}