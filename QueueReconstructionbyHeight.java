class Solution {
    public int[][] reconstructQueue(int[][] people) { // O(nlogn + n^2) | O(n)
        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ll = new LinkedList<>();
        for(int [] i : people)
            ll.add(i[1], i);
        return ll.toArray(new int [people.length][2]);
    }
}
