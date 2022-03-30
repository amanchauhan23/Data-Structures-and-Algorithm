public class singleNumber {
    public int singleNumberr(int[] nums) {
        // HashSet<Integer> hs = new HashSet<>();
        // for (int index = 0; index < nums.length; index++) {
        // if (!hs.contains(nums[index])) {
        // hs.add(nums[index]);
        // } else {
        // hs.remove(nums[index]);
        // }
        // }
        // int out = 0;
        // Iterator<Integer> value = hs.iterator();
        // while (value.hasNext()) {
        // out = value.next();
        // }

        // return out;

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;

    }

    public static void main(String[] args) {
        System.out.println(0 ^ 2 ^ 2 ^ 3 ^ 4 ^ 3 ^ 4 ^ 6 ^ 4);
    }
}
