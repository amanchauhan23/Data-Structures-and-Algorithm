class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) { // O(N!) | O(N)
        List<Integer> ls = new ArrayList<>();
        permutation(0, nums, ls);
        return ans;
    }
    
    void permutation(int i, int nums[], List<Integer> ls){
        
        if(i == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            ls.add(nums[i]);
            permutation(i+1, nums, ls);
            ls.remove(ls.size()-1);
            swap(nums, i, j);
        }
        
    }
    
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
