package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		//배열선언, 크기 정하기, 정수를 담을 수 있는 5공간을 만들어서 randomAry에 저장
		int[] randomAry = new int[5];
		//Math.random() : 임의의 숫자를 만들어 준다. 0~1사이의 임의수 생성, 이것은 실수타입이라서 int와 타입이 맞지 않아 에러가 발생. (int)캐스팅을 실수를 정수로 형태 변환해 주기
		// * 100을 통해 우선순위()를 정해서 0~100사이의 임의의 수 생성해서 정수로 바꾸기.  +1을 하면 1~10사이의 임의의 값이 생성.
		randomAry[0] = (int) (Math.random() * 100) + 1;
		randomAry[1] = (int) (Math.random() * 100) + 1;
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;
		
		//임의의 수 중 가장 큰 값은?
		int maxVal = 0;
		for(int i=0; i<5; i++) {
			System.out.println("randomAry[" + i +"]의 값 : " + randomAry[i]);
			if(randomAry[i] > maxVal) {
				maxVal=randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최대값 => " + maxVal);
		
		//임의의 수 중 가장 작은 값은?
		int minVal = randomAry[0];
		for(int i=0; i<5; i++) {
			if(randomAry[i] < minVal) {
				minVal=randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값 중 최소값 => " + minVal);
	}
}
