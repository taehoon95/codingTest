# 2. subArray

## 문제
1. Integer array nums,k 가 있다.
2. return the total number of continuous subarrays whose equals to k.

## Example
1. int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
2. int k = 7 
3. return 값: 4

## 1. 이중 for 문 이용

### 분석
1. 이중 for 문 돌면서 sum 과 k 값이 동일한 경우 count + 1 해준다.
2. 내부의 for 문에서 int j = i 로 초기 조건을 준다.
   - 주어진 배열을 차례대로 잘라서 sum 값을 비교할 수 있게 해준다.


## 2. map 을 이용
- map.getOrDefault( key, defalutValue) 함수를 이용
  - key 값이 있으면 기존에 있던 값을 사용하고 없으면 defalutValue를 사용한다.

1. 배열의 값의 합을 더한 변수 sum 을 map 의 key 로 이용한다.
2. map.put(0, 1) 로 세팅 해 둔다.
3. map.put(sum, map.getOrDefault(sum, 0) + 1) 을 이용해 키가 이미 존재 하는 경우 값에 + 1 해준다.
4. 기준점으로 k 를 잡고 sum - k 값을 키로 가지는 map 이 생길 때마다 count + 1 을 해준다.

```java
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

    // 1. 이중 for문 이용
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
    
    // 2. map을 이용
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
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```