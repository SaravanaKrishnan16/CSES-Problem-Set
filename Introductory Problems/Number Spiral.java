A number spiral is an infinite grid whose upper-left square has number 1. Here are the first five layers of the spiral:

Your task is to find out the number in row y and column x.
  
Input
The first input line contains an integer t: the number of tests.
After this, there are t lines, each containing integers y and x.
  
Output
For each test, print the number in row y and column x.
Constraints

1 <= t <= 10^5
1 <= y,x <= 10^9

Example
Input:
3
2 3
1 1
4 2

Output:
8
1
15

----------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long k = Math.max(y, x);
            long ans;
            if (k%2==0){ 
                if(y==k){
                    ans = k*k-(x-1);
                } 
                 else {
                    ans = (k-1)*(k-1)+y;
                }
            } 
            else{
                if(x==k) {
                    ans = k*k-(y-1);
                } 
                else {
                    ans = (k-1)*(k-1)+x;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
