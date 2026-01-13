Your task is to calculate the number of trailing zeros in the factorial n!.
  
For example, 20!=2432902008176640000 and it has 4 trailing zeros.
  
Input
The only input line has an integer n.
  
Output
Print the number of trailing zeros in n!.
Constraints

1 <= n <= 10^9

Example
  
Input:
20
Output:
4

-------------------------------------------------------------------------------------------

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 0;
        while(n>0){
            n /= 5;
            count += n;
        }
        System.out.println(count);
    }
}
