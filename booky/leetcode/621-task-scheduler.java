// class SortByFreq implements Comparator<int[]>{
//     public int compare(int a[], int b[]){
//         return b[1] - a[1]; 
//     }
// }

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length < 1){
            return 0; 
        }

        int[] f = new int[26]; 
        // int[x, y]: x is 'A'-'A', y is frequence
        for(int i = 0; i < tasks.length; i++){
            f[tasks[i] - 'A']++; // freq
        }
        
        int maxFreq = 0, p = -1;
        for(int i = 0; i < 26; i++){
            if(maxFreq < f[i]){
                maxFreq = f[i]; 
                p = i; 
            }
        }
        int maxIdle = (maxFreq - 1) * n;        // 4
        int others = tasks.length - maxFreq;    // 3

        for (int i = 0; i < 26 && f[i] > 0 && maxIdle > 0; i++){
            if(p == i){
                continue;
            }
            if(f[i] < maxFreq){
                maxIdle = Math.max(maxIdle - f[i], 0); 
            } else{
                maxIdle = Math.max(maxIdle - maxFreq + 1, 0);   // 2
            }
            System.out.println("maxIdle: " + maxIdle); 
        }
        
        return maxIdle + others + maxFreq; 
      
    }
} 

// 思路原理：
// 1. 找出idle slots最大可能的值
// 2. 试着交替用其他task填补idle slots
// 3. 填完后，剩下的元素即使还有相同的，也不会产生更多idle slot，可以找到插空的位置。就可以直接加上剩余个数了。

// 填补slots代码关键：
// 1. max frequency的字母需要跳过
// 2. 同为max frequency的其他字母需要特殊处理，并不能全部填入idle slots， e.g. AAABBB