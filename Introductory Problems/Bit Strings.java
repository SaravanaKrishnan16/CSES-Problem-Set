Your task is to calculate the number of bit strings of length n.
  
For example, if n=3, the correct answer is 8, because the possible bit strings are 000, 001, 010, 011, 100, 101, 110, and 111.
  
Input
The only input line has an integer n.
  
Output
Print the result modulo 10^9+7.
  
Constraints

1 <= n <= 10^6

Example
  
Input:
3
Output:
8

--------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
 
public class Main {
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = power(2, n);
        System.out.println(res);
    }
    static long power(long base,long exp){
        long res = 1;
        while(exp>0){
            if((exp&1)==1){
                res = (res*base)%MOD;
            }
            base = (base*base)%MOD;
            exp >>= 1;
        }
        return res;
    }
}
