// #1 || O(n log log n) || O(n) || Sieve Of Eratosthenes 
class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean sieve[] = new boolean[n];
        int ans = 0;
        for(int i = 2; i*i < n; i++){
            if(isPrime(i)){
                for(int j = i*2; j < n; j = j + i){
                    sieve[j] = true;
                }
            }
        }

        for(int i = 2; i < n; i++){
            if(!sieve[i]) ans++;
        }
        
        return ans;
    }

    private boolean isPrime(int num){
        int upper = (int)Math.sqrt(num);
        for(int i = 2; i <= upper; i++)
            if(num%i == 0) return false;
        return true;
    }
}
