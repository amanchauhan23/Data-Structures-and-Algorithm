class Solution {
    public void createBoard(char[][] c, List<List<String>> result) {
        ArrayList<String> ls = new ArrayList<>();
        for (char[] ds : c)
            ls.add(new String(ds));
        result.add(ls);
    }

    public void backTrack(int n, int r, char board[][], HashSet<Integer> col, HashSet<Integer> negDiagnols,
            HashSet<Integer> posDiagnols, List<List<String>> result) {
        if (r == n) {
            createBoard(board, result);
            return;
        }

        else {
            for (int c = 0; c < n; c++) {
                if (col.contains(c) || negDiagnols.contains(r - c) || posDiagnols.contains(r + c))
                    continue;
                col.add(c);
                negDiagnols.add(r - c);
                posDiagnols.add(r + c);
                board[r][c] = 'Q';

                backTrack(n, r + 1, board, col, negDiagnols, posDiagnols, result);

                col.remove(c);
                negDiagnols.remove(r - c);
                posDiagnols.remove(r + c);
                board[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> negDiagnols = new HashSet<>();
        HashSet<Integer> posDiagonals = new HashSet<>();
        char[][] board = new char[n][n];
        for (char[] cs : board)
            Arrays.fill(cs, '.');
        List<List<String>> result = new ArrayList<>();
        backTrack(n, 0, board, col, negDiagnols, posDiagonals, result);
        return result;
    }
}
