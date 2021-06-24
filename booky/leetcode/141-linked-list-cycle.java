/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false; 
        }
        ListNode fast = head.next.next, slow = head.next;
        while(fast != null && slow != null){
            if (fast == slow){
                return true; 
            }
            if(fast.next != null){
                fast = fast.next.next; 
            }
            else return false; 
            slow = slow.next; 
        }
        return false;
    }
}

// 1. val可能重复，所以不能用set存val来辨别
// 2. listnode可以直接=比较是否同一个node
// 3. 时刻记得检查null node