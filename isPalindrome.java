public static boolean isPalindrome(String s) {
        // #1
        // s = s.toLowerCase();
        // StringBuilder newS = new StringBuilder("");
        // StringBuilder newSB = new StringBuilder("");
        // for (int i = 0; i < s.length(); i++) {
        // if ((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= '0' &&
        // s.charAt(i) <= '9')) {
        // newS.insert(newS.length(), s.charAt(i));
        // newSB.insert(0, s.charAt(i));
        // }
        // }
        // return newSB.toString().equals(newS.toString());

        // #2
        s = s.toLowerCase();
        String regex = "[^a-z^0-9]";
        String newS = s.replaceAll(regex, "");
        int length = newS.length();
        for (int i = 0; i < length / 2; i++) {
            if (newS.charAt(i) != newS.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
