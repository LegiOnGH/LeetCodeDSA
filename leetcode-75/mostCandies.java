import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mostCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of kids: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter candies for each kid: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Sol3 sol = new Sol3();
        System.out.println("Enter no. of extra candies: ");
        int extra = sc.nextInt();
        sc.close();

        System.out.println(sol.kidsWithCandies(arr, extra));
    }
}

class Sol3{
    public List<Boolean> kidsWithCandies(int []candies, int extraCandies){
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for(int candy : candies){
            if(candy > max){
                max = candy;
            }
        }
        for(int candy : candies){
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
