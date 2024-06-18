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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root==null) return ans;
        StringBuilder sb = new StringBuilder();
        helper(root,ans,sb);
        return ans;
    }
    private void helper(TreeNode root,List<String> ans,StringBuilder sb)
    {
        // if(root.left==null && root.right==null) ans.add(path+root.val);
        // if(root.left!=null) helper(root.left,path+root.val+"->",ans);
        // if(root.right!=null) helper(root.right,path+root.val+"->",ans);
        if(root==null) return;

        int len = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right==null)
        {
            ans.add(sb.toString());
        }
        else
        {
            sb.append("->");
            helper(root.left,ans,new StringBuilder(sb));
            helper(root.right,ans,new StringBuilder(sb));
        }
        // sb.setLength(len);
    }
}