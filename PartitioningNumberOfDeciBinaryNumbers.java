class Solution {
    public int minPartitions(String n) { // O(log(n)) | O(digit.length) | aux O(1)
        // #1
        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i < n.length(); i++){
        //     if(max < n.charAt(i) - 48)
        //         max = n.charAt(i) - 48;
        // }
        // return max;
        
        // #2
        int max = 0;
        for(int i = 9; i >= 1; i--){
            if(n.contains(String.valueOf(i))){
                max = i;
                break;
            }
                
        }
        return max;
    }
  
}
