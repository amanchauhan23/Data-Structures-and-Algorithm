class Solution {
    public double largestTriangleArea(int[][] points) {  // O(n^3) || O(1)
        double res = Double.MIN_VALUE;
        for(int i = 0; i < points.length; i++)
            for(int j = i + 1; j < points.length; j++)
                for(int k = j + 1; k < points.length; k++)
                    res = Math.max(res, findArea(points[i], points[j], points[k]));
                
        return res;
    }

    private double findArea(int [] x1, int [] x2, int [] x3){
        return Math.abs(0.5*((x1[0]*(x2[1] - x3[1])) + x2[0]*(x3[1] - x1[1]) + x3[0]*(x1[1]-x2[1])));
    }
}
