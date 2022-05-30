public int majorityElement(int[] nums) {
        // #1
        // Arrays.sort(nums); // O(nlogn)
        // return nums[nums.length/2];
        
        // #2 | Boyer-Moore Voting Algorithm | O(n) | O(1)
        int candidate = nums[0];
        int count = 0;
        for(int num : nums){
            if(candidate == num)
                count++;
            else
                count--;
            if(count==0){
                 candidate = num;
                count++;
            }
           
        }
        return candidate;
    }
