class Solution {
    public double myPow(double x, int n) {
        long nLong = (long)n;
        if (n < 0) {
            x = 1 /x;
            nLong = nLong * (-1); 
        }
        return myPowLongInput(x, nLong);
    }
    public double myPowLongInput(double x, long n) {
        if (n == 0) {
            return 1;
        } 
        double half = myPowLongInput(x, n / 2);  
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
