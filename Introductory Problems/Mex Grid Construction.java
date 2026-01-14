Your task is to construct an n \times n grid where each square has the smallest nonnegative integer that does not appear to the left on the same row or above on the same column.
  
Input
The only line has an integer n.
  
Output
Print the grid according to the example.
  
Constraints

1 <= n <= 100

Example
  
Input:
5
Output:
0 1 2 3 4
1 0 3 2 5
2 3 0 1 6
3 2 1 0 7
4 5 6 7 0

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print((i^j)+" ");
            }
            System.out.println();
        }
    }
}

  
