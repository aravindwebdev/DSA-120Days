class Solution {
    // Find the floor and ceil of the sorted array
    // Brute force - O(n)
    public int[] getFloorAndCeil(int[] nums, int x) {
       int[] res = new int[2];
       int floor = -1, ceil = -1;

       for(int num : nums){

         if(num <= x && num > floor){
            floor = num;
         }
         if(num >= x && (ceil == -1 || num < ceil)){
            ceil = num;
         }
       }
       return new int[] {floor, ceil};
    }
}