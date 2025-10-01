class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
      int low = 0;
      int high = nums.size() - 1;
      int min = Integer.MAX_VALUE;
      while(low <= high){
        int mid = (low + high)/2;

            if(nums.get(low) <= nums.get(mid)){
                min = Math.min(min, nums.get(low));
                low = mid + 1;
            }else{
                min = Math.min(min, nums.get(mid));
                high = mid - 1;
            }
        }
      return nums.indexOf(min);
    }
}