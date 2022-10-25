// #2
class Solution {
    public int climbStairs(int n) {
        int []arr = new int[n+1];
        Arrays.fill(arr, -1);
        return helper(n, arr);
    }

    private int helper(int n, int arr[]){
        if(n < 0) return 0;
        if(n < 2) return 1;

        if(arr[n] != -1) return arr[n];

        arr[n] = helper(n-1, arr) + helper(n-2, arr);
        return arr[n];
    }

}

// #3
class Solution {
    public int climbStairs(int n) { //O(N)
        int one = 1;
        int two = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}
