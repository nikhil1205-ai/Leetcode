class Solution {
    public int maxArea(int[] height) {
        int h = height.length;
        int left = 0;
        int right = h-1;
        int max_height = 0;
        while(left<right){
            int base = right-left;
            int min_height = Math.min(height[left], height[right]);
            int area = base*min_height;
            max_height = Math.max(max_height, area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max_height;
    }
}