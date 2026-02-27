import java.util.Scanner;

public class MergeStringsAlternatively {
    public static void main( String []args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first word");
        String word1 = sc.nextLine();
        System.out.println("Enter second word");
        String word2 = sc.nextLine();
        sc.close();

        Sol1 sol = new Sol1();
        String result = sol.mergeAlternate(word1, word2);
        System.out.println("Merged String: "+result);
    }
}

class Sol1{
    public String mergeAlternate(String s1, String s2){
        StringBuilder sb = new StringBuilder(s1.length()+s2.length());
        int max = Math.max(s1.length(), s2.length());
        for(int i = 0; i < max; i++){
            if(i<s1.length()){
                sb.append(s1.charAt(i));
            }
            if(i<s2.length()){
                sb.append(s2.charAt(i));
            }
        }
        return sb.toString();
    }
}
