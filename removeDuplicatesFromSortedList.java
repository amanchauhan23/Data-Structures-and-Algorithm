public class removeDuplicatesFromSortedList {

    public static int removeDuplicates(int[] nums) {
        int num = nums[0];
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                num = nums[i];
                nums[r] = num;
                r++;
            }
        }
        if (nums.length == 0)
            return 0;
        return r;
        }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{5}));
    }
}
