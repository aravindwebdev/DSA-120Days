class SearchIndex{
    //Brute force
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }

    //lower bound
     public int searchInsert(int[] nums, int target) {
      int low = 0;
      int high = nums.length-1;
      int res = nums.length;
      while(low <= high){
        int mid = (low + high)/2;
        if(nums[mid]>=target){
            res = mid;
            high = mid - 1;
        }else{
            low = mid + 1;
        }
      }
      return res;
    }
}