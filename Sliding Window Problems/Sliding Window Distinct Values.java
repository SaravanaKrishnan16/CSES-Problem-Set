You are given an array of n integers. Your task is to calculate the number of distinct values in each window of k elements, from left to right.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
Then there are n integers x_1,x_2,...,x_n: the contents of the array.
  
Output
Print n-k+1 values: the numbers of distinct values.
  
Constraints

1 <= k <= n <= 2.10^5
1 <= x_i <= 10^9

Example
  
Input:
8 3
1 2 3 2 5 2 2 2
Output:
3 2 3 2 2 1

---------------------------------------------------------------------------------------------------------------------------------------------------------------

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
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])==1){
                count++;
            }
        }
        bw.write(count+ " ");
        for(int i=k;i<n;i++){
            int out = arr[i-k];
            map.put(out,map.get(out)-1);
            if(map.get(out)==0){
                map.remove(out);
                count--;
            }
            int in = arr[i];
            map.put(in,map.getOrDefault(in,0)+1);
            if(map.get(in)==1){
                count++;
            }
            bw.write(count+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
