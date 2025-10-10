class LLCycle{
    public boolean isCycleDetected(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && slow != null){
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}