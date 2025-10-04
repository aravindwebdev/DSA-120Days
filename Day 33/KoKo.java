class Solution {
    //Using Linear Search - O(m*n)
    public int minimumRateToEatBananas(int[] nums, int h) {
        int res = 0;
        int n = nums.length;
        //find max
        OptionalInt Omax = Arrays.stream(nums).max();
        int max = Omax.getAsInt();

        for(int i=1; i<=max; i++){
            long totalTime = totalTimeTaken(nums,i);
            if(totalTime <= h){
                return i;
            }
        }
        return max;
    }

    public static long totalTimeTaken(int[] arr, int hr){
        long totalTime = 0;
        for(int i=0; i<arr.length; i++){
            totalTime += Math.ceil((double)arr[i]/(double)hr);
        }
        return totalTime;
    }
}