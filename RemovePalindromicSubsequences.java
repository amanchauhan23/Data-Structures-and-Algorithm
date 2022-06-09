class Solution {
    public int removePalindromeSub(String s) { //O(n)
       StringBuffer sb = new StringBuffer(s);
       sb.reverse();
       return sb.toString().equals(s)? 1:2;
    }
}
