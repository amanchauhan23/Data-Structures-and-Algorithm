import java.util.Arrays;

class kthSmallestInArray {

    public static int getSmallerThanEqualsTo(int a[], int num) {
        int count = 0;
        if (a.length == 0)
            return -1;
        for (int i = 0; i < a.length; i++)
            if (a[i] <= num)
                count++;
        return count;
    }

    public static int ksmallest(int a[], int k) { // O(nlog(max-min)) | O(1) || or sort array in O(nlogn) and return
                                                  // a[k-1]th ele
        int left = Arrays.stream(a).min().getAsInt();
        int right = Arrays.stream(a).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int els = getSmallerThanEqualsTo(a, mid);
            if (els < k)
                left = mid + 1;
            else {
                int elsMinusOne = getSmallerThanEqualsTo(a, mid - 1);
                if (elsMinusOne < k)
                    return mid;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 40, 10, 10, 30, 40, 40, 50, 50, 90 };
        System.out.println(ksmallest(input, 6));
    }
}
