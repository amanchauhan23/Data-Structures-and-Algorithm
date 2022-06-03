class findFrequency { // O(2*logn)
    public static int FirstOccurence(int[] n, int k) {
        int l = 0;
        int r = n.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (n[mid] < k) {
                l = mid + 1;
            } else if (n[mid] > k) {
                r = mid - 1;
            } else {
                if (mid == 0 || n[mid - 1] < k)
                    return mid;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    public static int LastOccurence(int[] n, int k) {
        int l = 0;
        int r = n.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (n[mid] < k) {
                l = mid + 1;
            } else if (n[mid] > k) {
                r = mid - 1;
            } else {
                if (mid == n.length - 1 || n[mid + 1] > k)
                    return mid;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ar[] = new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 6 }; // sorted array
        int l = FirstOccurence(ar, 2);
        int r = LastOccurence(ar, 2);
        System.out.println("Frequency is: " + (r - l + 1));
    }
}
