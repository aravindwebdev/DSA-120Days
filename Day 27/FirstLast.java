class Solution {
  public int[] searchRange(int[] nums, int target) {
    
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
