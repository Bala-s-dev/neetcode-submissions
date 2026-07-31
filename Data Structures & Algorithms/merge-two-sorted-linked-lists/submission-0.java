class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // Ensure list1 starts with smaller value
        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode prevt1 = null;

        while(temp1 != null && temp2 != null){

            if(temp1.val <= temp2.val){
                prevt1 = temp1;
                temp1 = temp1.next;
            }
            else{
                // Insert temp2 before temp1
                prevt1.next = temp2;

                ListNode next2 = temp2.next;
                temp2.next = temp1;

                prevt1 = temp2;
                temp2 = next2;
            }
        }

        // Attach remaining nodes
        if(temp2 != null){
            prevt1.next = temp2;
        }

        return list1;
    }
}