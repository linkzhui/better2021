class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0; 
        while(l < r &&
              l < height.length && 
             r > 0){
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            } else {
                r--; 
            }
        }
        return res; 

    }
}

// 1. 决定自增/自减时，是比较l和r对应value，而不是分别比较l与l+1，r与r-1
// 2. 因为底边是间隔数，所以取(r - l)而不是(r - l + 1)