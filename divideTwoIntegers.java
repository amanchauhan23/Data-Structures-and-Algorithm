 public int divide(int dividend, int divisor) {
        // #1
        if (dividend == Integer.MIN_VALUE && divisor == -1) // edge case
            return Integer.MAX_VALUE;
        int quotient = 0;
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend - divisor >= 0) {
            int x = 0; // stores 2^x,
            while (dividend - (divisor << 1 << x) >= 0) // checking if, divisor*2*2*2.... can divide the dividend
                x++;
            quotient += 1 << x; // 1<<x, how many times the dividend can be divided, eg. 1<<2 (4), if, dividend
                                // can be divided by 3<<2 (12), 3 is divisor
            dividend -= divisor << x;
        }
        return sign == 1 ? quotient : (~quotient) + 1; // calculating 2's complement, if sign is -ve
 }
