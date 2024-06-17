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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.isEmpty()==false)
        {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<levelSize;i++)
            {
                TreeNode current = q.poll();
                list.add(current.val);
                if(current.left!=null) q.add(current.left);
                if(current.right!=null) q.add(current.right);
            }
            res.add(0,list);
        }
        return res;
    }
}