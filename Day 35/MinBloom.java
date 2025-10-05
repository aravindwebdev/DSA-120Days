
class Solution {
    public int roseGarden(int n, int[] nums, int k, int m) {
     //check if n of days is less than MxK then its notpossible 
     long val = (long)m*k;
     if(n < val) return -1;
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;
     for(int i : nums){
        min = Math.min(min,i);
        max = Math.max(max,i);
      }
      int low = min, high = max, ans = -1;

      while(low <= high){
        int mid = (low + high) / 2;

        if(checkPossible(nums, mid, m, k)){
          ans = mid;
          high = mid-1;
        }else{
          low = mid+1;
        }
      }
      return ans;

    // Linear Search
    //  for(int i=min; i<=max; i++){
    //   if(checkPossible(nums, i, k, m)){
    //     return i;
    //   }
    //  }
    //  return -1;
    }
   
    private static boolean checkPossible(int[] nums, int day, int k, int m){
      int count = 0; int noOfDays = 0;
      for(int i=0; i<nums.length; i++){
        if(nums[i] <= day) {
          count++;
        }else{
          noOfDays += (count/k);
          count = 0;
        }
      }
      noOfDays += (count/k);
      return noOfDays >= m;
    }
}


