1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow = nums[0];
4        int fast = nums[0];
5        do{
6            slow = nums[slow];
7            fast = nums[nums[fast]];
8        }while( slow != fast);
9
10        slow = nums[0];
11
12        while(slow != fast){
13            slow = nums[slow];
14            fast = nums[fast];
15        }
16
17        return slow;
18
19    }
20}