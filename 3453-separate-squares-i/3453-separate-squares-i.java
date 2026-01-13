class Solution {
    public double separateSquares(int[][] squares) {
        double low = 1e18 , high =-1e18;

        for(int[] sq : squares) {
            long y = sq[1];
            long l = sq[2];

            low = Math.min(low,y);
            high = Math.max(high, y+l);

        }

        //total area
        double total = 0;
        for(int[] sq : squares){
            long l = sq[2];
            total += (double) l * l;

        }

        // binary search for heigt
        for(int iter = 0; iter < 100; iter++){
            double mid =(low + high) / 2.0;
            double below = areaBelow(squares,mid);

            if( below * 2.0 >= total){
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private double areaBelow(int[][] squares, double H){
        double sum =0;
        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];

            double top = y+l;

            if(H<=y){
                continue;
            }
            if(H >= top) {
                sum+= l*l;
            } else {
                sum += l*(H-y);
            }
        }
        return sum;
    }


}