/**
 * Two Sum
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
import java.util.*;
public class Day1{
    public static void main(String args[]){
        System.out.println("Two Sum -");
        int[] nums = {2,11,7,15};
        int target = 9;
        int result[] = optimal(nums, target);
        for(int i : result){
            System.out.print("[ "+i+" ]");
        }
    }

    public static int[] bruteforce(int nums[], int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * Better Solution - Using HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public static int[] better(int nums[], int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int value = nums[i];
            if(map.containsKey(target - value)){
                return new int[] {map.get(target-value),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }

    /**
     * Optimal Solution - Without using Hashmap
     * Sorted + two pointer approach
     * Time Complexity - O(n) + O(nlogn)
     * Space Complexity - O(n)
     */
    public static int[] optimal(int nums[], int target){
        int res[] = new int[2];
        int n = nums.length;

        // 2D - to store the indices - (Without using hashMap)
        int eleIndex[][] = new int[n][2];

        for(int i=0;i<n;i++){
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }

        //Sort 2D array based on row
        Arrays.sort(eleIndex,new Comparator<int []>(){
            public int compare(int[]a, int[]b){
                return Integer.compare(a[0],b[0]);
            }
        });

        //Two pointer
        int left = 0;
        int right = nums.length-1;

        int[] result = new int[2];

        while(left < right){
            int sum = eleIndex[left][0] + eleIndex[right][0];
            if(sum==target){
                 /* If sum equals target, 
                store indices and return*/
                res[0] = eleIndex[left][1];
                res[1] = eleIndex[right][1];
                return res;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}