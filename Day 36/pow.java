class Solution {
    public double myPow(double x, int n) {
          //your code goes here
          long num = n;
          if(num < 0) {
            return (1.0/power(x, -num));
          }
          return power(x,num);
    }

    private double power(double x, long n){
      if(n==0) return 1.0;
      if(n==1) return x;

      if(n%2==0){
        return power(x*x, n/2);
      }
      return x * power(x, n-1);
    }
}