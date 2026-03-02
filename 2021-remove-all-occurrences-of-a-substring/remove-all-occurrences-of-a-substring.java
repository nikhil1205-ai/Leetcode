class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str=new StringBuilder(s);
        while(str.indexOf(part)>-1){
            str.delete(str.indexOf(part),str.indexOf(part)+part.length());
        }
        return str.toString();
    }
}