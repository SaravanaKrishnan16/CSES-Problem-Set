There is a knight on an n \times n chessboard. For each square, print the minimum number of moves the knight needs to do to reach the top-left corner.
  
Input
The only line has an integer n.
Output
Print the number of moves for each square.
  
Constraints
4 <= n <= 1000

Example
Input:
8
Output:
0 3 2 3 2 3 4 5 
3 4 1 2 3 4 3 4 
2 1 4 3 2 3 4 5 
3 2 3 2 3 4 3 4 
2 3 2 3 4 3 4 5 
3 4 3 4 3 4 5 4 
4 3 4 3 4 5 4 5 
5 4 5 4 5 4 5 6 

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {2,2,-2,-2,1,1,-1,-1};
    static final int[] dy = {1,-1,1,-1,2,-2,2,-2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0;
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int next = dist[x][y]+1;
            for(int k=0;k<8;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<n && dist[nx][ny]==-1){
                    dist[nx][ny] = next;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        } 
        System.out.print(sb.toString());
    }
}
