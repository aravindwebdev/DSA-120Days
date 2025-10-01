class Solution {
    /* Function to search for the target element 
    in a rotated sorted array with duplicates */
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int low = 0, high = n - 1;
        
        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to the target
            if (arr.get(mid) == target) return true;

            // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
            if (arr.get(low).equals(arr.get(mid)) && arr.get(mid).equals(arr.get(high))) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Check if the left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                /*  Eliminate the right part if target
                    exists in the left sorted part */
                if (arr.get(low) <= target && target <= arr.get(mid)) {
                    high = mid - 1;
                } 
                // Otherwise eliminate the left part
                else {
                    low = mid + 1;
                }
            } else {
                /*  If the right part is sorted and
                    target exists in the right sorted
                    part, eliminate the left part   */
                if (arr.get(mid) <= target && target <= arr.get(high)) {
                    low = mid + 1;
                } 
                // Otherwise eliminate the right part
                else {
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return false;
    }
}