class Solution{
    static int minStep(int n){ // O(shortestPath) || O(shortestPath)
        //complete the function here
        if(n == 1) return 0;
        else if(n%3 == 0) return 1 + minStep(n/3);
        else return 1 + minStep(n - 1);
    }
}
