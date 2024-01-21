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
    public void reorderList(ListNode head) {

        ListNode traverse = head;

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head.next;
        ListNode ans = head;
        int n = 0, i = 1;

        while(traverse!=null) {
            stack.push(traverse);
            n++;
            traverse = traverse.next;
        }

        while(true){

            if(i==n) {
                
                ans.next = null;
                break;
            }
            ans.next = stack.pop();
            ans = ans.next;
            System.out.println(ans.val);
            i++;

            if(i==n) {
                
                ans.next = null;
                break;
            }
            ans.next = temp;
            ans = ans.next;
            System.out.println(ans.val);
            temp = temp.next;
            i++;


        }
    }
}
