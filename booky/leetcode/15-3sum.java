class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if(nums.length < 3){
            return res; 
        }
        
        Arrays.sort(nums); 
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int l = i + 1, r = nums.length - 1; // avoid duplicates
            while(l < r 
                  && l < nums.length - 1 
                  && r > 0) {
                if(nums[l] + nums[r] < -nums[i] || l == i){
                    l++; 
                } else if (nums[l] + nums[r] > -nums[i] || r == i){
                    r--;
                } else {
                    if(res.size() != 0 
                       && nums[i] == res.get(res.size() - 1).get(1) 
                       && nums[l] == res.get(res.size() - 1).get(0) ){ // avoid duplicates
                        // if(res.size() > 0){
                            // System.out.printf("i: %d; l: %d; r: %d \n nums[l]: %d; \n res.get(res.size() - 1).get(1): %d \n", i, l, r, nums[l], res.get(res.size() - 1).get(0) ); 
                        // }
                        l++; 
                        continue;
                    }
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[l], nums[i], nums[r]) )); 
                    l++;
                }
            }
        }
        return res; 
    }
}

// edge case: [0,0,0,0]

// 方法一
// 1. sort (容易去重)
// 2. 遍历过程中对每个数，使用2sum in sorted array的办法找结果，O(n^2)
// 3. 在第二层循环中，left pointer从i+1开始，而不是0开始，可以除重

// 方法二 哈希表
