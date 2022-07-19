class Solution
{
	public int minDeletions(int arr[], int n)  // O(nlogn) | O(n) || variation of LIS
	{ 
	   if(arr.length == 0)
	        return 0;
	   ArrayList<Integer> ls = new ArrayList<>();
	   ls.add(arr[0]);
	   for(int i = 1; i < arr.length; i++){
	       if(ls.get(ls.size() - 1) < arr[i]){
	           ls.add(arr[i]);
	       }else{
	           int index = Collections.binarySearch(ls, arr[i]);
	           if(index < 0)
	                index = Math.abs(index) - 1;
	           ls.set(index, arr[i]);
	       }
	   }
	   return arr.length - ls.size();
	} 
}
