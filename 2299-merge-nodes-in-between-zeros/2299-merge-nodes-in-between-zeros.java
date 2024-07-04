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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        int sum = 0;
        head = head.next;
        while(head!=null)
        {
            if(head.val==0)
            {
                ListNode node = new ListNode(sum);
                temp.next = node;
                temp = temp.next;
                sum = 0;
            }
            else sum += head.val;
            head= head.next;
        }
        return ans.next;
    }
}