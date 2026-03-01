class Solution {
    public String reverseWords(String s){
        String str=s.trim().replaceAll("\\s+", " ");
        StringBuilder temp=new StringBuilder();
        StringBuilder out=new StringBuilder();
        for(char c:str.toCharArray()){
            if(c==' '){
              temp.insert(0," ");
              out.insert(0,temp); 
            //   out=" "+temp+out;
              temp=new StringBuilder();
            }else temp.append(c);
        }
        return out.insert(0,temp).toString();
    }
}