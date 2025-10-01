class Solution {
    // Brute Force 1 - HashMap
    public int singleNonDuplicate(int[] nums) {
      HashMap<Integer,Integer> count = new HashMap<>();
      for(int i : nums){
            count.put(i, count.getOrDefault(i,0)+1);
      }
      for(Map.Entry<Integer,Integer> key : count.entrySet()){
        if(key.getValue() == 1 ) return key.getKey();
      }
      return -1;
    }

    // Brute Force 2 - XOR
    public int singleNonDuplicate(int[] nums) {
      int single = 0;
      for(int i : nums){
            single ^= i;
      }
      return single;
    }
    public int singleNonDuplicate(int[] nums) {
      HashMap<Integer,Integer> count = new HashMap<>();
      for(int i : nums){
            count.put(i, count.getOrDefault(i,0)+1);
      }
      for(Map.Entry<Integer,Integer> key : count.entrySet()){
        if(key.getValue() == 1 ) return key.getKey();
      }
      return -1;
    }

    //Optimized - Binary search
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if( n == 1) return nums[0];
        if( nums[0] != nums[1]) return nums[0];
        if( nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||
            (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}