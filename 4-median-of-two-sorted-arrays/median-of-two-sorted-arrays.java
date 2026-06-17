import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a1 =nums1.length;
        int b1 =nums2.length;

        int c1 = a1 + b1;

        int[] c = new int[c1];

        System.arraycopy(nums1,0,c,0,a1);
        System.arraycopy(nums2,0,c,a1,b1);

        System.out.println(" "+Arrays.toString(c));

        Arrays.sort(c);

        int n = c.length;

        if(n %2 != 0) {
            return c[n/2];
        }

        return (c[(n-1)/2] + c[n/2]) /2.0;
    }
}