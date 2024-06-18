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
    // List<Integer> list = new ArrayList<>();
    // public void inorder(TreeNode root)
    // {
    //     if(root==null) return;
    //     inorder(root.left);
    //     list.add(root.val);
    //     inorder(root.right);
    // }
    // public int kthSmallest(TreeNode root, int k) {
    //     inorder(root);
    //     return list.get(k-1);
    // }

    int ans=0,k;
    private void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        k--;
        if(k==0)
        {
            ans = root.val;
            return;
        }
        inorder(root.right);
    }
    // Return the Kth smallest element in the given BST
    public int kthSmallest(TreeNode root, int K) {
        // Write your code here
        k=K;
        inorder(root);
        return ans;
    }
}