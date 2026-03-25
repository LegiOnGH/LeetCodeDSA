package HashMapSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EqualRowColPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter grid size: ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter row "+ i +": ");
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        Sol23 sol = new Sol23();
        System.out.println("Number of equal row and column pairs: "+ sol.equalPairs(grid));
    }
}
/*
https://leetcode.com/problems/equal-row-and-column-pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

HashMap / Matrix Traversal / Pattern Matching

Approach:
• The goal is to count how many rows are exactly equal to columns.
• Use a HashMap to store rows and their frequencies.
• Traverse each row:
  - Convert the row into a List<Integer>.
  - Store it in the map with its frequency.
• Then traverse each column:
  - Build a List<Integer> representing the column.
  - Check if this column list exists in the map.
  - If it exists, add its frequency to the count.
• This works because List comparison checks both values and order.

Time Complexity:
• O(n³)
• There are n rows and n columns, and constructing each list takes O(n).
• So total ≈ O(n² * n) = O(n³).

Space Complexity:
• O(n²)
• The map stores up to n lists, each of size n.
*/
class Sol23{
    public int equalPairs(int[][] grid){
        int n = grid.length;
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0)+ 1);
        }
        int count = 0;
        for(int j = 0; j < n; j++){
            List<Integer> col = new ArrayList<>();
            for(int i = 0; i < n; i++){
                col.add(grid[i][j]);
            }
            count += map.getOrDefault(col, 0);
        }
        return count;
    }
}