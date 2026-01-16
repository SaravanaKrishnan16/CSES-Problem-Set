Consider an infinite string that consists of all positive integers in increasing order:
12345678910111213141516171819202122232425...
  
Your task is to process q queries of the form: what is the digit at position k in the string?
  
Input
The first input line has an integer q: the number of queries.
After this, there are q lines that describe the queries. Each line has an integer k: a 1-indexed position in the string.
  
Output
For each query, print the corresponding digit.
  
Constraints

1 <= q <= 1000
1 <= k <= 10^{18}

Example
Input:
3
7
19
12

Output:
7
4
1

----------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(q-->0){
            long k = Long.parseLong(br.readLine());
            sb.append(find(k)).append('\n');
        }
        System.out.print(sb.toString());
    }

    static char find(long k){
        long digits = 1;
        long count = 9;
        long start = 1;
        while(k>digits*count){
            k -= digits*count;
            digits++;
            count *= 10;
            start *= 10;
        }
        long num = start+(k-1)/digits;
        int ind = (int)((k-1)%digits);
        return Long.toString(num).charAt(ind);
    }
}
