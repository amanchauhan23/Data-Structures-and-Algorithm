// O(n) || o(n)
class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int [] lmax = new int[n];
        int [] rmax = new int[n];

        lmax[0] = arr[0];
        for(int i = 1; i < n; i++)
            lmax[i] = Math.max(lmax[i-1], arr[i]);

        rmax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--)
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        
        int water = 0;
        for(int i = 1; i < n - 1; i++){
            water += Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return water;
    }
}

// O(n) || O(1)
class Solution {
    public int trap(int[] arr) {

        int n = arr.length;
        int left = 0, right = n-1;
        int lmax = arr[0], rmax = arr[n-1], water = 0;

        while(left < right){
            if(lmax < rmax){
                water += lmax - arr[left++];
                lmax = Math.max(lmax, arr[left]);
            }else{
                water += rmax - arr[right--];
                rmax = Math.max(rmax, arr[right]);
            }
        }

        return water;
    }
}
