1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int xor = 0;
5
6        for(int i = 0; i <= n ; i++){
7            xor = xor ^ i;
8        }
9
10        for(int j = 0 ; j < n ; j++){
11            xor = nums[j] ^ xor;
12        }
13        return xor;
14    }
15}