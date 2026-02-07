class Solution {
    public int minimumDeletions(String s) {
        char abArr[] = s.toCharArray();
        int n = abArr.length;
        int[] cacheA = new int[n];
        for(int i=n-2; i>=0; i--){
            cacheA[i] = cacheA[i+1] + ((abArr[i+1]=='a') ? 1 : 0);
        }
        int res=Integer.MAX_VALUE;
        int cacheB=0;
        for(int i=0; i<n; i++){
            res = Math.min(res, cacheA[i]+cacheB);
            if(abArr[i]=='b'){
                cacheB++;
            }
        }
        return res;
    }
}

        
