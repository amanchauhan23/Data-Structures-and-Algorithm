class LongestSubArraywithSumK {
    public static int lenOfLongSubarr(int A[], int N, int k) { // O(n) | O(n)

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (hm.containsKey(sum - k)) {
                max = Math.max(max, (i - hm.get(sum - k)));
            }
            if (!hm.containsKey(sum))
                hm.put(sum, i);

        }
        return max;
    }
