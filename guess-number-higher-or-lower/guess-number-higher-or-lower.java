/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    
    
    public int guessNumber(int n) {
        int a;
        
        long mid;
        long l=1;
        long e=n;
        
        while(l<=e){
            mid=(l+e)/2;
            a=guess((int)mid);
            
            
            if(a==0){
                return (int)mid;
            }
            
            else if(a==-1){
                e=mid-1;
            }
            else{
                l=mid+1;
            }
            
            
            
            
        }
        return -1;
        
        
    }
}