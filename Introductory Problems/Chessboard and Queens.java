Your task is to place eight queens on a chessboard so that no two queens are attacking each other. As an additional challenge, each square is either free or reserved, and you can only place queens on the free squares. However, the reserved squares do not prevent queens from attacking each other.
  
How many possible ways are there to place the queens?

Input
The input has eight lines, and each of them has eight characters. Each square is either free (.) or reserved (*).
Output
Print one integer: the number of ways you can place the queens.

Example
  
Input:
........
........
..*.....
........
........
.....**.
...*....
........
Output:
65

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Main {
    static char[][] board = new char[8][8];
    static boolean[] col = new boolean[8];
    static boolean[] diag1 = new boolean[15]; 
    static boolean[] diag2 = new boolean[15];
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<8;i++){
            board[i] = sc.next().toCharArray();
        }
        backtrack(0);
        System.out.println(count);
    }
    static void backtrack(int row){
        if (row == 8){
            count++;
            return;
        }
        for(int c=0;c<8;c++){
            if(board[row][c]=='.'){
                int d1 = row-c+7;
                int d2 = row+c;
                if(!col[c] && !diag1[d1] && !diag2[d2]){
                    col[c] = diag1[d1] = diag2[d2] = true;
                    backtrack(row+1);
                    col[c] = diag1[d1] = diag2[d2] = false;
                }
            }
        }
    }
}

