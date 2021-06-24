class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (dp.size() == 0 || dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
            } else {
                int low = 0;
                int high = dp.size() - 1;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (dp.get(mid) == nums[i]) {
                        high = mid;
                        break;
                    }
                    if (dp.get(mid) > nums[i]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                dp.set(high, nums[i]);
            }
        }
        return dp.size();
    }
}
