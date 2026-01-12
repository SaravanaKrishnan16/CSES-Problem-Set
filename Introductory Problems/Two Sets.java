Your task is to divide the numbers 1,2,...,n into two sets of equal sum.
  
Input
The only input line contains an integer n.
  
Output
Print "YES", if the division is possible, and "NO" otherwise.
After this, if the division is possible, print an example of how to create the sets. First, print the number of elements in the first set followed by the elements themselves in a separate line, and then, print the second set in a similar way.
  
Constraints

1 <= n <= 10^6

Example 1
  
Input:
7
Output:
YES
4
1 2 4 7
3
3 5 6
  
Example 2
  
Input:
6
Output:
NO

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long total = (long) n*(n+1)/2;
        if (total%2!=0) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        long target = total/2;
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        int count1 = 0,count2 = 0;
        for(int i=n;i>=1;i--){
            if(i<=target){
                set1.append(i).append(" ");
                target -= i;
                count1++;
            } 
            else{
                set2.append(i).append(" ");
                count2++;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(count1).append("\n");
        res.append(set1).append("\n");
        res.append(count2).append("\n");
        res.append(set2);
        System.out.print(res);
    }
}
