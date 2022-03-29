class plusOne {
    public static int[] plusOnee(int[] digits) {
        for (int i = (digits.length - 1); i >= 0; i--) {
            if (1 + digits[i] < 10) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int r[] = new int[digits.length + 1];
        r[0] = 1;
        return r;
    }

    public static void main(String[] args) {
        int a[] = {9};
        int b[] = plusOnee(a);
        for (int  i : b) {
            System.out.println(i);
        }
    }
}
