class Solution {      // o(n) || O(1) || using two pointers
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            if(height[left] < height[right]){
                int vol = height[left]*(right - left);
                max = Math.max(max, vol);
                left++;                                     // min of height is the limiting factor
            }else{
                int vol = height[right]*(right - left);
                max = Math.max(max, vol);
                right--;                                    // min of height is the limiting factor
            }
        }
        return max;
    }
}
