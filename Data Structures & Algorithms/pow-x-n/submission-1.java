class Solution {
    public double myPow(double x, int n) {
        return myPowLongInput(x, (long)n);
    }
    public double myPowLongInput(double x, long n) {
        if (n == 0) {
            return 1;
        } 
        if (n < 0) {
            return 1 / myPowLongInput(x, n * (-1));
        }
        double half = myPowLongInput(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } 
        return half * half * x;
    }
}
