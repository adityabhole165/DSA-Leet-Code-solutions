import java.util.HashSet;
import java.util.Set;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Optimized Sliding window with HashSet 
        // Time Complexity  - O(n)-each char added/removed at most once
        //Space Complexity - O(k) - uniquw chars in current window 
        Set<Character> window = new HashSet<>();
        int left = 0 , max = 0 ;
        for(int right = 0; right < s.length(); right++) {
            //shrink window from left until no duplicate exists
            while(window.contains(s.charAt(right)))  {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));
            max = Math.max(max,  right - left + 1);
        }
        return max;
    }
}