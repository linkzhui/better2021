//Solution 1: use int[]
//time complexity: SparseVector -> O(1), dotProduct -> O(n)
//space complexity: O(1)

class SparseVector {

    HashMap<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for(Integer i : this.map.keySet()) {
            if (vec.map.containsKey(i)) {
                result += this.map.get(i) * vec.map.get(i);
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

//Solution 2: use hashMap
//time complexity: SparseVector -> O(n), dotProduct -> O(L) (L is number of element in hashMap)
//space complexity: O(L)


class SparseVector {

    int[] array;
    SparseVector(int[] nums) {
        array = nums;
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int i = 0; i < vec.array.length; i++) {
            result += vec.array[i] * array[i];
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
