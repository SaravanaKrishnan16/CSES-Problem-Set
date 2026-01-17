Your task is to reorder the characters of a string so that no two adjacent characters are the same. What is the lexicographically minimal such string?
  
Input
The only line has a string of length n consisting of characters A–Z.
Output
Print the lexicographically minimal reordered string where no two adjacent characters are the same. If it is not possible to create such a string, print -1.
  
Constraints

1 <= n <= 10^6

Example
  
Input:
HATTIVATTI
Output:
AHATITITVT

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'A']++;
        }
        int max = 0;
        for(int f : freq){
            max = Math.max(max,f);
        }
        if(max>(n+1)/2){
            System.out.println("-1");
            return;
        }
        StringBuilder res = new StringBuilder();
        char prev = '#';
        for(int pos=0;pos<n;pos++){
            boolean placed = false;
            for(int i=0;i<26;i++){
                if(freq[i]==0) continue;
                char curr = (char) ('A'+i);
                if(curr == prev) continue;
                freq[i]--;
                int rem = n-pos-1;
                int fmax = 0;
                for(int f : freq){
                    fmax = Math.max(fmax,f);
                }
                if(fmax<=(rem+1)/2){
                    res.append(curr);
                    prev = curr;
                    placed = true;
                    break;
                }
                freq[i]++;
            }
            if (!placed) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(res.toString());
    }
}
