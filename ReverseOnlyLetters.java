// #1
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for(int i = 0; i < s.length(); i++){
            char front = s.charAt(i);
            char back = 'a';
            if(j != -1)
                back = s.charAt(j);
            while(!Character.isLetter(back) && j-1 != -1){
                back = s.charAt(--j);
            } 
            if(Character.isLetter(front)){
                sb.append(back);
                j--;
            }else{
                sb.append(front);
            }
        }
        return sb.toString();
    }
}

// #2
class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() -1;
        
        char[] sChar = s.toCharArray();
        while(left < right){
            char c = sChar[left];
            char d = sChar[right];
            
            if(Character.isLetter(c) && Character.isLetter(d)){
                sChar[left] = sChar[right];
                sChar[right] = c;
                right--;
                left++;
            }else if(!Character.isLetter(c)){
                left++;
            }else if(!Character.isLetter(d)){
                right--;
            }
        }
        
        return new String(sChar);
        
    }
}
