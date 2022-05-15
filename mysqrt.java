public static int mySqrt(int x) { // Babylonian Method
        if (x == 1)
            return 1;
        double guess = x / 2;
        double byNumber = x / guess;
        double avg = (guess + byNumber) / 2;

        while (((int) avg) != ((int) guess) || ((int) guess) != ((int) byNumber)) { // intrested only in the integer
                                                                                    // part
            guess = avg;
            byNumber = x / guess;
            avg = (byNumber + guess) / 2;
        }
        return (int) avg;
    }
