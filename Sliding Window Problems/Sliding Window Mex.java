You are given an array of n integers. Your task is to calculate the mex of each window of k elements, from left to right.
  
The mex is the smallest nonnegative integer that does not appear in the array. For example, the mex for [3,1,4,3,0,5] is 2.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
Then there are n integers x_1,x_2,...,x_n: the contents of the array.
  
Output
Print n-k+1 values: the mex values.
  
Constraints

1 <= k <= n <= 2.10^5
0 <= x_i <= 10^9

Example
Input:
8 3
1 2 1 0 5 1 1 0

Output:
0 3 2 2 0 2

--------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] freq = new int[k+1];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<=k;i++){
            set.add(i);
        }
        for(int i=0;i<k;i++){
            if(arr[i]<=k){
                freq[arr[i]]++;
                if(freq[arr[i]]==1){
                    set.remove(arr[i]);
                }
            }
        }
        bw.write(set.first()+" ");
        for(int i=k;i<n;i++){
            int out = arr[i-k];
            int in = arr[i];
            if(out<=k){
                freq[out]--;
                if(freq[out]==0){
                    set.add(out);
                }
            }
            if(in<=k){
                freq[in]++;
                if(freq[in]==1){
                    set.remove(in);
                }
            }
            bw.write(set.first()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
