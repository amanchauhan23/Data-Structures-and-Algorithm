import java.util.HashSet;

public class longestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> hset = new HashSet<>();

        while (right < s.length()) {
            if (!hset.contains(s.charAt(right))) {
                hset.add(s.charAt(right++));
                ans = Math.max(ans, hset.size());
            } else {
                hset.remove(s.charAt(left++));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
