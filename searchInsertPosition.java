public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) { // binary search O(logN)
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        if (right < 0) {
            return 0;
        } else if (left == nums.length) {
            return nums.length;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {

    }
}
