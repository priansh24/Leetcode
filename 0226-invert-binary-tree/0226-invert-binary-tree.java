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
    public TreeNode invertTree(TreeNode root) {

        // RECURSION APPROACH

        /*
        if(root==null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
        */

        //ITERATIVE APPROACH

        if(root==null) return null;

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);

        while(list.isEmpty()==false)
        {
            TreeNode newNode = list.poll();  //removing element from queue

            TreeNode temp = newNode.left;
            newNode.left = newNode.right;
            newNode.right = temp;

            if(newNode.left!=null) list.add(newNode.left);
            if(newNode.right!=null) list.add(newNode.right);
        }
            return root; 
    }
}