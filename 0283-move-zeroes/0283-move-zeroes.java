class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != 0 ){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int x = j ; x<nums.length; x++){
            nums[x] = 0;
        }
    }
}