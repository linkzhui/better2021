import java.util.ArrayList;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); 
        Arrays.sort(s); 
        int res = 0; 
        for(int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0 ; i--){
            if(s[j] >= g[i]) {
                res++;
                j--;
            } 
        }
        return res;
    }
}

// 让最大的cookie先满足最greedy的娃