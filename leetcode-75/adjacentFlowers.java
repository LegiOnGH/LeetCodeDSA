import java.util.Scanner;

public class adjacentFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of plots: ");
        int plot = sc.nextInt();
        int flowerbed[] = new int[plot];
        System.out.println("Enter if plot is planted: "); //1 for planted, 0 for not
        for(int i = 0; i < plot; i++){
            flowerbed[i] = sc.nextInt();
        }
        System.out.println("Enter no. of flowers to be planted: ");
        int  n = sc.nextInt();
        sc.close();
        
        Sol4 sol = new Sol4();
        System.out.println(sol.canPlaceFlowers(flowerbed, n));
    }
}

class Sol4{
    public boolean canPlaceFlowers(int []flowerbed, int n){
        int count = 0;
        for(int i = 0; i < flowerbed.length ; i++){
            if(flowerbed[i] == 0){
                int left = (i == 0)? 0 : flowerbed[i-1];
                int right = (i == flowerbed.length - 1)? 0 : flowerbed[i+1];
                if(left == 0 && right == 0){
                    flowerbed[i] = 1;
                    count++;
                    if(count>=n) return true;
                }
            }
        }
        return count>=n;
    }
}