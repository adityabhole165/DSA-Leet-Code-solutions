1class Solution {
2    public void moveZeroes(int[] nums) {
3        int j = 0;
4        for(int i = 0; i< nums.length; i++){
5            if(nums[i] != 0 ){
6                nums[j] = nums[i];
7                j++;
8            }
9        }
10        for(int x = j ; x<nums.length; x++){
11            nums[x] = 0;
12        }
13    }
14}