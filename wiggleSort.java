public static void wiggleSort(int[] arr) { // O(N) | O(1) 
    for(int i = 1; i< arr.length;i++){
            if((i%2==0 && arr[i]>arr[i-1])||(i%2==1 && arr[i]<arr[i-1])){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
    
  }
    }
