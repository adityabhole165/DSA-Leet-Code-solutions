class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        int numCols = (n /cycleLen + 1)* (numRows + 1);
        char[][] grid =  new char[numRows][numCols];

        int row = 0,col = 0;
        int index= 0;

        while (index < n) {
            // go down 
            while(row < numRows && index < n){
                grid[row][col] = s.charAt(index++);
                row++;
            }
            row -= 2;
            col++;

            //do diagonally  up 
            while(row > 0 && col < numCols && index < n) {
                grid[row][col] = s.charAt(index++);
                row--;
                col++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(char[] r: grid) {
            for(char c : r) {
                if(c!= '\u0000'){
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}