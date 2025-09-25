public class FirstLastOccurence{
    public static void main(String[] args){


    }
    //Brute Force
    public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int first = -1, last = -1;

    for(int i=0; i<nums.length; i++){
        if(nums[i] == target){
            if(first == -1) first = i;
            last = i;
        }
    }
    res[0]=first;
    res[1]=last;
    return res;
    }

    //Using Lower & Upper bound
    public int[] searchRange(int[] nums, int target) {
       int lowerBound = findLowerBound(nums, target);
        if(lowerBound == nums.length || nums[lowerBound] != target){
            return new int[] {-1,-1};
        }
       int upperBound = findUpperBound(nums, target)-1; 

        return new int[] {lowerBound, upperBound};
    }

    int findLowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = nums.length;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return res;
    }

    int findUpperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = nums.length;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > target){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    //Using Binary Search
    public int[] searchRange(int[] nums, int target) {
        // Using Lower & Upper bound
        int firstOccurence = findFirstOccurence(nums, target);
        if (firstOccurence == -1) return new int[] {-1, -1};
        int secondOccurence = findSecondOccurence(nums, target);

        return new int[] {firstOccurence, secondOccurence};
    }

    int findFirstOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            res = mid;
            high = mid - 1;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        }
        return res;
    }

    int findSecondOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;
        while (low <= high) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            res = mid;
            low = mid + 1;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        }
        return res;
    }

}