/*
Problem Statement:
___________________
Count Islands

Planet Chinchapokli can be considered a planet of islands. Given a matrix of 1s and 0s which denotes planet Chinchapokli where 1s denote land area and 0s denote water, count the number of islands on planet Chinchapokli.
All connected 1s make a single island.

Input
______________________
first line test case
second line row and column of matrix
further value of matrix


2
4 5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
3 3
1 1 1
0 0 0
1 1 1


Expected Output
___________________

1
2


Output Format
________________________
output a single integer which answers the problem for each test case.


Solution:
_____________________

*/

import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] chinchapokli= new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    chinchapokli[i][j]=sc.nextInt();
                }
            }
            int island=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(chinchapokli[i][j]==1){
                        
                        island++;
                        
                        findPath(chinchapokli, n, m, i, j);
                    }
                }
            }
            // System.out.println(Arrays.deepToString(chinchapokli));
            System.out.println(island);
        }
    }
    public static void findPath(int[][] chinchapokli, int n, int m, int row, int column){
        if(row<0 || column<0 || row>=n || column>=m || chinchapokli[row][column]==0){
            return;
        }
        chinchapokli[row][column]=0;
        findPath(chinchapokli, n, m, row+1, column);
        findPath(chinchapokli, n, m, row-1, column);
        findPath(chinchapokli, n, m, row, column+1);
        findPath(chinchapokli, n, m, row, column-1);
        // chinchapokli[row][column]=2;
        
    }
}