class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double l = findKth(nums1, nums2, (nums1.length + nums2.length + 1) / 2, 0, 0);
        double r = findKth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1, 0, 0);
        // System.out.printf("l: %f; r: %f\n", l, r); 
        return (l + r) / 2; 
    }
    
    public double findKth(int[] nums1, int[] nums2, int k, int i, int j){
        if(i >= nums1.length){
            return nums2[k + j - 1]; 
        }
        if(j >= nums2.length){
            return nums1[k + i - 1]; 
        }
        if(k == 1){
            return Math.min(nums1[i], nums2[j]); 
        }
        if(k / 2 + i - 1 < nums1.length && // both  -1, nums1 num2 足够k/2，mid1<mid2; 
           k / 2 + j - 1 < nums2.length && 
            nums1[k / 2 + i - 1] < nums2[k / 2 + j - 1] || 
          k / 2 + j - 1 >= nums2.length) { 
            // evict from nums1
            return findKth(nums1, nums2, k - k / 2, i + k / 2, j);            
        }
        return findKth(nums1, nums2, k - k / 2, i, j + k / 2); 
    }
}

// evict最小的k/2的二分法，几种情况：
// 1. len1 = 0 OR len2 = 0
// 2. k = 1
// 3. nums2 剩下元素不足 OR （两个数组元素都足够 AND mid1 < mid2)
// 4. else 


// 易错点
// 1. 从index i开始的第k个元素，在数组中的index=i+k-1，不是i+k
// 2. #3条件要完备，勿漏
// 3. 下一层findKth()时，应找删去k/2剩余的第 (k-k/2)，而不是第k/2

