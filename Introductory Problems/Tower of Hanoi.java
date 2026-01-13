The Tower of Hanoi game consists of three stacks (left, middle and right) and n round disks of different sizes. Initially, the left stack has all the disks, in increasing order of size from top to bottom.
  
The goal is to move all the disks to the right stack using the middle stack. On each move you can move the uppermost disk from a stack to another stack. In addition, it is not allowed to place a larger disk on a smaller disk.
  
Your task is to find a solution that minimizes the number of moves.
  
Input
The only input line has an integer n: the number of disks.
Output
First print an integer k: the minimum number of moves.
  
After this, print k lines that describe the moves. Each line has two integers a and b: you move a disk from stack a to stack b.
  
Constraints

1 <= n <= 16

Example
  
Input:
2
Output:
3
1 2
1 3
2 3

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class Main {
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int moves = (1<<n)-1;
        System.out.println(moves);
        solve(n,1,2,3);
        System.out.print(res.toString());
    }
    static void solve(int n,int from,int aux,int to){
        if(n == 0) return;
        solve(n-1,from,to,aux);
        res.append(from).append(" ").append(to).append("\n");
        solve(n-1,aux,from,to);
    }
}
