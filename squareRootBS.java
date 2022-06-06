public class squareRootBS { // O(logn) | O(1) | return abs if perfect sqr doesnt exist
    int find(int n) {

        if (n < 0)
            return n;

        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > n) {
                right = mid - 1;
            } else {
                int val = (mid + 1) * (mid + 1);
                if (val > n)
                    return mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var obj = new squareRootBS();
        System.out.println(obj.find(64));
    }
}
