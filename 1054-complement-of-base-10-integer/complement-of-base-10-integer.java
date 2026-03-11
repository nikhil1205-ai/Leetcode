class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0){
            return 1;
        }
        int bitRange = 1;
        while(bitRange < n){
            bitRange = (bitRange << 1)|1;
        }
        return n ^ bitRange;
    }
}