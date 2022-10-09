class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(n);
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
            if(n == 0 && sum == 1)
                return true;
            if(n == 0){
                n = sum;
                sum = 0;
                if(!hs.add(n)) return false;
            }
                
        }
        return false;
    }
}
