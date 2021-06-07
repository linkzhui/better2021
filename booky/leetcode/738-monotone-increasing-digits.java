class Solution {
    public int monotoneIncreasingDigits(int n) {
        if(n / 10 < 1){
            return n; 
        }
        int[] arr = new int[10]; // 10^9 edge case 有10位数
        int curr = n, index = 0, dest = -1; 
        while(curr > 0){
            arr[index++] = curr % 10; //arr[0] 个位
            // System.out.println("arr i: " + arr[index-1]); 
            curr /= 10; 
        }
        
        while(index < 9){
            arr[index++] = -1; 
        }
        
        index = 0; 
        while(index < arr.length - 1 && arr[index] >= 0){
            // System.out.println("before: " + arr[index]); 
            if(arr[index + 1] > arr[index]){
                dest = index; // must have
                arr[index] = 9;
                // System.out.println("arr[index]: " + arr[index]); 
                arr[index+1]--;
            }
            index++; 
        }
        int res = 0, multi = 1; 
        index = 0; 
        
        // System.out.println("dest: " + dest); 

        while( index <= dest){
            res = res + 9 * multi;
            multi *= 10; 
            index++; 
            // System.out.println("res: " + res); 

        }

        while( index < arr.length && arr[index] > -1){
            res = res + arr[index] * multi; 
            // System.out.println("res: " + res); 
            multi = 10 * multi; 
            index++;
        }
        return res; 
    }
}

// 找规律 

// 332: 3>2, 
// -> 322: 3>2, 
// -> 222: not max, 
// -> 229: not max, 
// -> 299

// 232: 3>2, 
// ->222: not max, 
// -> 229

// 267836: 8>3, 
// -> 267796: 9>6, 
// -> 267799

// 只要变，一定以9结尾

// 找到从后往前，最后一个该增大的数在哪，
// 如332在_9_十位3->9，前一位退一，而十位及其后都变成9

// if v[i] >= v[i-1], ok skip; 
// else 暂记为当前目标位置

// 很多edge case：
// 1. 位数可能10
// 2. 可能在中间存在decrease，所以要记录能increase的最大位位置
// 3. 最后算res也要分为999……&其他更高位，2部分