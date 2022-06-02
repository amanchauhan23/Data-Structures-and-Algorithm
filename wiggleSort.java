public void wiggleSort(int[] nums) {
        // write your code here
        for(int i = 1; i< nums.length;i++){
            if(i%2==0 && nums[i]>nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
             if(i%2==1 && nums[i]<nums[i-1]){
                 int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
