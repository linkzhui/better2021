class Solution {
    public double myPow(double x, int n) {
        long N = n;
        //这里需要转换成long是因为最大的negative integer不能转成positive integer
        if (N < 0) {
            N *= -1;
            x = 1/ x;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

//     private double helper(double x, int n) {
//         if (n == 0) {
//             return 1;
//         } else if (n == 1) {
//             return x;
//         }

//         if (n % 2 == 0) {
//             double res = helper(x, n / 2);
//             return res * res;
//         } else {
//             return helper(x, n/2) * helper(x, n/2 + 1);
//         }
//     }
}
