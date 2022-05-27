public List<List<String>> groupAnagrams(String[] strs) {
     // #1
        // HashMap<HashMap<Character, Integer>, ArrayList<String>> hm = new HashMap<>();
        // for (String str : strs) {
        // HashMap<Character, Integer> h = new HashMap<>();
        // for (int i = 0; i < str.length(); i++) {
        // char ch = str.charAt(i);
        // h.put(ch, h.getOrDefault(ch, 0) + 1);
        // }
        // if (hm.containsKey(h)) {
        // hm.get(h).add(str);
        // } else {
        // hm.put(h, new ArrayList<String>(Arrays.asList(str)));
        // }
        // }
        // List<List<String>> ans = new ArrayList<>();
        // ans.addAll(hm.values());
        // return ans;

        // #2
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        for (String string : strs) {
            char[] ch = new char[26];
            for (int i = 0; i < string.length(); i++) {
                ch[string.charAt(i) - 'a']++;
            }
            String hashed = new String(ch);
            if (result.containsKey(hashed)) {
                result.get(hashed).add(string);
            } else {
                ArrayList<String> ad = new ArrayList<>();
                ad.add(string);
                result.put(hashed, ad);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (ArrayList<String> x : result.values())
            ans.add(x);
        return ans;
    }
