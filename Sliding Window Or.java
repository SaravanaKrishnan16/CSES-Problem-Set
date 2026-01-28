You are given an array of n integers. Your task is to calculate the bitwise or of each window of k elements, from left to right.
  
In this problem the input data is large and it is created using a generator.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
The next line contains four integers x, a, b and c: the input generator parameters. The input is generated as follows:
x_1=x
x_i=(ax_{i-1}+b) mod c for i=2,3,...,n

Output
Print the xor of all window ors.
  
Constraints

1 <= k <= n <= 10^7
0 <= x, a, b <= 10^9
1 <= c <= 10^9

Example
  
Input:
8 5
3 7 1 11
Output:
4
Explanation: The input array is [3,0,1,8,2,4,7,6]. The windows are [3,0,1,8,2], [0,1,8,2,4], [1,8,2,4,7] and [8,2,4,7,6], and their ors are 11, 15, 15 and 15. Thus, the answer is 11 \oplus 15 \oplus 15 \oplus 15 = 4.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
        long x = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        int[] val = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        for(int i=0;i<n;i++){
            val[i] = (int) x;
            x = (a*x+b)%c;
        }
        for(int i=0;i<n;i++){
            if(i%k==0){
                pre[i] = val[i];
            } 
            else{
                pre[i] = pre[i-1]|val[i];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1||i%k==k-1){
                suf[i] = val[i];
            } 
            else{
                suf[i] = suf[i+1]|val[i];
            }
        }
        int xor = 0;
        for(int i=0;i<=n-k;i++){
            xor ^= (suf[i]|pre[i+k-1]);
        }
        bw.write(Integer.toString(xor));
        bw.newLine();
        bw.flush();
    }
}
