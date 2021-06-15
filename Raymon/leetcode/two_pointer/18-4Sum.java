class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int i, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (i >= nums.length || nums[i] * k > target || nums[nums.length - 1] * k < target) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, i);
        }
        for (int start = i; start < nums.length; start++) {
            if (start == i || nums[start] != nums[start-1]) {
                List<List<Integer>> prevRes = kSum(nums, target - nums[start], start + 1, k - 1);
            for(List<Integer> list : prevRes) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[start]);
                temp.addAll(list);
                res.add(temp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int i) {
        List<List<Integer>> res = new ArrayList<>();
        int start = i, end = nums.length - 1;
        while (start < end) {
            if (start == i || nums[start] != nums[start-1]) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    res.add(Arrays.asList(nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            } else {
                start ++;
            }
        }
        return res;
    }
}
