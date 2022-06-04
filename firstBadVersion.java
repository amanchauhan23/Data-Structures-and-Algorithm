 public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isBadVersion(mid)){
                if(mid==1||isBadVersion(mid-1)==false)
                    return mid;
                else
                    h = mid-1;
            }
            else
                l = mid+1;
        }
        return -1;
    }
