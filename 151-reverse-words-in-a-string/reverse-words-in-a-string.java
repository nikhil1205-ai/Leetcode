class Solution {
    public String reverseWords(String s){
        String str=s.trim().replaceAll("\\s+", " ");
        String temp="";
        String out="";
        for(char c:str.toCharArray()){
            if(c==' '){
              out=" "+temp+out;
              temp="";
            }else temp+=c;
        }
        return temp+out;
    }
}