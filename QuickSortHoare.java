
class Solution     // O(nlogn)|| O(1) 
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
        
    }
    static int partition(int arr[], int low, int high)
    {
        
        int pivot = arr[low];
        int left = low-1;
        int right = high+1;
        
        while(true){
            
            do{
                left++;        
            }while(arr[left] < pivot);
            
            do{
                right--;
            }while(arr[right] > pivot);
            
            if(left >= right) return right;
            
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
        }
        
    } 
}
