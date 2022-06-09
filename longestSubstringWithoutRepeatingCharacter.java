import java.util.HashSet;

public class longestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        // #1
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
        
        // #2
        int ans = 0;
        int left = 0;
        int right = 0;
        char[] ch = new char[256];
        while (right < s.length()) {
            if (ch[s.charAt(right)]==0) {
                ch[s.charAt(right)]++;
                ans = Math.max(ans, right-left+1);
                right++;
            } else {
                ch[s.charAt(left++)]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
