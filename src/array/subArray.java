package array;

import java.util.HashMap;

public class subArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;

        subArray sub1 = new subArray();
        int res1 = sub1.subArr1(nums, k);
        int res2 = sub1.subArr2(nums, k);

        System.out.println(res1);
        System.out.println("----------");
        System.out.println(res2);
    }

    private int subArr2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            // map.getOrDefault( key, defalutValue)
            // key 값이 있으면 기존에 있던 값을 사용하고 없으면 defalutValue를 사용한다.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private int subArr1(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum  += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }


}
