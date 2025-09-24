class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid]>=x){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
       return ans;
    }
}
