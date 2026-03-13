class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = Long.MAX_VALUE;
        long ans = 0;

        while(left <= right) {
            long mid = left + (right - left)/2;
            boolean curr = bs(mid,mountainHeight,workerTimes);
            if(curr) {
                ans  = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean bs(long time,int height,int [] workers) {
        long workdone = 0;
        for(int i=0;i<workers.length;i++) {
            workdone+=workdoneinT(time,workers[i]);
            if(workdone>=height) return true;
        }
        return false;
    }

    // see thought process above 
    public long workdoneinT(long time,int worker) {
        return (long)((Math.sqrt(1 + 8.0 * time / worker) - 1) / 2);
    }
}