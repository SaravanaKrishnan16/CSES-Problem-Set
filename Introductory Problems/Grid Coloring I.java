You are given an n\times m grid where each cell contains one character A, B, C or D.
  
For each cell, you must change the character to A, B, C or D. The new character must be different from the old one.
  
Your task is to change the characters in every cell such that no two adjacent cells have the same character.
  
Input
The first line has two integers n and m: the number of rows and columns.
The next n lines each have m characters: the description of the grid.
  
Output
Print n lines each with m characters: the description of the final grid.
You may print any valid solution.
If no solution exists, just print IMPOSSIBLE.
  
Constraints

1 <= n,m <= 500

Example
  
Input:
3 4
AAAA
BBBB
CCDD
Output:
CDCD
DCDC
ABAB

-----------------------------------------------------------------------------------------------------------------------------

  
import java.io.*;

class Main {
    static final char[][] cs = {{'A','B'},{'C','D'}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        StringBuilder out = new StringBuilder();
        for(int i=0;i<n;i++){
            String line = br.readLine();  
            for(int j=0;j<m;j++){
                char c = line.charAt(j);
                boolean odd = ((i+j)&1)==1;
                boolean small = c<'C';
                out.append(cs[small ? 1:0][odd ? 1:0]);
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }
}
