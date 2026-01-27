You are given an array of n integers. Your task is to calculate the bitwise xor of each window of k elements, from left to right.
  
In this problem the input data is large and it is created using a generator.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
The next line contains four integers x, a, b and c: the input generator parameters. The input is generated as follows:

x_1=x
x_i=(ax_{i-1}+b) % c for i=2,3,...,n

Output
Print the xor of all window xors.
  
Constraints

1 <= k <= n <= 10^7
0 <= x, a, b <= 10^9
1 <= c <= 10^9

Example
  
Input:
8 5
3 7 1 11
Output:
0

Explanation: The input array is [3,0,1,8,2,4,7,6]. The windows are [3,0,1,8,2], [0,1,8,2,4], [1,8,2,4,7] and [8,2,4,7,6], and their xors are 8, 15, 8 and 15. Thus, the answer is 8 \oplus 15 \oplus 8 \oplus 15 = 0.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
        int[] arr = new int[k];   
        int ind = 0;
        int xor = 0;
        int ans = 0;
        arr[0] = (int) x;
        xor ^= buffer[0];
        for(int i=1;i<k;i++){
            x = (a*x+b)%c;
            arr[i] = (int) x;
            xor ^= buffer[i];
        }
        ans ^= xor;
        for(int i=k;i<n;i++){
            x = (a*x+b)%c;
            xor ^= arr[ind];
            buffer[ind] = (int) x;
            xor ^= arr[ind];
            ind = (ind+1)%k;
            ans ^= xor;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

