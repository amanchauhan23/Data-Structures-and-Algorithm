// best O(1) | avg O(log(log(n)) | worst O(n)
public static int interpolationSearch(int arr[], int lo,
                                          int hi, int x)
    {
        int pos;
 
        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
 
            // Probing the position with keeping
            // uniform distribution in mind.
            pos = lo
                  + (((hi - lo) / (arr[hi] - arr[lo]))
                     * (x - arr[lo]));
 
            // Condition of target found
            if (arr[pos] == x)
                return pos;
 
            // If x is larger, x is in right sub array
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi,
                                           x);
 
            // If x is smaller, x is in left sub array
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1,
                                           x);
        }
        return -1;
    }
