//  #1
class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2);
        HashSet<Character> hs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')); 
        int count = 0;
        for(int i = 0; i < s.length()/2; i++){
            if(hs.contains(a.charAt(i))) count++;
            if(hs.contains(b.charAt(i))) count--;
        }
        return count == 0;
    }
}

// #2
class Solution {
    public boolean halvesAreAlike(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2, s.length());

        int vowelFirst = countVowels(firstHalf);
        int vowelSecond = countVowels(secondHalf);

        return vowelFirst == vowelSecond;
    }

    private int countVowels(String s) {
        int numVowels = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isUpper = c >= 'A' && c <= 'Z';
            if(isUpper) c = (char)(c - 'A' + 'a');

            if(c == 'a') numVowels++;
            else if(c == 'e') numVowels++;
            else if(c == 'i') numVowels++;
            else if(c == 'o') numVowels++;
            else if(c == 'u') numVowels++;
        }

        return numVowels;
    }
}
