import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class THREEsum {

    public static List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> lit = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[left]);
                    l.add(nums[right]);
                    l.add(nums[i]);
                    Collections.sort(l);
                    lit.add(l);
                    right--;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lit;

    }

    public static void main(String[] args) {
        List<List<Integer>> l = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        for (List<Integer> list : l) {
            for (Integer list2 : list) {
                System.out.print(list2 + " ");
            }
            System.out.println();
        }

    }
}
