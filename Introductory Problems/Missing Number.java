You are given all numbers between 1,2,\ldots,n except one. Your task is to find the missing number.

Input
The first input line contains an integer n.
The second line contains n-1 numbers. Each number is distinct and between 1 and n (inclusive).

Output
Print the missing number.

Constraints
2 <= n <= 2 . 10^5

Example
Input:
5
2 3 1 5
Output:
4

----------------------------------------------------------------------------------------------------------

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long total = (long) n*(n+1)/2;
        long sum = 0;
        for (int i=0;i<n-1;i++) {
            sum += sc.nextInt();
        }
        System.out.println(total-sum);
    }
