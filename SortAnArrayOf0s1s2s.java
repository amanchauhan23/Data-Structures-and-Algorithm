// O(n) | O(1)
// #1 | using 2 travesals
class Solution
{
    public static void sort012(int a[], int n)
    {
        
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i : a){
            if(i == 0) zero++;
            else if(i == 1) one++;
            else two++;
        }
        
        int index = 0;
        for(int i = 0; i < zero; i++)
            a[index++] = 0;
        for(int i = 0; i < one; i++)
            a[index++] = 1;
        for(int i = 0; i < two; i++)
            a[index++] = 2;

    }
}

// #2 || single traversal
class Solution
{
    public static void sort012(int a[], int n)
    {
        
        int low = 0;
        int high = a.length - 1;
        int i = 0;
        
        while(i <= high){
            if(a[i] == 0){
                a[i] = a[low];
                a[low++] = 0;
                i++;
            }
            else if(a[i] == 1) i++;
            else{
                a[i] = a[high];
                a[high--] = 2;
            }
        }

    }
}
