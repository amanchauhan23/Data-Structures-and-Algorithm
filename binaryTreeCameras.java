// -1 for need
//  0 for has camera
//  1 for covered

class Solution { // O(n) | O(h)
    private int camera = 0;
    public int minCameraCover(TreeNode root) {
        int remainder = getStatus(root);
        if(remainder == -1){
            camera++;
        }
        return camera;
    }
    
    public int getStatus(TreeNode root){
        if(root == null){
            return 1;
        }
        int l = getStatus(root.left);
        int r = getStatus(root.right);
        
        if(l == -1 || r == -1){
            camera++;
            return 0;
        }else if(l == 0 || r == 0){
            return 1;
        }else{
            return -1;
        }
    }
    
}

