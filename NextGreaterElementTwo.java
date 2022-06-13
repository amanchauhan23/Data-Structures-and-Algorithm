class Solution {
    public int[] nextGreaterElements(int[] nums) { // O(n) | O(n)
        
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[nums.length];
        int n = nums.length;
        
        for(int i = n*2 - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[i%n] >= s.peek())
                s.pop();
            if(i < n){
                if(s.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = s.peek();
            }
            s.push(nums[i%n]);
        }
        return ans;
    }
}
