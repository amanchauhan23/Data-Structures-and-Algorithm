public boolean isIdealPermutation(int[] nums) { // O(N)
         if (nums.length <= 2)
            return true;
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max)
                return false;
            max = Math.max(max, nums[i-1]);
        }
        return true;
    }
