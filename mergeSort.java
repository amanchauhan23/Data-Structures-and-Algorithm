class Solution   // O(nlogn) || O(n)
{
    void merge(int arr[], int l, int m, int r)
    {
         int left[] = new int[m-l+1];
         int right[] = new int[r-m];
         for(int i = l; i <= m; i++) left[i-l] = arr[i];
         for(int i = m+1; i <= r; i++) right[i- m -1] = arr[i];
         
         int k = l;
         int leftI = 0;
         int rightI = 0;
         while(leftI < left.length && rightI < right.length){
             if(left[leftI] <= right[rightI]){
                 arr[k++] = left[leftI++];
             }else{
                 arr[k++] = right[rightI++];
             }
         }
         while(leftI < left.length){
             arr[k++] = left[leftI++];
         }
         while(rightI < right.length){
             arr[k++] = right[rightI++];
         }
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
}
