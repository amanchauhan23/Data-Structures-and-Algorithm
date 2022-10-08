class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) { //O(log(min(m,n))) || O(1)

        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y  = nums2.length;

        int low = 0;
        int high = x;

        while(low <= high){

            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxleftX = (partitionX == 0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minrightX = (partitionX == x)? Integer.MAX_VALUE : nums1[partitionX];
            int maxleftY = (partitionY == 0)? Integer.MIN_VALUE : nums2[partitionY-1];
            int minrightY = (partitionY == y)? Integer.MAX_VALUE : nums2[partitionY];

            if(maxleftX <= minrightY && maxleftY <= minrightX){
                if((x+y)%2 == 0)
                    return (double)(Math.max(maxleftX, maxleftY) + Math.min(minrightX, minrightY))/2;
                else
                    return (double)Math.max(maxleftX, maxleftY);
            }else if(maxleftX > minrightY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }    
        return -1;
    }

}
