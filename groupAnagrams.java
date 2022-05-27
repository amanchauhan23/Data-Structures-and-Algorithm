public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<HashMap<Character, Integer>, ArrayList<String>> hm = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> h = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                h.put(ch, h.getOrDefault(ch, 0) + 1);
            }
            if (hm.containsKey(h)) {
                hm.get(h).add(str);
            } else {
                hm.put(h, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (ArrayList<String> string : hm.values()) {
            ans.add(string);
        }
        return ans;
    }
