class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid+1]) {
                //当目前下坡的时候，当前的点有可能是顶点
                r = mid;
            } else {
                //当目前是ascending order,说明当前的dian不是peak
                l = mid + 1;
            }
        }
        //最后l和r会重叠，所以最后return r和l都ok
        return r;
    }
}
