class longestCommonPrefix {
    public static String longestCommonPrefixx(String[] strs) {
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (s != "") {
                if (strs[i].startsWith(s)) {
                    break;
                }
                s = s.substring(0, s.length() - 1);
            }
            if (s.equals(""))
                return s;

        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixx(new String[] { "cir", "car" }));
    }
}
