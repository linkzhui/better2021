class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m == 0){
        //     return; 
        // } 
        if(n == 0){
            return; 
        }
        
        // int[] res = new int[nums1.length + nums2.length]; 
        int p = m - 1, q = n - 1, i = m + n - 1; 
        while(p >= 0 && q >= 0){
            if(nums1[p] >= nums2[q]){
                nums1[i--] = nums1[p--]; 
            } else {
                nums1[i--] = nums2[q--]; 
            }
        }
        
        while(q < 0 && p >= 0){
            nums1[i--] = nums1[p--]; 
        }
        
        while(p < 0 && q >= 0){
            nums1[i--] = nums2[q--]; 
        }
        return; 
    }
}

// 请仔细审题，不要想当然new array 和 return array。实际上需要edit并return nums1。

