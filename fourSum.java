class Solution {
public List<List<Integer>> fourSum(int[] nums, int target) { // O(N^3)
       Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j != i+1 && j < nums.length - 2 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> ls = new ArrayList<Integer>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[left]);
                        ls.add(nums[right]);
                        ans.add(ls);
                        right--;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
            }
        }
        return ans;
    }
}
