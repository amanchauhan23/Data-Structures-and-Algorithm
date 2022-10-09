// NICE
// #1 || O(log(num)) -> number of digits || O(1) 
class Solution {
    public int maximum69Number (int num) {
        return Integer.parseInt((""+num).replaceFirst("6", "9"));
    }
}

// #2
class Solution {
    public int maximum69Number (int num) {
        char [] nums = String.valueOf(num).toCharArray();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == '6'){
                nums[i] = '9'; 
                return Integer.parseInt(String.valueOf(nums));
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }
}
