class Solution {
    public boolean areNumbersAscending(String s){
        int prev = Integer.MIN_VALUE;
        String[] sent = s.split(" ");
        
        for(String i: sent){
            if(Character.isDigit(i.charAt(0))){
                int num = Integer.parseInt(i);
                if(num <= prev) return false;
                else prev = num;
            }
        }
        return true;
    }
}
