/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode temp = head;
        ListNode prev = root;
        while(temp!=null)
        {
            if(temp.next!=null && temp.next.val==temp.val)
            {
                while(temp.next!=null && temp.next.val==temp.val)
                {
                    temp = temp.next;
                }
                prev.next = temp;
            }
            temp = temp.next;
            prev = prev.next;
        }
        return root.next;
    }
}