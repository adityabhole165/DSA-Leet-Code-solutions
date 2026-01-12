class Solution {
      public void rotate(int[] nums, int k) {
        int left =0;
        int n = nums.length;
        int right= n-1;
        k = k % n;
        reverse(nums,left,right);
        reverse(nums,0 , k-1);
        reverse(nums, k, n-1);
        
    }
    public void reverse(int[] nums,int left,int  right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}