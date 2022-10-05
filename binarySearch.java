class Solution {
    int binarysearch(int arr[], int n, int k) { // O(logN) | O(1)
        
        int l = 0;
        int h = arr.length - 1;
        
        while(l <= h){
            int mid = l + (h - l)/2;
            
            if(arr[mid] == k) return mid;
            if(arr[mid] > k) h = mid - 1;
            else l = mid + 1;
            
        }
        
        return -1;
        
    }
}
