Given a string, your task is to reorder its letters in such a way that it becomes a palindrome (i.e., it reads the same forwards and backwards).
  
Input
The only input line has a string of length n consisting of characters A–Z.
Output
Print a palindrome consisting of the characters of the original string. You may print any valid solution. If there are no solutions, print "NO SOLUTION".
  
Constraints

1 <= n <= 10^6

Example
  
Input:
AAAACACBA
Output:
AACABACAA

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c -'A']++;
        }
        int oddcount = 0;
        int oddchar = -1;
        for(int i=0;i<26;i++){
            if(freq[i]%2 == 1){
                oddcount++;
                oddchar = i;
            }
        }
        if(oddcount>1){
            System.out.println("NO SOLUTION");
            return;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        for(int i=0;i<26;i++){
            char ch = (char) ('A'+i);
            if(freq[i]%2 == 1){
                for(int k=0;k<freq[i];k++){
                    middle.append(ch);
                }
            } 
            else {
                for(int k=0;k<freq[i]/2;k++) {
                    left.append(ch);
                }
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        System.out.println(left.toString()+middle.toString()+right.toString());
    }
}
