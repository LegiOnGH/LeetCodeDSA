import java.util.Scanner;

public class GCDstrings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String str2 = sc.nextLine();
        sc.close();

        Sol2 sol = new Sol2();
        System.out.println("GCD of two strings: "+ sol.gcdOfStrings(str1, str2));
    }
}

class Sol2{
    public String gcdOfStrings(String str1, String str2){
        if(!(str1+str2).equals(str2+str1)){
            return "Not exists";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
    public int gcd(int s1, int s2){
        if(s2 == 0)
            return s1;
        return gcd(s2, s1 % s2);
    }
}