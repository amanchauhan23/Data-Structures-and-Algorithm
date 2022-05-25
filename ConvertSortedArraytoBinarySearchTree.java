public TreeNode sortedArrayToBST(int[] nums) { // O(N) || aux Space O(H)
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int num[], int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode head = new TreeNode(num[mid], helper(num, left, mid-1), helper(num, mid+1, right));
        return head;
    }
