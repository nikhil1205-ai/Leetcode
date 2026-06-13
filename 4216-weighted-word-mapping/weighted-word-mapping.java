class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder newS=new StringBuilder("");
        for(String s:words){
            int sum=0;
            for(char c :s.toCharArray()){
              sum+=weights[c-'a'];
            }
            sum=sum%26;
            newS.append((char)( 'a'+(25-sum)));
        }
        return newS.toString();
    }
}