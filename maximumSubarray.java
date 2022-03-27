public class maximumSubarray {

    public static int maxSubArray(int[] nums) {

        // efficient O(n) | Kadane's algo

        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            if (currentSum > max)
                max = currentSum;
        }
        return max;

        // variation in kadane's algo
        // int size = nums.length;
        // int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        // for (int i = 0; i < size; i++) {
        // max_ending_here = max_ending_here + nums[i];
        // if (max_so_far < max_ending_here)
        // max_so_far = max_ending_here;
        // if (max_ending_here < 0)
        // max_ending_here = 0;
        // }
        // return max_so_far;

        // #1 naive O(n2)
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if(sum > max)
        // max = sum;
        // }
        // }
        // return max;
    }

    public static void main(String[] args) {

    }
}
