class Solution {
    public int romanToInt(String s) {
       int[] val = new int[128];
       val['I'] = 1;
       val['V'] = 5;
       val['X'] = 10;
       val['L'] = 50;
       val['C'] = 100;
       val['D'] = 500;
       val['M'] = 1000;
    
        int total = 0;
        int n = s.length();

        for(int i = 0; i< n; i++){
           int curr = val[s.charAt(i)];
           int next = (i + 1 < n) ? val[s.charAt(i + 1)] : 0;
           total += (curr < next) ? -curr : curr;
        }    
        return total ;
    }
}