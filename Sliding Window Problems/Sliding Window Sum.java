You are given an array of n integers. Your task is to calculate the sum of each window of k elements, from left to right.
  
In this problem the input data is large and it is created using a generator.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
The next line contains four integers x, a, b and c: the input generator parameters. The input is generated as follows:

x_1=x
x_i=(ax_{i-1}+b) mod c for i=2,3,...,n

Output
Print the xor of all window sums.
Constraints

1 <= k <= n <= 10^7
0 <= x,a,b <= 10^9
1 <= c <= 10^9

Example
  
Input:
8 5
3 7 1 11
Output:
12

Explanation: The input array is [3,0,1,8,2,4,7,6]. The windows are [3,0,1,8,2], [0,1,8,2,4], [1,8,2,4,7] and [8,2,4,7,6], and their sums are 14, 15, 22 and 27. Thus, the answer is 14 ^ 15 ^ 22 ^ 27 = 12.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] pre = new long[n+1];
        pre[1] = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        for(int i=2;i<=n;i++){
            pre[i] = (a*pre[i-1]+b)%c;
        }
        for(int i=2;i<=n;i++){
            pre[i] += pre[i-1];
        }
        long xum = 0;
        for(int i=k;i<=n;i++){
            xum ^= (pre[i]-pre[i-k]);
        }
        bw.write(Long.toString(xum));
        bw.newLine();
        bw.flush();
    }
}
