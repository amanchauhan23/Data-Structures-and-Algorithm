public int hammingWeight(int n) {
        // #1 
        // String s = Integer.toBinaryString(n);
        // int count = 0;
        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i)=='1')
        //         count++;
        // }
        // return count;
        
        // #2 | O(number of '1' bit)
        int count = 0;
        while(n!=0){
             n = n & (n - 1);
             count++;
        }
        return count;
        
        // #3 | O(n)
        // int count = 0;
        // while(n!=0){
        //     if((n&1)==1)
        //         count++;
        //     n=n>>>1;
        // }
        // return count;
    }
