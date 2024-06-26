/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
public Node connect(Node root) {
    if (root == null){
      return null;
    }

    // Node leftMost = root;

    // while (leftMost.left != null) {
    //   Node current = leftMost;
    //   while(current != null) {
    //     if(current.left!=null && current.right!=null)
    //         current.left.next = current.right;
    //     if(current.next != null)
    //     {
    //         if(current.right!=null)
    //         {
    //             if(current.next.left!=null)
    //                 current.right.next = current.next.left;
    //             else 
    //                 current.right.next = current.next.right;
    //         }
    //         else
    //         {
    //             if(current.next.left!=null)
    //                 current.left.next = current.next.left;
    //             else 
    //                 current.left.next = current.next.right;
    //         }

    //         if(current.left==null)
    //         {
    //             if(current.next.left!=null)
    //                 current.right.next = current.next.left;
    //             else 
    //                 current.right.next = current.next.right;
    //         }
    //         // else
    //         // {
    //         //     if(current.next.left!=null)
    //         //         current.left.next = current.next.left;
    //         //     else 
    //         //         current.left.next = current.next.right;
    //         // }
            
    //     }
    //     current = current.next;
    //   }
    //   leftMost = leftMost.left;
    // }

    Node temp = root;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty())
    {
        Node prev = null;
        int levelSize = q.size();
        for(int i = 0;i<levelSize;i++)
        {
            Node newNode = q.poll();
            newNode.next = prev;
            prev = newNode;
            if(newNode.right!=null) q.add(newNode.right);
            if(newNode.left!=null) q.add(newNode.left);
        }
        
    }
    return root;
  }
}