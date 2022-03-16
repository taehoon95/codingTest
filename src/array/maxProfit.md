# 1. maxProfit

## 문제
1. i 번째 요소가 i 일에 주어진 주식의 가격 인 배열이 있다고 가정
2. 최대 한번의 거래만 완료하도록 허용 된 경우 최대 수익을 찾는 알고리즘 설계
3. 주식을 구입하기 전에는 주식을 팔 수 없다.

## Example
1. 입력: [8, 2, 6, 5, 1, 7, 5]
2. 출력: 6
3. 설명: 4 일에 구매 (가격 = 1), 5 일에 판매 (가격 = 7), 이익 = 7 - 1 = 6

## Math.max 함수 이용
- Math.max(인자1, 인자2) = 함수는 두 인자 값 중 큰 값을 리턴하는 함수이다.

## 분석 
1. 8에 샀으면 2를 만나는 순간 버린다.
2. 2를 세팅한다.

3. 6에서 2(현재 가장 작은 값)에 팔고 4를 저장한다.
4. 5에서 2(현재 가장 작은 값)에 팔고 3이랑 4를 비교해서 4를 남긴다.

5. 2에서 1로 작은 값을 세팅한다.

6. 1에서 7을 뺀값 6과 4(기존의값)를 비교한다. 
7. 1에서 5를 뺀값 4와 6(기존의값)을 비교한다. 

- 작은 값 저장 할 변수 필요하다. min
- Math.max 를 이용해서 max 값을 가지고 있으면서 비교할 수 있도록 해야한다. max

```java
public class maxProfit {

    public static void main(String[] args) {
        int[] prices = {8, 2, 6, 5, 1, 7, 5};
        array.maxProfit mp = new array.maxProfit();
        System.out.println(mp.maxP(prices));
    }

    public int maxP(int[] nums) {
        int min = nums[0];
        int max = 0;

        // 1. nums 의 길이가 0 이면 0 리턴
        if (nums.length == 0) {
            return 0;
        }

        // 2.if문 에서 작은 값이 생기면 세팅
        //   else문 에서 nums[i]로 넘어오는 값은 min의 값보다 크다는 뜻이므로 max 값을 계속 비교해서 결국에는 가장 큰 값을 리턴 하게 된다.
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else {
                max = Math.max(max, nums[i] - min);
            }
        }

        return max;
    }
}
```