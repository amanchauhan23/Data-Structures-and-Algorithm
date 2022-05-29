public int maxProduct(String[] words) { // O(n*m + n*n) | auxSpace O(n)
        int max = 0;
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray())
                mask[i] |= 1 << (c - 'a'); // setting the "Set bit" at respective positions
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < mask.length; j++)
                if ((mask[i] & mask[j]) == 0) // checking if there are any common letters, O(1)
                    max = Math.max(max, words[i].length() * words[j].length());
        }
        return max;
    }
