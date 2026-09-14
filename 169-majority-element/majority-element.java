// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> hash = new HashMap<>();
//         int res = 0;
//         int majority = 0;

//         for (int n : nums) {
//             hash.put(n, 1 + hash.getOrDefault(n, 0));
//             if (hash.get(n) > majority) {
//                 res = n;
//                 majority = hash.get(n);
//             }
//         }

//         return res;        
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}