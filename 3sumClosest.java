// #1
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                System.out.println(sum);
                if (sum == target)
                    return sum;
                else if (sum < target) {
                    left++;
                } else
                    right--;
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    closest = sum;
                }
            }
        }
        return closest;
        
    }
}

// #2
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
    Arrays.sort(nums);
        int n = nums.length;
      
        if (nums[0] + nums[1] + nums[2] >= target)
            return nums[0] + nums[1] + nums[2];
        if (nums[n - 1] + nums[n - 2] + nums[n - 3] <= target)
            return nums[n - 1] + nums[n - 2] + nums[n - 3];
      
        int closest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
      
        for (int i = 0; i < n - 2; i++) {
          
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
          
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int mid = left + ((right - left) / 2);
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target)
                    return sum;
                else if (sum < target) {
                    if (mid != left && nums[i] + nums[right] + nums[mid] <= target) {
                        left = mid;
                    }
                    else{
                        while (++left < right && nums[left] == nums[left - 1]) {
                        ;
                    }
                    }

                } else {
                    if (mid != right && nums[i] + nums[left] + nums[mid] >= target)
                        right = mid;
                    else{
                        while (--right > left && nums[right] == nums[right + 1]) {
                        ;
                    }
                    } 
                }
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    closest = sum;
                }
            }
        }
        return closest;
        
    }
}
