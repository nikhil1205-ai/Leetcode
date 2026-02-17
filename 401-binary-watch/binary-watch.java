class Solution {
    private void generate(int[] arr, int k, int idx,
                          List<Integer> curr,
                          List<List<Integer>> ans) {

        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(idx == arr.length) return;

        curr.add(arr[idx]);
        generate(arr, k, idx + 1, curr, ans);

        curr.remove(curr.size() - 1);
        generate(arr, k, idx + 1, curr, ans);
    }

    public List<String> readBinaryWatch(int turnedOn) {

        int[] hr = {8,4,2,1};
        int[] mint = {32,16,8,4,2,1};

        List<String> res = new ArrayList<>();

        for(int h = 0; h <= turnedOn; h++){

            int m = turnedOn - h;

            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();

            generate(hr, h, 0, curr, ans);

            List<Integer> realhr = new ArrayList<>();
            for(List<Integer> x : ans){
                int sum = 0;
                for(int v : x) sum += v;
                if(sum <= 11) realhr.add(sum);
            }

            curr.clear();
            ans.clear();

            generate(mint, m, 0, curr, ans);

            List<Integer> realmin = new ArrayList<>();
            for(List<Integer> x : ans){
                int sum = 0;
                for(int v : x) sum += v;
                if(sum <= 59) realmin.add(sum);
            }

            for(int hour : realhr){
                for(int minute : realmin){

                    String hstr = String.valueOf(hour);
                    String mstr = String.valueOf(minute);

                    if(mstr.length() < 2) mstr = "0" + mstr;

                    res.add(hstr + ":" + mstr);
                }
            }
        }

        return res;
    }
}