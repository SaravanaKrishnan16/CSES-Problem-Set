You are given a DNA sequence: a string consisting of characters A, C, G, and T. Your task is to find the longest repetition in the sequence. This is a maximum-length substring containing only one type of character.
  
Input
  
The only input line contains a string of n characters.
  
Output
  
Print one integer: the length of the longest repetition.
  
Constraints

1 <= n <= 10^6

Example
  
Input:
ATTCGGGA
  
Output:
3

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int max = 1;
        int curr = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            } 
            else {
                curr = 1;
            }
            max = Math.max(max,curr);
        }
        System.out.println(max);
    }
}
