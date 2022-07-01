class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) { // O(n) | O(1)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        for(int i = 0; i < boxTypes.length; i++){
            int box = boxTypes[i][0];
            if((truckSize - box) > 0){
                truckSize -= box;
                units += box*boxTypes[i][1];
            }else{
                for(int j = 0; j < box; j++){
                if(truckSize == 0)
                    return units;
                truckSize--;
                units += boxTypes[i][1];
            }
          }
        }
        
        return units;
    }
}
