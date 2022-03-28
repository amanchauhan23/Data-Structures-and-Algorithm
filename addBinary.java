public class addBinaryy {
    public static String addBinary(String a, String b) {

        // #1 with stringBuilder
        StringBuilder ans = new StringBuilder(); // O(n+m) | auxSpace O(1)
        int carry = 0, sum;
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;

        while (aLen >= 0 || bLen >= 0) {
            sum = carry;
            if (aLen >= 0) {
                sum += a.charAt(aLen--) - '0';
            }
            if (bLen >= 0) {
                sum += b.charAt(bLen--) - 48; // 48 is ascii for '0'
            }
            ans.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            ans.append(carry);
        return ans.reverse().toString();

        // #2 without StringBuilder()
        // O(n+m) | auxSpace O(1)
        // String ans = "";
        // int carry = 0, sum;
        // int aLen = a.length() - 1;
        // int bLen = b.length() - 1;

        // while (aLen >= 0 || bLen >= 0) {
        // sum = carry;
        // if (aLen >= 0) {
        // sum += a.charAt(aLen--) - '0';
        // }
        // if (bLen >= 0) {
        // sum += b.charAt(bLen--) - 48; // 48 is ascii for '0'
        // }

        // ans = String.valueOf(sum % 2) + ans;
        // carry = sum / 2;
        // }
        // if (carry != 0)
        // ans = String.valueOf(carry) + ans;

        // return ans;

        // #3 works for small inputs
        // if (a.equals("0") && b.equals("0"))
        // return "0";
        // int aNum = Integer.parseInt(a, 2);
        // int bNum = Integer.parseInt(b, 2);
        // int sumNum = aNum + bNum;
        // String ans = "";
        // while (sumNum > 0) {
        // int reminder = sumNum % 2;
        // sumNum /= 2;
        // System.out.println(reminder);
        // ans = String.valueOf(reminder) + ans;
        // }

        // return ans;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
