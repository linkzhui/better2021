class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIndex = 0;
        int secondIndex = 0;
        List<int[]> res = new ArrayList<>();
        while(firstIndex < firstList.length && secondIndex < secondList.length) {
            int[] first = firstList[firstIndex];
            int[] second = secondList[secondIndex];
            int low = Math.max(first[0], second[0]);
            int high = Math.min(first[1], second[1]);

            //这里是关键
            if (low <= high) {
                res.add(new int[]{low, high});
            }
            if (first[1] < second[1]) {
                    firstIndex++;
                } else {
                    secondIndex++;
            }
        }
        int[][] result= new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        return result;
    }
}
