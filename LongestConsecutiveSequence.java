class Solution {
    public int longestConsecutive(int[] nums) {
        // #1 O(n2) | O(1)
        // if(nums.length < 1)
        //     return 0;
        // Arrays.sort(nums);
        // int max = 0;
        // int l = 0;
        // int r = 1;
        // while(l < nums.length){
        //     int mx = 0;
        //     while((r < nums.length) && ((nums[r] == nums[l]) || (nums[r] == nums[l] + 1))){
        //         if(nums[r] != nums[l])
        //             max = Math.max(max, ++mx);
        //         l++;
        //         r++;
        //     }
        //     l++;
        //     r++;
        // }
        // return max+1;
        
        // #2 O(n) | O(n)
       Set<Integer> set = new HashSet<Integer>(); 
        for(int num : nums)
            set.add(num);
        int max = 0;
        
        for(int num : set){ // we dont need duplicates
            if(!set.contains(num - 1)){
                int streak = 1;
                while(set.contains(num++ + 1))
                    streak++;
                max = Math.max(max, streak);
            }
        }
        return max;
    
    }
}
