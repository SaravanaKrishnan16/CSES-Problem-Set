A Gray code is a list of all 2^n bit strings of length n, where any two successive strings differ in exactly one bit (i.e., their Hamming distance is one).

Your task is to create a Gray code for a given length n.

Input
The only input line has an integer n.
Output
Print 2^n lines that describe the Gray code. You can print any valid solution.

Constraints

1 <= n <= 16

Example

Input:
2
Output:
00
01
11
10

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int limit = 1 << n;
        for(int i=0;i<limit;i++){
            int gray = i^(i>>1);
            String binary = Integer.toBinaryString(gray);
            while (binary.length()<n){
                binary = "0" + binary;
            }
            bw.write(binary);
            bw.newLine();
        }
        bw.flush();
    }
}
