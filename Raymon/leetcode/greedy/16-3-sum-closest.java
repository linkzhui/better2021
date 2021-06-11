class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2 && diff != 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                Integer sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return target - diff;
    }
}
