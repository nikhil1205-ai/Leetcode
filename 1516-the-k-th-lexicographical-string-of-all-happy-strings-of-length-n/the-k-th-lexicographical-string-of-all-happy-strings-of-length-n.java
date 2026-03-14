class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int num = (int) Math.pow(2,n - 1);
        if(k > 3*num){
            return "";
        }
        if(k > 2*num){
            sb.append("c");
            k -= (2*num);
        } else if(k > num)  {
            sb.append("b");
            k -= num;
        }
        else {
            sb.append("a");
        }
        n--;
        while(n != 0){
            num = (int) Math.pow(2,n - 1);
            char ch = sb.charAt(sb.length() - 1);
            if(k > num) {
                if(ch == 'c') {
                    sb.append("b");
                } else if(ch == 'b' || ch == 'a') {
                    sb.append("c");
                }
                k -= num;
            } else {
                if(ch == 'c' || ch == 'b') {
                    sb.append("a");
                } else if(ch == 'a') {
                    sb.append("b");
                }
            }
            n--;
        }
        return sb.toString();
    }
}