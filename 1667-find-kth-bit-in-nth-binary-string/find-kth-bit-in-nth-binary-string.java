class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append("0");

        for(int i = 1;i < n;i++){
            String ss = s.toString();
            s.append(s.substring(s.length()) + "1");
            StringBuilder temp = new StringBuilder();

            for(int j = ss.length()-1;j >= 0;j--){
                char c = ss.charAt(j) == '1' ? '0' : '1';

                temp.append(c+"");
            }

            s.append(temp.toString()+"");
        }

        return s.charAt(k-1);
    }
}