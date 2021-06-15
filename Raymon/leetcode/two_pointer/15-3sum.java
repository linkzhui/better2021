package two_pointer;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return result;
        }


        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right --;
                }
            }
        }
        return result;
    }
}
