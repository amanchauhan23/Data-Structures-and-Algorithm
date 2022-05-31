public boolean hasAllCodes(String s, int k) {
  
        // #1 | O(nk), k time to calculate hash| O((2^k)*K), n elements in hashSet and each is "K" in length, "k" is length of substring
        // HashSet<String> hs = new HashSet<>();
        // int distinct = 1 << k; // 2^k distinct code for length k, as every bit can be
        // 0 or 1
        // for (int i = 0; i < s.length() - k + 1; i++) {
        // String sub = s.substring(i, i + k);
        // if (!hs.contains(sub)) {
        // hs.add(sub);
        // distinct--;
        // if (distinct == 0)
        // return true;
        // }
        // }
        // return false;

        // #2 O(nk) | O(nk), k time to calculate hash | O(2^k)
        // int need = 1 << k;
        // boolean[] barr = new boolean[need];
        // for (int i = 0; i < s.length() - k + 1; i++) {
        // String sub = s.substring(i, i + k);
        // if (barr[Integer.parseInt(sub, 2)] == false) {
        // barr[Integer.parseInt(sub, 2)] = true;
        // need--;
        // }
        // if (need == 0)
        // return true;
        // }
        // return false;

        // #3 | optimal | O(n) | O(2^k)
        int need = 1 << k;
        boolean[] barr = new boolean[need];
        int hashVal = 0;
        int max = need - 1; // max element for length 'k' is, 2^k -1, as for length k = 3, max is, 111, or 2^k -1
        for (int i = 0; i < s.length(); i++) {
            hashVal = ((hashVal << 1) & max | s.charAt(i) - '0');
            if (i >= k - 1 && !barr[hashVal]) {
                barr[hashVal] = true;
                need--;
                if (need == 0)
                    return true;
            }
        }
        return false;            
  
    }
