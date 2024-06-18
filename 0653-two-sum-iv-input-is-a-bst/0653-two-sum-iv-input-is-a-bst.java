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
    int count = 2;
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        HashMap<Integer,Boolean> map = new HashMap<>();
        return helper(root,k,map);
    }

    private boolean helper(TreeNode root, int sum,HashMap<Integer,Boolean> map)
    {
        if(root==null) return false;

        if(map.containsKey(sum-root.val)) return true;
        map.put(root.val,true);
        return helper(root.left,sum,map) || helper(root.right,sum,map);
    }
}