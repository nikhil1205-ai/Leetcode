class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int idxa = a.length() -1;
        int idxb = b.length() -1;
        int carry = 0;
        int idx = 0;
        while(idxa >= 0 || idxb >= 0){
            int cha = idxa >= 0 ? (int)a.charAt(idxa)-48 : 0;
            int chb = idxb >= 0 ? (int)b.charAt(idxb)-48 : 0;
            Integer digit = (cha + chb + carry)%2;
            ans.append(digit.toString());
            carry = (cha + chb + carry)/2;
            idxa--;
            idxb--;
            idx++;
        }
        if (carry == 1){
            ans.append('1');
        }
        return ans.reverse().toString();
}
}