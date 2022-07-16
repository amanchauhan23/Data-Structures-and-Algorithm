class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) // O(nlogn) | O(n)
    {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : arr)
            pq.add(i);
        long sum = 0;
        while(pq.size()>1){
            long temp = 0;
            temp += pq.poll();
            temp += pq.poll();
            sum += temp;
            pq.add(temp);
        }
        return sum;
    }
}
