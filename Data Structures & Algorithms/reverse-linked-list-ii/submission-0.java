class Solution {

    public ListNode reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;

        while (count > 0) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            count--;
        }

        // Connect the old head (now the tail)
        // to the remaining list
        head.next = curr;

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        int ind = 1;

        // Move curr to the 'left' position
        while (ind < left) {
            prev = curr;
            curr = curr.next;
            ind++;
        }

        // Reverse right-left+1 nodes
        ListNode rev = reverse(curr, right - left + 1);

        // If left == 1, reversed node becomes the new head
        if (prev == null) {
            return rev;
        }

        // Connect the part before left to reversed part
        prev.next = rev;

        return head;
    }
}