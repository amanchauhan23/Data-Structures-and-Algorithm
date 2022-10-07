class Solution { // O(nlogn) || O(1)
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int arr[], int l, int r){ 
        if(l < r){
            int pivot = lomuto(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    private int lomuto(int arr[], int l, int r){

        int left = l - 1;
        int randIndex = (int)(Math.random()*(r - l)) + l;
        int tem = arr[randIndex];
        arr[randIndex] = arr[r];
        arr[r] = tem; 
        int pivot = arr[r];
        for(int i = l; i < r; i++){
            if(arr[i] < pivot){
                left++;
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp; 
            }
        }
        arr[r] = arr[++left];
        arr[left] = pivot;
        return left;
    }
}
