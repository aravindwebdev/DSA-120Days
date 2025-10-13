class Solution {
    // Brute force - S
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                temp[count++] = nums[i];
            }
        }

        while(count < n){
            temp[count++] = 0;
        }

        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }

    //optimal - solution
    public void moveZeroes(int[] nums){
        int n = nums.length;
        int left = 0;
        for(int right=0; right<n; right++){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

}