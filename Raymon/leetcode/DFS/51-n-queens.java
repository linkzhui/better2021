class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[] position = new int[n];
        helper(position, 0, n, result);
        return result;
    }

    private void helper(int[] position, int level, int n, List<List<String>> result) {
        if (level == n) {
            List<String> subResult = new LinkedList<>();
            for (int i = 0; i < position.length; i++) {
                int queenPosition = position[i];
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < queenPosition; j++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = queenPosition + 1; j < n; j++) {
                    sb.append(".");
                }
                subResult.add(sb.toString());
            }
            result.add(subResult);
        }
        for(int i = 0; i < n; i++) {
            if (checkPostion(position, level, i)) {
                position[level] = i;
                helper(position, level + 1, n, result);
            }
        }
    }


    private boolean checkPostion(int[] position, int level, int n) {
        for(int i = 0; i < level; i++) {
            int height = level - i;
            int width =  Math.abs(position[i] - n);
            if (position[i] == n || height == width) {
                return false;
            }
        }
        return true;
    }
}
