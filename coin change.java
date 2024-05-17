/* problem statment

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

link: https://leetcode.com/problems/coin-change/description/
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int[][] dp = new int[n+1][amount+1];
        minimumCoin(arr, n, amount, dp);
    }
    
    public static void minimumCoin(int[] arr, int n, int amount, int[][] dp){
        for(int i=1; i<=amount; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    int take = dp[i][j-arr[i-1]];
                    if(take!=Integer.MAX_VALUE)
                        take+=1;
                        
                    dp[i][j] = Math.min(dp[i-1][j], take);
                }
            }
        }
        System.out.println(dp[n][amount] != Integer.MAX_VALUE ? dp[n][amount]: -1);
    }
}
