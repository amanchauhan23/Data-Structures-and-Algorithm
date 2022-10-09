// #1 || Naive
class Solution {
    public int addDigits(int num) {
        int s = 0;
        if(num < 10)
            s = num;
        else{
            while(num > 0){
                s += num%10;
                num /= 10;
                if(num == 0 && s > 9){
                    num = s;
                    s = 0;
                }
            }
        }
        return s;
    }
}

// #2 || optimized || https://en.wikipedia.org/wiki/Digital_root
class Solution { // O(1)
    public int addDigits(int num) {
        if(num != 0 && num % 9 == 0) return 9;
        return num%9;
    }
}
