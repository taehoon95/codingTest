public class maxProfit {

    public static void main(String[] args) {
        int[] prices = {8, 2, 6, 5, 1, 7, 5};
        maxProfit mp = new maxProfit();
        System.out.println(mp.maxP(prices));
    }

    public int maxP(int[] nums){
        int min = nums[0];
        int max = 0;

        // 1. nums 의 길이가 0 이면 0 리턴
        if(nums.length == 0){
            return 0;
        }

        // 2
        for(int i = 0; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
            }else{
                max = Math.max(max, nums[i] - min);
            }
        }

        return max;
    }
}
