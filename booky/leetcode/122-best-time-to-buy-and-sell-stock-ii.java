class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0; 
        }
        
        int minp = prices[0]; 
        int maxp = prices[0]; 

        int i = 0, res = 0; 
        while (i < prices.length){
            if(i + 1 < prices.length && prices[i] <= prices[i + 1]){
                // ascending - find the next peak
                int j = i + 1; 
                int curr = 0; 
                while(j < prices.length && curr <= prices[j] - prices[i]){
                    curr = prices[j] - prices[i]; 
                    // System.out.println("curr: " + curr); 
                    j++; 
                }
                res += curr; 
                i = j;
            } else {
                // descending - find the next valley
                i++; 
            }
        }
        return res; 
    }
}

// 根据单调递增/递减先找到valley，
// 然后找下一个peak。

// 每次找到peak后结算这次局部收益 res+=curr