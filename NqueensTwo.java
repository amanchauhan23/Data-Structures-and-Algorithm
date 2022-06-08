class Solution { //backtracking
    private int ans = 0;

    public void backTracking(int n, int r, HashSet<Integer> col, HashSet<Integer> posDiagonal,
            HashSet<Integer> negDiagonal) {
        if (r == n) {
            ans++;
            return;
        } else {
            for (int c = 0; c < n; c++) {
                if (col.contains(c) || posDiagonal.contains(r + c) || negDiagonal.contains(r - c)) {
                    continue;
                }
                col.add(c);
                posDiagonal.add(r + c);
                negDiagonal.add(r - c);

                backTracking(n, r + 1, col, posDiagonal, negDiagonal);

                col.remove(c);
                posDiagonal.remove(r + c);
                negDiagonal.remove(r - c);
            }
        }
    }

    public int totalNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posDiagonal = new HashSet<>();
        HashSet<Integer> negDiagonals = new HashSet<>();

        backTracking(n, 0, col, posDiagonal, negDiagonals);

        return ans;
    }
}
