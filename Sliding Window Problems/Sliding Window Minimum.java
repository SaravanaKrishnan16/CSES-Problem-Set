You are given an array of n integers. Your task is to calculate the minimum of each window of k elements, from left to right.
  
In this problem the input data is large and it is created using a generator.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
The next line contains four integers x, a, b and c: the input generator parameters. The input is generated as follows:

x_1=x
x_i=(ax_{i-1}+b) \bmod c for i=2,3,...,n

Output
Print the xor of all window minimums.
  
Constraints

1 <= k <= n <= 10^7
0 <= x, a, b <= 10^9
1 <= c <= 10^9

Example
  
Input:
8 5
3 7 1 11
Output:
3
Explanation: The input array is [3,0,1,8,2,4,7,6]. The windows are [3,0,1,8,2], [0,1,8,2,4], [1,8,2,4,7] and [8,2,4,7,6], and their minimums are 0, 0, 1 and 2. Thus, the answer is 0 \oplus 0 \oplus 1 \oplus 2 = 3.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        Deque<Long> dq = new ArrayDeque<>();
        long ans = 0;
        long[] window = new long[k];
        int idx = 0;
        for(int i=0;i<n;i++){
            long curr = x;
            x = (a*x+b)%c;
            while(!dq.isEmpty() && dq.peekLast()>curr){
                dq.pollLast();
            }
            dq.addLast(curr);
            if(i>=k){
                long out = window[idx];
                if(dq.peekFirst() == out){
                    dq.pollFirst();
                }
            }
            window[idx] = curr;
            idx = (idx+1)%k;
            if(i>=k-1){
                ans ^= dq.peekFirst();
            }
        }
        System.out.println(ans);
    }
}
