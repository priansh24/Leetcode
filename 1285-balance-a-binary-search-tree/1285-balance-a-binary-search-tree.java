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
    private void inorder(TreeNode root,List<Integer> list)
    {
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return;
    }
    public TreeNode sortedArraytoBST(List<Integer> nums,int start, int end)
    {
        if(start>end) return null;
        
        int mid = start+(end-start)/2;
        TreeNode head = new TreeNode(nums.get(mid));
        head.left = sortedArraytoBST(nums,start,mid-1);
        head.right = sortedArraytoBST(nums,mid+1,end);
        return head;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return root;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int n = list.size();
        return sortedArraytoBST(list,0,n-1);
    }
}