/* problem statement

Alice is in a shopping mall to buy books, shirts and shoes. The mall has exactly N different shops and each shop contains all these three items at different prices. Alice has a plan which she will be following. As per her plan, she won't buy the same item from the current shop if she had already bought that item from the shop adjacent to the current shop.

Alice wants to follow her strategy strictly but at the same time she wants to minimize the total money she spends on shopping. You are provided description about all N shops i.e costs of all three items in each shop. You need to help Alice find minimum money that she needs to spend such that she buys exactly one item from every shop.
 =================================
Input
test case: t
number of shop: n
price list: book, shirt, shoes

Example
Input:

1
3
1 50 50
50 50 50
1 50 50

Output:
52
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--!=0){
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            
            for(int i=0; i<n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
            }
            
            int[][] dp = new int[n][3];
            for(int i=0; i<n; i++){
                if(i==0){
                    dp[i][0] = arr[i][0];
                    dp[i][1] = arr[i][1];
                    dp[i][2] = arr[i][2];
                }
                else{
                    dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                    dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                    dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
                }
            }
            int min = Integer.MAX_VALUE;
            
            for(int i=0; i<3; i++){
                if(min>dp[n-1][i]){
                    min = dp[n-1][i];
                }
            }
            System.out.println(min);
        }
    }
}
