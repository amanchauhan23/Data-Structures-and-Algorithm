class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}

class GfG
{ 
    int maxChainLength(Pair arr[], int n) // O(n^2) 
    {
       
       List<Pair> ls = new ArrayList<>();
       for(Pair i : arr){
           ls.add(i);
       }
       
       Collections.sort(ls, new CompareByFirst());
       
       int dp[] = new int[n];
       
       for(int i = 0; i < n; i++){
           dp[i] = 1;
           for(int j = 0; j < i; j++){
                if(ls.get(j).y < ls.get(i).x)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
           }
       }
       
       int ans = 0;
       for(int i : dp)
            ans = Math.max(ans, i);
    
       return ans;
       
       
    }
}
