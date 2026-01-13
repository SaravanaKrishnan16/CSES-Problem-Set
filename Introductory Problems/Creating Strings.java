Given a string, your task is to generate all different strings that can be created using its characters.
  
Input
The only input line has a string of length n. Each character is between a–z.
Output
First print an integer k: the number of strings. Then print k lines: the strings in alphabetical order.
  
Constraints

1 <= n <= 8

Example
  
Input:
aabac
Output:
20
aaabc
aaacb
aabac
aabca
aacab
aacba
abaac
abaca
abcaa
acaab
acaba
acbaa
baaac
baaca
bacaa
bcaaa
caaab
caaba
cabaa
cbaaa

-----------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

class Main {

    static List<String> res = new ArrayList<>();
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);              
        used = new boolean[arr.length];
        backtrack(arr,new StringBuilder());
        System.out.println(res.size());
        for(String str : res){
            System.out.println(str);
        }
    }
    static void backtrack(char[] arr, StringBuilder curr){
        if(curr.length() == arr.length){
            res.add(curr.toString());
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(used[i]) continue;
            if(i>0 && arr[i]==arr[i-1] && !used[i-1]) continue;
            used[i] = true;
            curr.append(arr[i]);
            backtrack(arr,curr);
            curr.deleteCharAt(curr.length()-1);
            used[i] = false;
        }
    }
}
