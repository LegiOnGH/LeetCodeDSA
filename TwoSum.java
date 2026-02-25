import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
    public static void main(String []args){
        Solution1 obj = new Solution1();
        int[] nums = {2,7,11,15};
        int[] result = obj.twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<> ();
        for(int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
