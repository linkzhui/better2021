class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r2 = matrix.length - 1 ;
        int c2 = matrix[0].length - 1;
        int c1 = 0;
        int r1 = 0;
        List<Integer> result = new LinkedList<>();
        while(c1 <= c2 && r1 <= r2) {
            int curRow = r1;
            int curCol = c1;
            for(; curCol <= c2; curCol++) {
                result.add(matrix[r1][curCol]);
            }
            for(curRow = curRow + 1; curRow <= r2; curRow++) {
                result.add(matrix[curRow][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (curCol = c2-1; curCol >= c1; curCol--) {
                    result.add(matrix[r2][curCol]);
                }
                for (curRow = r2 - 1; curRow > r1; curRow--) {
                    result.add(matrix[curRow][r1]);
                }
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return result;
    }
}
