1class Solution {
2    public int majorityElement(int[] nums) {
3        int cand =0, count=0;
4
5        for(int n: nums){
6            if(count == 0){
7                cand = n;
8            }
9            if( n == cand){
10                count++;
11            } else {
12                count--;
13            }
14        }
15
16        return cand;
17    }
18}