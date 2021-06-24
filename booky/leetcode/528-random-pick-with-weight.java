class Solution {
    int[] w;
    int[] s; 
    
    public Solution(int[] w) {
        this.w = w; 
        s = new int[w.length]; 
        s[0] = w[0];
        for(int i = 1; i < w.length; i++){
            s[i] += s[i - 1] + w[i]; 
        }
    }
    
    public int pickIndex() {
        if(w.length == 1){
            return 0;
        }
        
        double num =  s[s.length - 1] * Math.random(); 
        
        int lo = 0, hi = s.length - 1, mid = 0; 
        while(lo < hi){
            mid = lo + (hi - lo) / 2; 
            if(s[mid] >= num){
                hi = mid;
            } else if(s[mid] < num){
                lo = mid + 1; // !!!!
            }
        }
        // if(s[lo] > num){
        //     return lo;
        // }
        return lo; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */