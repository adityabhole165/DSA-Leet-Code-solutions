1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int n = nums.length;
4        if( n == 0) {
5            return 0;
6        }
7        int i =0;
8        for(int j = 1; j<n; j++){
9            if(nums[i] != nums[j]){
10                i++;
11                nums[i] = nums[j];
12            }
13        }
14        return i+1;
15    }
16}