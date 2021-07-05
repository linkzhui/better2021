class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1]; // last possible index = amount
        Arrays.fill(f, -1); 
        f[0] = 0; 
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == amount){
                return 1; 
            }
            if(coins[i] < amount){
                f[coins[i]] = 1; 
            }
        }
//         f[i] = min(f[i - j]) + 1; 
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(f[i] == 1){
                    continue; 
                }
                if((i - coins[j] >= 0 && f[i - coins[j]] >= 0) && (f[i] == -1 || f[i - coins[j]] < f[i])) { 
                    f[i] = f[i - coins[j]] + 1; 
                }
            }
        }
        return f[amount]; 
        
    }
}

// F[i] = F[ i-coins[j] ]+1; 

// NOT F[i] = F[ i - j ] + 1. 