import java.util.HashMap;

class twoSum {

    public int[] twoSum2(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                ans[0] = hm.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            hm.put(nums[i], i);
        }
        return new int[] { -1 };

    }

    public static void main(String[] args) {

    }
}
