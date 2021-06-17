class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int ans = 0, l = 0, r = height.length - 1; 
        int lmax = height[l], rmax = height[r]; 
        while(l <= r){
            if(lmax <= rmax){
                lmax = Math.max(height[l], lmax);
                ans += lmax - height[l]; 
                l++;
            } else{
                rmax = Math.max(height[r], rmax);
                ans += rmax - height[r]; 
                r--; 
            }
        }
        return ans; 
    }
}

// 不看答案根本想不出。
// 为了计算每一处能trap的water，要
// 1. 维护lmax, rmax，比较此二者决定scan大方向
// 2. 与当前h[]差值得出water
// 3. l<=r是循环条件，不是l<r否则可能会漏掉最后l或r之一