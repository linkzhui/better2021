class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] rightMax = new int[height.length + 1];
        int[] leftMax = new int[height.length + 1];

        int max = height[0];
        for(int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        max = height[height.length - 1];
        for(int i = height.length - 2; i >=0 ;i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        int result = 0;
        for (int i = 1; i < height.length-1; i++) {
            result += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return result;
    }
}
