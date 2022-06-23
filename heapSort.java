class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        for(int i = (n-2)/2; i >= 0; i--){ // starting from non-leaf nodes
            heapify(arr, n, i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        if(i > (n-2)/2) // ignore leaf nodes
            return;
        int max = i;
        if(((i*2) + 1) < n)
            if(arr[(i*2) + 1] > arr[i])
                max = (i*2) + 1;
        if((i*2) + 2 < n)
            if(arr[(i*2) + 2] > arr[max])
                max = (i*2) + 2;
        
        if(max != i){
            swap(arr, i, max);
            heapify(arr, n, max);
        }
        
    }
    
    void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        buildHeap(arr, n); // O(N)

      for(int i = n-1; i > 0; i--){ // O(NlogN)
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }
 }
