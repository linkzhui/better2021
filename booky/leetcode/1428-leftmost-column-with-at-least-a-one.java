/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rownum = binaryMatrix.dimensions().get(0) - 1; 
        int colnum = binaryMatrix.dimensions().get(1) - 1; 
        if(rownum < 0 || colnum < 0){
            return -1; 
        }
        int r = 0, c = colnum, res = 0, flag = 0; 
        while(r <= rownum && c >= 0){
            if(binaryMatrix.get(r, c) == 1){
                if(flag == 0){
                    flag = 1;
                }
                while(c >= 0 && binaryMatrix.get(r, c) == 1){
                    res = c; 
                    c--; 

                }
            }
            r++; 
        }
        if(flag == 0){
            return -1;
        }
        return res; 
    }
}

// res的赋值时机容易出错，在自减前，别该0却赋值为-1