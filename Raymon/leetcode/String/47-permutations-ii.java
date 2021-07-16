class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        helper(nums1, 0, result);
        return result;
    }

    private void helper(Integer[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(Arrays.asList(nums)));
        }
        boolean[] set = new boolean[21];
        for(int j = index; j < nums.length; j++) {
            if (set[nums[j] + 10] == false) {
                set[nums[j] + 10] = true;
                swap(nums, index, j);
                helper(nums, index + 1, result);
                swap(nums, index, j);
            }

        }

    }

    private void swap (Integer[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
