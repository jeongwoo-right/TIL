```java
import java.io.*;
import java.util.*;

/*
보드 길이: N = 10^3
조각 수: M = 10^5

M개 조각(10^5)
    - 같은 값이 들어있는 인덱스 순회
    - 발견 시, visited 처리 -> 상수배
*/

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 정렬: Key 기준으로만
		// key 기준 정렬된 상태 유지
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		// #1. 삽입: logN (삽입이 잦으면 느려질 수 있다)
		tm.put(-1, 10);
		tm.put(-10, 10);
		tm.put(1, 10);
		tm.put(4, 10);
		tm.put(10, 10);
		tm.put(5, 10);
		
		// #2. 조회: logN
//		System.out.println(tm.get(6));
//		System.out.println(tm.get(10));
//		
//		// #3. 삭제: logN (삭제가 잦으면 느려질 수 있다)
//		System.out.println(tm.remove(-1));
//		System.out.println(tm.remove(100));
		
//		tm.size();
//		tm.clear();
//		tm.isEmpty();
		
		// #4. TreeMap 사용 이유: 이상, 이하, 초과, 미만, 최대, 최소 전부 logN에 찾을 수 있음
		// #1. 가장 작은 key
		System.out.println(tm.firstKey());
		Map.Entry<Integer, Integer> ent = tm.firstEntry();
		System.out.println(ent.getKey() + " " + ent.getValue());
		
		System.out.println(tm.lastKey());
		
		// 가장 큰 key
		ent = tm.lastEntry();
		System.out.println("마지막 key, val: " + ent.getKey() + " " + ent.getValue());
		
		// 이상
		System.out.println(" 3 이상: " + tm.ceilingKey(3));
		
		// 초과
		System.out.println("10 초과: " + tm.higherKey(10));
		
		// 이하
		System.out.println("-1 이하: " + tm.floorKey(-1));
		
		// 미만
		System.out.println(" 0 미만: " + tm.lowerKey(0));
		
		// null 값으로 getKey(), getValue() 등 하면 NullPointerException
//		ent = tm.lowerEntry(-100);	
//		System.out.println(ent.getKey() + " " + ent.getValue());
		
	}
}
```
