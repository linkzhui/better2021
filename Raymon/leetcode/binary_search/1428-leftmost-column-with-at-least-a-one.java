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
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        if (rows == 0 || cols == 0) {
            return -1;
        }
        int result = cols;
        for (int i = 0; i < rows; i++) {
            int low = 0;
            int high = Math.min(result, cols - 1);
            while (low < high) {
                int mid = low + (high - low) / 2;
                int val = binaryMatrix.get(i, mid);
                if (val == 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (binaryMatrix.get(i, low) == 1) {
                result = Math.min(result, low);
            }
        }
        return result == cols? -1:result;
    }
}
