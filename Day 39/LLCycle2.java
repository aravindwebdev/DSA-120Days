class LLCycle2{
    public int isCycleDetectedCount(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && slow != null){
            if(fast == slow){
                return findLength(slow, fast);
            }
        }
        return false;
    }

    public int findLength(ListNode slow, ListNode fast){
        int count = 0;
        while(fast != slow){
            count++;
            fast = fast.next;
        }
        return count;
    }
}