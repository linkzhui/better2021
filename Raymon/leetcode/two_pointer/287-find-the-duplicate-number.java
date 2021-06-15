class Solution {
    public int findDuplicate(int[] nums) {
        //Solution 1: Sorting the array first, then check nearby element are same or not
        //time complexity: O(nlogn)
        //space complexity: O(n)

        //Solution 2: Use set to store the element
        //time complexity: O(n)
        //space complexity: O(n)

        //Solution 3: Cycle detection

        //不能这么写
        // int slow = 0;
        // int fast = 0;
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
