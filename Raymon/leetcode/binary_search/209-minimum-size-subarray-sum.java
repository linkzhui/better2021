class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        int solution = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            int to_find = sums[i-1] + target;
            int left = i;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midValue = sums[mid];
                if (midValue == to_find ) {
                    solution = Math.min(solution, mid - i + 1);
                    break;
                } else if (midValue < to_find) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //这里是大于等于，是因为左右边界重叠的时候
            if (sums[left] >= to_find) {
                solution = Math.min(solution, left - i + 1);
            }
        }
        return solution == Integer.MAX_VALUE? 0 : solution;
    }
}
