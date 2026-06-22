class Solution {
    public int myAtoi(String s) {
      int i = 0 ;
       int n = s.length();
      int sign = 1;
      int result = 0 ;
      //phase 1 : skip leading whitespace
      while( i< n && s.charAt(i) == ' '){
        i++;
      }
      //phase 2 : Optional sign
      if(i < n && (s.charAt(i) == '+'  || s.charAt(i) == '-' )) {
        sign  = (s.charAt(i) == '-') ? -1 :1;
        i++;
      }
      //phase 3 : digigts with inline overflow guard (pure int arithmetic) 
      while( i < n && Character.isDigit(s.charAt(i))) {
        int digit = s.charAt(i) - '0';
        //overflow chack multiplying - this is the key trick
        if(result > (Integer.MAX_VALUE - digit)/10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        result = result * 10 + digit ;
        i++;
      }
      return sign * result ;
    }
}