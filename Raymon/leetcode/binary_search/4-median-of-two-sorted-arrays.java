class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int firstL = nums1.length;
        int secondL = nums2.length;
        int left = 0;
        int right = firstL;
        int half = (firstL + secondL + 1) / 2;
        int leftMax = 0;
        int rightMin = 0;
        while (left <= right) {
            int i = left + (right - left) /2;
            int j = half - i;
            if (i > 0 && nums1[i-1] > nums2[j]) {
                right = i - 1;
            } else if (j > 0 && i < firstL && nums2[j-1] > nums1[i]) {
                left = i + 1;
            } else {
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if(j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((firstL + secondL) % 2 == 1) {
                    return leftMax;
                }

                if (i == firstL) {
                    rightMin = nums2[j];
                } else if (j == secondL) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums2[j], nums1[i]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return -1;
    }
}
