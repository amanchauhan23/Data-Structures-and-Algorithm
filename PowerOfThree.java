// #1 Recursion
class Solution {
    public boolean isPowerOfThree(int n) { // O(log₃N) || O(1)
        if(n == 1) return true;
        if(n < 1) return false;
        if(n%3 != 0) return false;
        return isPowerOfThree(n/3);
    }
}

// #2 Using Loop
class Solution {
    public boolean isPowerOfThree(int n) {  // O(log₃N) || O(1)
        if(n < 1) return false;
        while(n%3 == 0){
            n = n/3;
        }
        return n == 1;
    }
}

// #3
class Solution {
    public boolean isPowerOfThree(int n) {  // O(1) || O(1)
        return (n > 0 && 1162261467 % n == 0);
    }
}
