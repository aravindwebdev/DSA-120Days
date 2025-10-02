class Solution {
    public int floorSqrt(int n) {

        // Using binary search - O(log n)
        int low = 1;
        int high = n;
        int res = 0;
        while(low <= high){
            int mid = low + (high-low)/2; //fix overflow
            long sqrt = (long) mid * (long) mid;
            if( sqrt <= (long)n){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;

        // using math lib O(1)
        // return (int)Math.floor(Math.sqrt(n));

        // Using linear search O(n) - TLE
        // int res = 0;
        // for(int i=0; i<=n; i++){
        //     long sqr = i * i;
        //     if(sqr <= (long)n){
        //         res = i;
        //     }else{
        //         break;
        //     }
        // }
        // return res;
    }
}