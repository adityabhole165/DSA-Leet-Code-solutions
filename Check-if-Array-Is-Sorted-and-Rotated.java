1class Solution {
2    public boolean check(int[] nums) {
3        int n = nums.length;
4        int count=0;
5
6        for(int i = 0; i< n-1; i++){
7            if(nums[i] > nums[i+1]){
8                count++;
9            }
10        }
11        if(nums[n-1] > nums[0]) {
12                count++;
13         }
14        if(count <=1){
15             return true;
16        }else {
17            return false;
18        }
19    }
20}