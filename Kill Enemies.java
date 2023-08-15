/*
Problem Statement
-------------------------

You are a professional killer and planning to kill enemies standing in a row. Killing each enemy has a certain amount of points, the only constraint stopping you from killing each of them is that adjacent enemies have a bomb system connected and it will automatically blast if two adjacent enemies are killed on the same night.
Given an integer array nums containing N space-separated integers, representing the number of points gained after killing each enemy, print the maximum amount of points you can earn tonight without getting bombed.


input
--------------------
First-line of each test case contains an integer n, the size of the array nums Second-line of each test case contains n integers.


Output
----------------------
For each test case, print the answer in a new line.


Sample Input
--------------------
2
4
1 2 3 1
5
2 7 9 3 1


Sample Output
------------------------
4
12


*/

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i]= sc.nextInt();
            }
            int[] result = new int[n];
            findMaximumScore(arr, result, n);
            System.out.println(result[n-1]);
            
        }
    }
    public static void findMaximumScore(int[] arr,int[] result, int n){
        for(int i=0; i<n; i++){
            if(i==0){
                result[i]= arr[i];
            }
            else if(i==1){
                result[i]=Math.max(arr[i], arr[i-1]);
            }
            else{
                result[i] = Math.max(result[i-1], result[i-2]+arr[i]);
            }
        }
    }
}