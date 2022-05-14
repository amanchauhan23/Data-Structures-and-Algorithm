public String toHex(int num) {
        // #1
        // String s = Integer.toBinaryString(num);
        // String ans = "";
        // char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
        // for (int i = s.length() - 1; i >= 0; i = i - 4) {
        // String temp = "";
        // for (int j = i; j >= i - 3 && j >= 0; j--) {
        // temp = s.charAt(j) + temp;
        // }
        // int n = Integer.parseInt(temp, 2);
        // if (n > 9) {
        // ans = ch[n % 10] + ans;
        // } else {
        // ans = Integer.toString(n) + ans;
        // }
        // }
        // return ans;

        // #2 || efficient
        // if (num == 0)
        // return "0";
        // char ch[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
        // 'c', 'd', 'e', 'f' };
        // String ans = "";
        // while (num != 0) {
        // ans = ch[num & 15] + ans;
        // num = num >>> 4;
        // }
        // return ans;

        // #3 || most efficient
        if (num == 0)
            return "0";
        char ch[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            ans.insert(0, ch[num & 15]);
            num = num >>> 4;
        }
        return ans.toString();
    }
