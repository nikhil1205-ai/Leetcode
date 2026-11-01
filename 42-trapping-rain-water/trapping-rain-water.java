class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxL=new int[n];
        int[] maxR=new int[n];
        
        maxL[0]=height[0];
        maxR[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            maxL[i]=Math.max(height[i],maxL[i-1]);
            
        }

        for(int i=0;i<n-1;i++){
            maxR[n-2-i]=Math.max(height[n-2-i],maxR[n-1-i]);
            
        }

        int k=0;
        for(int i=0;i<n;i++){
            k+=Math.min(maxL[i],maxR[i])-height[i];
        }
        return k;
    }
}