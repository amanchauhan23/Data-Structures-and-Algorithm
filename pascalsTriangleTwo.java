public List<Integer> getRow(int rowIndex) {
        // #1 O(N^2)
        // List<Integer> buffer = new ArrayList<Integer>();
        // List<Integer> ans = new ArrayList<Integer>();

        // buffer.add(1);
        // ans.add(1);

        // for (int i = 0; i < rowIndex; i++) {
        // ans.clear();
        // ans.add(1);
        // for (int j = 0; j < buffer.size() - 1; j++) {
        // ans.add(buffer.get(j) + buffer.get(j + 1));
        // }
        // ans.add(1);
        // buffer.clear();
        // buffer = ans;
        // }
        // return ans;

        // #2 optimized || O(N)
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0)
            return ans;
        int f = rowIndex;
        int s = 1;
        long result = 1;
        for (int i = 1; i < rowIndex; i++) { //using formula for direct element calculation, rCc, where r is row c is col.
            result *= f--;
            result /= s++;
            ans.add((int) result);
        }
        ans.add(1);
        return ans;
    }
