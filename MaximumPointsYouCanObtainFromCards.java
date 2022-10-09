// #1
// O(n) || O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int windSize = len - k;
        int sumWind = 0;
        int minGlobal = Integer.MAX_VALUE;
        for(int i = 0; i < windSize; i++)
            sumWind += cardPoints[i];
        int j = windSize;
        for(int i = 0; j < len; i++, j++){
            minGlobal = Math.min(minGlobal, sumWind);
            sumWind -= cardPoints[i];
            sumWind += cardPoints[j];
        }
        minGlobal = Math.min(minGlobal, sumWind);
        int total = 0;
        for(int i : cardPoints) total += i;
        return total - minGlobal;
    }
}


// #2
class Solution {
    public int maxScore(int[] cardPoints, int k) { // O(n) || O(1)

        int len = cardPoints.length;
        int windSize = len - k;
        int sumOut = 0;
        for(int i = windSize; i < len; i++)
            sumOut += cardPoints[i];
        int maxGlobal = sumOut;
        int j = windSize;
        for(int i = 0; j < len; i++, j++){
            sumOut += cardPoints[i];
            sumOut -= cardPoints[j];
            maxGlobal = Math.max(maxGlobal, sumOut);
        }

        return maxGlobal;
    }
}
