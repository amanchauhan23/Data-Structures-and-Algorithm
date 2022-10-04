class Solution{ // O(n) || O(1)
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        
        int max = Integer.MIN_VALUE;
        
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] >= max)
                ls.add(arr[i]);
            max = Math.max(arr[i], max);
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = ls.size() - 1; i >= 0; i--)
            ans.add(ls.get(i));
        
        return ans;
    }
}
