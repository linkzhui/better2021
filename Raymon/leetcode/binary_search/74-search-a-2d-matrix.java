class Solution {
    //best Solution, convert 2d array into 1d array
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }

    //my solution, run binary search in column first to find out the most cloest row,
    //then run binary search within in row
    public boolean searchMatrix(int[][] matrix, int target) {
    int top = 0;
    int down = matrix.length - 1;
    while (top + 1 < down) {
        int mid = top + (down-top) / 2;
        if (matrix[mid][0] == target) {
            return true;
        } else if (matrix[mid][0] > target) {
            down = mid;
        } else {
            top = mid;
        }
    }
    int[] search;
    if (matrix[top][0] == target || matrix[down][0] == target) {
        return true;
    } else if (matrix[top][0] < target && matrix[down][0] > target) {
        return binarySearch(matrix[top], target);
    } else {
        return binarySearch(matrix[down], target);
    }
  }

  private boolean binarySearch(int[] array, int target) {
      int left = 0;
      int right = array.length - 1;
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (array[mid] == target) {
              return true;
          } else if (array[mid] < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return false;
  }
}
