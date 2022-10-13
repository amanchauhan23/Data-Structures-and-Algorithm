class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) { // O(n^2) | O(1)
        int count = 0;
        boolean b;
        for(int i = 0; i < arr1.length; i++){
            b = true;
            for(int j = 0; j < arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    b = false;
                    break;
                }
            }
            if(b) count++;
        }
        return count;
    }
}
