class Solution {
    public int myAtoi(String s) {
        s = s.trim(); //skip leading whitespace.
        if(s.isEmpty()) {
            return 0;
        }
        int i = 0, n = s.length();
        int sign = 1;

        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign  = (s.charAt(i) == '-') ? -1 :1;
            i++;
        }

        long result = 0; //long absorbs Oveflow safely

        while( i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0') ;
            if(sign  == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * result);
    }
}