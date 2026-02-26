import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TwoSum{
    public static void main(String []args){
        Solution1 obj = new Solution1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers:");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for(int i = 0; i < input.length; i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        sc.close();
        List<int[]> results = obj.twoSum(nums, target);
        for(int[] pair : results){
            System.out.println(Arrays.toString(pair));
        }
    }
}

class Solution1 {
    public List<int[]> twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<> ();
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result.add(new int[] {map.get(complement), i});
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
