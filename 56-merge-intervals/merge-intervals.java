class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        List<int[]> arr= new ArrayList<>();
        int a=intervals[0][0],b=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
             if(intervals[i][0]<=b){
                b=Math.max(intervals[i][1],b);
             }else{
                arr.add(new int[]{a, b});
                a=intervals[i][0];
                b=intervals[i][1];
             }
        }
        arr.add(new int[]{a, b});
        return arr.toArray(new int[arr.size()][]);
    }
}