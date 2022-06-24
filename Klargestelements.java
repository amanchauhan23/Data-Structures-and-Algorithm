class comp implements Comparator<Integer>{
    public int compare(Integer parent, Integer child){
        if(parent < child)
            return 1;
        else
            return -1;
    }
}

class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k) // O(nlogn + klogn) | O(n)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new comp());
        for(int i = 0; i < arr.length; i++){
            pq.offer(arr[i]);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ls.add(pq.poll());
        }
        return ls;
    }
}
