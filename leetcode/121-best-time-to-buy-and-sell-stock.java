class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1){
            return 0; 
        }
        int res = 0, i = 0;  
        int minV = 10001;
        while (i <= prices.length - 1){
            if (minV > prices[i]){
                minV = prices[i];
            }
            res = Math.max(res, prices[i] - minV); 
            i++; 
        }
        return Math.max(res, 0); 
    }
}

// O(n^2)很容易，对每个数分别找到其右侧的max（或者左侧的min），并记录差值的max。

// One pass：总需要先买才能卖，低买高卖才能赚。所以scan的过程中记录下之前检查到的min value，
// 每遇到新value，都算一下卖出收益取最大值。
// O(n)

// 错误思路：先找全局最小值在找之后的最大值————全局最小值不一定是买卖的最优点。如：5, 9, 7, 3, 1, 3。本思路下是3-1=2；实际最大结果是9-5=4