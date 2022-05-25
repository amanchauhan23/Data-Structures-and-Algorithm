public int lengthOfLastWord(String s) {
        boolean end=false;
        int ans=0;
       for(int i = s.length()-1; i>=0;i--){ // worst O(N)
            if(s.charAt(i)!=' ')
                end = true;
           if(end){
               if(s.charAt(i)==' ')
                   break;
               ans++;
           }
       }
        return ans;
    }
