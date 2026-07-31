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
        ListNode temp = head;
        int len = 0;
        List<Integer> arr = new ArrayList<>();
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
            len++;
        }
        temp = head;
        for(int i = 0; i < len/2; i++){
            temp.val = arr.get(i);
            temp = temp.next;
            temp.val = arr.get(len - i - 1);
            temp = temp.next;
        }
        if(len % 2 != 0){
            temp.val = arr.get(len/2);
        }
    }
}
