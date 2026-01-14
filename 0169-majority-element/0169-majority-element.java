class Solution {
    public int majorityElement(int[] nums) {
        int cand =0, count=0;

        for(int n: nums){
            if(count == 0){
                cand = n;
            }
            if( n == cand){
                count++;
            } else {
                count--;
            }
        }

        return cand;
    }
}