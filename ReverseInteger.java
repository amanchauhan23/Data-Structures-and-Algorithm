public int reverse(int x) {
        // #1
        // String ans = "";
        // if(x<0){
        //     ans+="-";
        //     x*=-1;
        // }
        // int temp = x;
        // while(temp!=0){
        //     int strip = temp%10;
        //     temp/=10;
        //     ans+=String.valueOf(strip);
        // }
        // try{
        //     int retrn = Integer.parseInt(ans); //NumberFormatException
        //     return retrn;
        // }catch(Exception e){ 
        //     return 0;
        // }
        
        // #2
        long ans = 0;
        while(x!=0){
            ans = ans*10 + x%10;
            x/=10;
        }
        return (ans>Integer.MAX_VALUE | ans<Integer.MIN_VALUE)? 0:(int)ans;
        
    }
