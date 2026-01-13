There are n apples with known weights. Your task is to divide the apples into two groups so that the difference between the weights of the groups is minimal.

Input
The first input line has an integer n: the number of apples.
The next line has n integers p_1,p_2,\dots,p_n: the weight of each apple.
Output
Print one integer: the minimum difference between the weights of the groups.

Constraints

1 <= n <= 20
1 <= p_i <= 10^9

Example

Input:
5
3 2 7 4 1
Output:
1

Explanation: Group 1 has weights 2, 3 and 4 (total weight 9), and group 2 has weights 1 and 7 (total weight 8).

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

class Main {

    static int n;
    static long[] arr;
    static long total;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }
        solve(0,0);
        System.out.println(ans);
    }
    static void solve(int index,long curr){
        if(index == n){
            long sum = total-curr;
            long diff = Math.abs(curr-sum);
            ans = Math.min(ans,diff);
            return;
        }
        solve(index+1,curr+arr[index]);
        solve(index+1,curr);
    }
}


