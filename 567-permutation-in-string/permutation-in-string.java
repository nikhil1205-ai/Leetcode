class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        if(l1>l2) return false;
        HashMap<Character,Integer> hm1= new HashMap<Character,Integer>();
        for(char c : s1.toCharArray()){
           hm1.put(c,hm1.getOrDefault(c,0)+1);
        }

        for(int i=0;i<=l2-l1;i++){
            HashMap<Character,Integer> hm2= new HashMap<>();
            for(int k=i;k<i+l1;k++){
               hm2.put(s2.charAt(k),hm2.getOrDefault(s2.charAt(k),0)+1);
            }
            if (hm1.equals(hm2)) return true;
        }

        return false;

    }
}