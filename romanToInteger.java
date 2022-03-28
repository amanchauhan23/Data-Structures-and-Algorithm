import java.util.HashMap;

public class romanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int fin = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 1001;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            fin += cur;
            if (prev < cur) {
                fin -=2 * prev;
            }
            prev = cur;
        }
        return fin;
    }

    public static void main(String[] args) {

    }
}
