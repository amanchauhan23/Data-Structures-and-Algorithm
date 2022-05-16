public static int climbStairs(int n) {
        // #1 | O(2^N)
        // if (n < 0) {
        // return 0;
        // }
        // if (n == 0) {
        // return 1;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // #2 | O(N) DP
        int one = 1;
        int two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
