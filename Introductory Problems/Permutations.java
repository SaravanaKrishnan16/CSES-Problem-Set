A permutation of integers 1,2,...,n is called beautiful if there are no adjacent elements whose difference is 1.
  
Given n, construct a beautiful permutation if such a permutation exists.
  
Input
The only input line contains an integer n.
Output
Print a beautiful permutation of integers 1,2,\ldots,n. If there are several solutions, you may print any of them. If there are no solutions, print "NO SOLUTION".
  
Constraints

1 <= n <= 10^6

Example 1
Input:
5

Output:
4 2 5 3 1
  
Example 2
Input:
3

Output:
NO SOLUTION

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            out.write("1");
        } 
        else if(n== 2 || n == 3) {
            out.write("NO SOLUTION");
        } 
        else {
            for(int i=2;i<= n;i+=2){
                out.write(i+" ");
            }
            for(int i=1;i<=n;i+=2){
                out.write(i+" ");
            }
        }
        out.flush();
    }
}
 
