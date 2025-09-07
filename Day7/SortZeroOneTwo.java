public class SortZeroOneTwo{
    public static void main(String[] args){
      int[] nums = {0, 2, 1, 2, 0, 1};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        sol.sortZeroOneTwo(nums);
        
        // Print the array elements after sorting
        System.out.println("After sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Solution{
    
    public void sortZeroOneTwo(int arr[]){
    // Brute Force - O(nLogn)
        Arrays.sort(arr);
    
    // Better - O(n)
    /**
     * count the 0,1,2 then replace with array position
     */

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
            else count2++;
        }
        for(int i=0; i<count0; i++){
            nums[i] = 0;
        }
        for(int i=count0; i<count0+count1; i++){
            nums[i] = 1;
        }
        for(int i=count0+count1; i<nums.length; i++){
            nums[i] = 2;
        }

    // Optimal - O(n)
    /**
     * Dutch Flag Algorthim
     */
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high){
            if(nums[mid] == 0){
                //Swap mid and low
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                //Increase the pointer
                low++;
                mid++;
                }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                //Swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                //Decrease the pointer
                high--;
            }
        }
    }
}
