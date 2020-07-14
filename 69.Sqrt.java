
class mySqrt {
    public int mySqrt(int x) { 
        if(x==0){
            return 0;
        }
         int start = 1;
        int end = x;
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(mid <=x/mid&&mid+1>x/(mid+1)){
                return mid;
            }
            else if(mid<x/mid){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start;
 }
 }
 