public class sumArrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        int l = 0;
        int r = 0;
        int curSum = arr[0];
        while (r < n) {
            if (curSum == s) {
                ls.add(l + 1);
                ls.add(r + 1);
                return ls;
            } else if (curSum < s) {
                r++;
                if (r < n)
                    curSum += arr[r];
            } else {
                curSum -= arr[l++];

            }
        }
        ls.add(-1);
        return ls;
    }
