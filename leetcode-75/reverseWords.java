import java.util.Scanner;

public class reverseWords{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        sc.close();
        
        Sol6 sol = new Sol6();
        System.out.println(sol.reverseWords(s));
    }
}

class Sol6{
    public String reverseWords(String s){
        String[] word = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = word.length - 1; i >= 0 ; i--){
            result.append(word[i]);

            if(i != 0) result.append(" ");
        }
        return result.toString();
    }
}