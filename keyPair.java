class Solution {
   boolean hasArrayTwoCandidates(int arr[], int n, int x) {
    // code here
    HashSet<Integer> h = new HashSet<>();
    for(int i= 0; i< arr.length; i++){
        if(h.contains(x-arr[i]))
            return true;
        else
             h.add(arr[i]);
       
    }
    return false;
}
}
