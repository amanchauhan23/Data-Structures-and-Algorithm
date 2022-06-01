public int[] runningSum(int[] nums) {
        
        int r[] = new int[nums.length];
        r[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            r[i] = nums[i]+r[i-1];
        }
        return r;
    }
