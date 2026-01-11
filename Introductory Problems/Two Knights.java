Your task is to count for k=1,2,...,n the number of ways two knights can be placed on a k \times k chessboard so that they do not attack each other.
  
Input
The only input line contains an integer n.
Output
Print n integers: the results.
Constraints

1 <= n <= 10000

Example
Input:
8

Output:
0
6
28
96
252
550
1056
1848

----------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for(long k=1;k<=n;k++) {
            long total = (k*k*(k*k-1))/2;
            long attack = 0;
            if(k>2){
                attack = 4*(k-1)*(k-2);
            }
            System.out.println(total-attack);
        }
    }
}
