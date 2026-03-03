import java.util.Scanner;

public class reverseVowels{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:  ");
        String s = sc.nextLine();
        sc.close();
        Sol5 sol =  new Sol5();
        System.out.println(sol.reverseVowels(s));
    }
}

class Sol5{
    public String reverseVowels(String s){
        char arr[] = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            while(left<right && !isVowel(arr[left])){
                left++;
            }
            while(left<right && !isVowel(arr[right])){
                right--;
            }
            //swap
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}