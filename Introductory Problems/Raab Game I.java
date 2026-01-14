Consider a two player game where each player has n cards numbered 1,2,...,n. On each turn both players place one of their cards on the table. The player who placed the higher card gets one point. If the cards are equal, neither player gets a point. The game continues until all cards have been played.
  
You are given the number of cards n and the players' scores at the end of the game, a and b. Your task is to give an example of how the game could have played out.
  
Input
The first line contains one integer t: the number of tests.
Then there are t lines, each with three integers n, a and b.
  
Output
For each test case print YES if there is a game with the given outcome and NO otherwise.
If the answer is YES, print an example of one possible game. Print two lines representing the order in which the players place their cards. You can give any valid example.
  
Constraints

1 <= t <= 1000
1 <= n <= 100
0 <= a,b <= n

Example
  
Input:
5
4 1 2
2 0 1
3 0 0
2 1 1
4 4 1
Output:
YES
1 4 3 2
2 1 3 4
NO
YES
1 2 3
1 2 3
YES
1 2
2 1
NO

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x==0 && y==0){
                System.out.println("YES");
                for(int i=1;i<=n;i++) System.out.print(i+" ");
                System.out.println();
                for(int i=1;i<=n;i++) System.out.print(i+" ");
                System.out.println();
                continue;
            }
            if(x==0||y==0||x+y>n){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            for(int i=1;i<=n;i++) System.out.print(i+" ");
            System.out.println();
            int offset = n-x-y;
            for(int i=1;i<=offset;i++){
                System.out.print(i+" ");
            }
            for(int i=offset+x+1;i<=n;i++){
                System.out.print(i+" ");
            }
            for(int i=offset+1;i<=offset+x;i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
