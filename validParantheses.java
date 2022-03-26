import java.util.*;

public class validParentheses {
    public static void main(String[] args) {
        String s = "()";
        Stack<Character> stck = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stck.push(c);
            } else {
                if (stck.pop() != c) {
                    System.out.println("fail");
                    
                }
            }
        }

        System.out.println("pass");
    }
}
