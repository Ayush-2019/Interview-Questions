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

    public ListNode merge(ListNode first, ListNode second){

        if(first == null) return second;
        if(second == null) return first;

        ListNode node = new ListNode(-1);

            if(first.val <= second.val){
                node = first;
                node.next = merge(first.next, second);
            }

            else{
                node = second;
                node.next = merge(first, second.next);
            }

        return node;


    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;

        ListNode head = lists[0];

        for(int i=1;i<lists.length;i++){

            head = merge(head, lists[i]);
        }

        return head;
        
    }
}
