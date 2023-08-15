/*
Problem Statement
--------------------------
Akhil initially had a binary string† s (possibly of length 0). He performed the following operation several (possibly zero) times:
Add 0 to one end of the string and 1 to the other end of the string.
For example, starting from the string 1011, you can obtain either 010111 or 110110.
You are given Akhil's final string. What is the length of the shortest possible string he could have started with?
† A binary string is a string (possibly the empty string) whose characters are either 0 or 1.


Input
---------------------
Input Format
The first line of the input contains an integer t  — the number of testcases.
The first line of each test case contains an integer n  — the length of Timur's final string.
The second line of each test case contains a string s of length n consisting of characters 0 or 1, denoting the final string.

Output
-----------------
For each test case, output a single nonnegative integer — the shortest possible length of Timur's original string. Note that Timur's original string could have been empty, in which case you should output 0.

Sample Input
----------------------
9
3
100
4
0111
5
10101
6
101010
7
1010110
1
1
2
10
2
11
10
1011011010


Sample Output
-----------------------
1
2
5
0
3
1
0
2
4
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            char[] arr = sc.next().trim().toCharArray();
            int initialLength= findInitialLength(arr, n);
            System.out.println(initialLength);
        }
    }
    public static int findInitialLength(char[] arr, int n){
        int i=0;
        int j=n-1;
        while(i<=j){
            if((arr[i]=='0' && arr[j]=='1') || 
            (arr[i]=='1' && arr[j]=='0')){
                i++;
                j--;
                continue;
            }
            return j-i+1;
        }
        return 0;
    }
}