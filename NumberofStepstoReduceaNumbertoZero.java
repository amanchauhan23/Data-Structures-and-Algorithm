public int numberOfSteps(int num) {
        // #1 
        // int ans=0;
        // while(num!=0){
        //     if(num%2==0)
        //         num/=2;
        //     else
        //         num-=1;
        //     ans++;
        // }
        // return ans;
        
        // #2
        // int ans=0;
        // while(num!=0){
        //     if((num&1)==0)
        //         num=num>>1;
        //     else
        //         num-=1;
        //     ans++;
        // }
        // return ans;
        
        // #3 recursive
        return ans(num);
    }
    public int ans(int num){
        if(num==0)
            return 0;
       return ((num&1)==0)? 1 + ans(num/2) : 1 + ans(num-1);
    }
