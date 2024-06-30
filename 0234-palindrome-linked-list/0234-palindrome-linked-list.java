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
    public boolean isPalindrome(ListNode head) {
        /*
                // STACK SOLUTION
                Stack<Integer> stack = new Stack<>();
                ListNode temp = head;
                while(temp!=null)
                {
                    stack.push(temp.val);
                    temp = temp.next;
                }
                temp = head;
                while(temp!=null && temp.val==stack.pop())
                {
                    temp = temp.next;
                }
                return temp==null;
        */

        /*
                // ARRAYLIST SOLUTION
                List<Integer> list = new ArrayList();
                while(head != null) {
                    list.add(head.val);
                    head = head.next;
                }
                
                int left = 0;
                int right = list.size()-1;
                while(left < right && list.get(left) == list.get(right)) {
                    left++;
                    right--;
                }
                return left >= right;
        */

        // RECURSION SOLUTION (O(1)) - REVERSE LL FROM MIDDLE

        ListNode fast = head.next, slow = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverseLL(slow.next);
        slow.next = null;
        ListNode temp = head;
        while(reverse!=null)
        {
            if(temp.val!=reverse.val) return false;
            reverse = reverse.next;
            temp = temp.next;
        }
        return true;
    }

    private ListNode reverseLL(ListNode head)
    {
        ListNode prev = null,temp = head;
        while(temp!=null)
        {
            ListNode n = temp.next;
            temp.next = prev;
            prev = temp;
            temp = n;
        }
        return prev;
    }
}