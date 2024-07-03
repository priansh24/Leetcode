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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        helper(root,map,res);
        return res;
    }
    private String helper(TreeNode root, HashMap<String,Integer> map, List<TreeNode> res)
    {
        if(root==null) return "";
        String left = helper(root.left, map,res);
        String right = helper(root.right,map,res);
        String currentVal = root.val+","+left+","+right;
        if(map.containsKey(currentVal))
        {
            if(map.get(currentVal)==1) res.add(root);
        }
        map.put(currentVal,map.getOrDefault(currentVal,0)+1);
        return currentVal;
    }
}