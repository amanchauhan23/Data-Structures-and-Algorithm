class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int left = low - 1;
        int pivot = arr[high];
        for(int i = low; i < high; i++){
            if(arr[i] < pivot){
                left++;
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[++left];
        arr[left] = arr[high];
        arr[high] = temp;
        return left;
    } 
}
