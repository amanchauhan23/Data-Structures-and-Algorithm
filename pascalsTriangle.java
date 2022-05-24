 public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1)
            return outer;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> add = new ArrayList<>();
            int elements = outer.get(i - 2).size();
            add.add(1);
            for (int j = 0; j < elements - 1; j++) {
                add.add(outer.get(i - 2).get(j) + outer.get(i - 2).get(j + 1));
            }
            add.add(1);
            outer.add(add);
        }
        return outer;

    }
