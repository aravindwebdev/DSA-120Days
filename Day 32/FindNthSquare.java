class Solution {
    public int NthRoot(int N, int M) {
        // Using Method 1 - Linear Search
        // if( N==1 ) return M;
        // for(int i=1; i<=M; i++){
        //     int val = (int) POW(i,N);
        //     if(val == M) return i;
        //     else if (val > M) break;
        // }
        // return -1;

        // Using Method 2 - Binary Search
        int low = 1;
        int high = M;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int sqrt = POW(mid, N, M);
            if(sqrt == 1) return mid;
            else if(sqrt == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Finding the pow
    private static int POW(int mid, int n, int m){
        long ans = 1;
        long base = mid;
        while (n > 0){
            if(n % 2 == 1){
                ans = ans*base;
                if ( ans > m) return 2;
                n--;
            }else{
                n = n/2;
                base = base*base;
                if(base > m) return 2;
            }
        }
        if ( ans == m) return 1;
        return 0;
    }
}
