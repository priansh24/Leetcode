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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(head == null || head.next==null || head.next.next == null) return ans;
        List<Integer> list = new ArrayList<>();
        int ind = 2;
        ListNode prev = head;
        ListNode current = prev.next;
        ListNode nxt = current.next;
        while(nxt!=null)
        {
            if((current.val>prev.val && current.val>nxt.val) || (current.val<prev.val && current.val< nxt.val))
            {
                list.add(ind);
            }
            prev = current;
            current = nxt;
            nxt = nxt.next;    
            ind++;   
        }
        int min = Integer.MAX_VALUE;
        if(list.size()<2) return ans;
        for(int i:list) System.out.print(i+" ");
        for(int i = 1;i<list.size();i++)
            min = Math.min(min,list.get(i) - list.get(i-1));
        ans[0] = min;
        ans[1] = list.get(list.size()-1) - list.get(0);

        return ans;
    }
}