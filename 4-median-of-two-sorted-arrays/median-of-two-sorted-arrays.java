class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int lo = 0, hi = m;

        while (lo <= hi) {
            int i = (lo + hi) / 2;            // partition in nums1
            int j = (m + n + 1) / 2 - i;      // partition in nums2

            int maxLeft1  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // ✅ Valid partition found!
                if ((m + n) % 2 == 1)
                    return Math.max(maxLeft1, maxLeft2);
                return (Math.max(maxLeft1, maxLeft2)
                      + Math.min(minRight1, minRight2)) / 2.0;

            } else if (maxLeft1 > minRight2) {
                hi = i - 1;  // too many from nums1
            } else {
                lo = i + 1;  // too few from nums1
            }
        }
        return 0.0;
    }
}