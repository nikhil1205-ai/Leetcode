class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(nums.length==1){
            return 0;
        }
        Arrays.sort(nums);

        int maxWindow = 1;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && (long) nums[j] <= (long) nums[i] * k) {
                j++;
            }
            maxWindow = Math.max(maxWindow, j - i);
        }

        return n - maxWindow;
    }
}