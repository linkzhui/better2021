class Solution {
    public int search(int[] nums, int target) {
        //4 -> 5 -> 3 -> 2 -> 3
        //
        int low = 0, high = nums.length - 1;
        //这里要等于，因为low和high相同的情况也需要考虑
        while (low <= high) {
            int mid = low + (high - low) /2;
            int val = nums[mid];
            if (val == target) {
                return mid;
            }
            else if (nums[low] <= val) {
                if (target < val && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > val && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
