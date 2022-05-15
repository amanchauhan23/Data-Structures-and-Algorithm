public static double sqrt(float n) {

        float x = n;
        float y = 1;

        // e decides the accuracy level
        double e = 0.000001;
        while (Math.abs(x - y) > e) {
            x = (x + y) / 2;
            y = n / x;
        }
        return x;
    }
