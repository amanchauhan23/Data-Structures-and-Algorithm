// #1 ||  Naive
import java.math.BigInteger; 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while(l1 != null){
            num1.append(String.valueOf(l1.val));
            l1 = l1.next;
        }

        while(l2 != null){
            num2.append(String.valueOf(l2.val));
            l2 = l2.next;
        }

        num1.reverse();
        num2.reverse();

        BigInteger bi1 = new BigInteger(num1.toString()); 
        BigInteger bi2 = new BigInteger(num2.toString());

        BigInteger res = bi1.add(bi2);

        ListNode ln = new ListNode();
        ListNode ans = ln;

        while(res.compareTo(new BigInteger("0")) != 0){
            BigInteger intValue = res.mod(new BigInteger("10"));
            ans.val = intValue.intValue();
            res = res.divide(new BigInteger("10"));
            if(res.compareTo(new BigInteger("0")) != 0) ans.next = new ListNode();
            ans = ans.next;
        }

        return ln;

    }
}
