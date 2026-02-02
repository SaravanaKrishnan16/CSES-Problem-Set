You are given an array of n integers. Your task is to calculate the mode each window of k elements, from left to right.
  
The mode is the most frequent element in an array. If there are several possible modes, choose the smallest of them.
  
Input
The first line contains two integers n and k: the number of elements and the size of the window.
Then there are n integers x_1,x_2,...,x_n: the contents of the array.
  
Output
Print n-k+1 values: the modes.
  
Constraints

1 <= k <= n <= 2.10^5
1 <= x_i <= 10^9

Example
  
Input:
8 3
1 2 3 2 5 2 4 4
Output:
1 2 2 2 2 4

------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer> freq = new HashMap<>();
    static HashMap<Integer, Integer> freqcount = new HashMap<>();
    static TreeSet<Integer> maxset = new TreeSet<>();
    static int maxfreq = 0;

    static void add(int x) {
        int oldF = freq.getOrDefault(x,0);
        int newF = oldF+1;
        freq.put(x,newF);
        if(oldF>0)
            freqcount.put(oldF,freqcount.get(oldF)-1);
        freqcount.put(newF,freqcount.getOrDefault(newF,0)+1);
        if(newF>maxfreq){
            maxfreq = newF;
            maxset.clear();
            maxset.add(x);
        } 
        else if(newF==maxfreq){
            maxset.add(x);
        }
    }

    static void remove(int x) {
        int oldF = freq.get(x);
        freqcount.put(oldF,freqcount.get(oldF)-1);
        if(oldF==maxfreq)
            maxset.remove(x);
        if(oldF==1){
            freq.remove(x);
        } 
        else{
            int newF = oldF-1;
            freq.put(x,newF);
            freqcount.put(newF,freqcount.getOrDefault(newF,0)+1);
        }
        if(freqcount.getOrDefault(maxfreq,0)==0){
            maxfreq--;
            maxset.clear();
            for(Map.Entry<Integer,Integer> e : freq.entrySet()){
                if(e.getValue()==maxfreq){
                    maxset.add(e.getKey());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            add(arr[i]);
            if(i>=k)
                remove(arr[i-k]);
            if(i>=k-1)
                bw.write(maxset.first()+" ");
        }
        bw.flush();
    }
}
