import java.util.HashMap;

class gridIllumination {

    public int[] gridIlluminationn(int n, int[][] lamps, int[][] queries) {// O(n) where, n = Max(lamps.len,Quer.len) |
                                                                           // auxSpace O(n^2) n - input grid size
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> diaN = new HashMap<>();
        HashMap<Integer, Integer> diaP = new HashMap<>();
        HashMap<Integer, Integer> cell = new HashMap<>();

        for (int i = 0; i < lamps.length; i++) {
            int r = lamps[i][0];
            int c = lamps[i][1];
            int cellNo = r * n + c;
            if (cell.containsKey(cellNo) == false) {
                row.put(r, row.getOrDefault(r, 0) + 1);
                col.put(c, col.getOrDefault(c, 0) + 1);
                diaN.put(r - c, diaN.getOrDefault(r - c, 0) + 1);
                diaP.put(r + c, diaP.getOrDefault(r + c, 0) + 1);
                cell.put(cellNo, cell.getOrDefault(cellNo, 0) + 1);
            }

        }

        int[][] direction = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 },
                { 0, 0 }
        };
        int ans[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            ans[i] = (row.containsKey(r) || col.containsKey(c) || diaN.containsKey(r - c) || diaP.containsKey(r + c))
                    ? 1
                    : 0;

            for (int j = 0; j < direction.length; j++) {

                int DirectionR = r + direction[j][0];
                int DirectionC = c + direction[j][1];
                int DirectionCellNo = DirectionR * n + DirectionC;
                if (DirectionR >= 0 && DirectionR < n && DirectionC >= 0 && DirectionC < n) {
                    if (cell.containsKey(DirectionCellNo)) {

                        int val = cell.get(DirectionCellNo);
                        cell.remove(DirectionCellNo);

                        if (row.containsKey(DirectionR)) {
                            int rowVal = row.get(DirectionR);
                            rowVal -= val;

                            if (rowVal == 0)
                                row.remove(DirectionR);
                            else
                                row.put(DirectionR, rowVal);
                        }
                        if (col.containsKey(DirectionC)) {
                            int colVal = col.get(DirectionC);
                            colVal -= val;
                            if (colVal == 0)
                                col.remove(DirectionC);
                            else
                                col.put(DirectionC, colVal);
                        }
                        if (diaN.containsKey(DirectionR - DirectionC)) {
                            int diaVal = diaN.get(DirectionR - DirectionC);
                            diaVal -= val;

                            if (diaVal == 0)
                                diaN.remove(DirectionR - DirectionC);
                            else
                                diaN.put(DirectionR - DirectionC, diaVal);
                        }
                        if (diaP.containsKey(DirectionR + DirectionC)) {
                            int diaVal = diaP.get(DirectionR + DirectionC);
                            diaVal -= val;
                            if (diaVal == 0)
                                diaP.remove(DirectionR + DirectionC);
                            else
                                diaP.put(DirectionR + DirectionC, diaVal);
                        }
                    }
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
