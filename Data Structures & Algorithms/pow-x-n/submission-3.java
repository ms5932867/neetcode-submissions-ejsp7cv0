class Solution {
    public double myPow(double x, int n) {
        long nLong = (long)n;
        if (nLong < 0) {
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
/*
int 无法表示 -Integer.MIN_VALUE，会溢出
Integer.MIN_VALUE = -2147483648
Integer.MAX_VALUE = 2147483647
int 的负数比正数多一个，所以最小值无法取反 → 必须转 long
*/
