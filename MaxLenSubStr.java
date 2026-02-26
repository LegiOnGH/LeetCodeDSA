import java.util.HashMap;
import java.util.Scanner;

public class MaxLenSubStr {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");

        String input = sc.nextLine();

        Solution3 obj = new Solution3();

        int result = obj.lengthOfLongestSubstring(input);

        System.out.println("Longest substring length: " + result);

        sc.close();
    }
}

class  Solution3{
    public int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
