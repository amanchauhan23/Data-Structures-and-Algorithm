// #1 Brute Force || O(n2) 
// class Solution {
//     public int maxProduct(int[] nums) {
//         int global = nums[0];
//         int pro = 0;

//         for(int i = 0; i < nums.length; i++){ 
//             pro = nums[i];
//             global = Math.max(global, pro);
//             for(int j = i+1; j < nums.length; j++){
//                 pro *= nums[j];
//                 global = Math.max(global, pro);
//             }
//         }
//         return global; 
//     }
// }

// #2 DP || O(n) || O(1)
class Solution{
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int curMax = max;
            max = max(nums[i], curMax*nums[i], min*nums[i]);
            min = min(nums[i], curMax*nums[i], min*nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
