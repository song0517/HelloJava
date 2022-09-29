package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12};
		
		// 반복적인 처리.
		//numAry = {12, 21, 34};
		// 케이스 : n1 > n2 > n3  => 풀기  break위치 바꾸는 연습?
		// 케이스 : n1 < n2 < n3  => 풀기
		
//		if(numAry[0] > numAry[1]) {   //34와 21을 비교  32>21
//			int temp = numAry[0]; //34
//			numAry[0] = numAry[1]; //21
//			numAry[1] = temp; //34
//		}
//		
//		for(int n : numAry) {
//			System.out.println(n);
//		}
//		

        int temp=0;

        for (int i = 0; i < numAry.length; i++) {
            for (int j = i+1; j < numAry.length; j++) {
                if(numAry[i] > numAry[j]) {
                    temp = numAry[i];
                    numAry[i]=numAry[j];
                    numAry[j]=temp;
                }
            }
        }
        for(int i : numAry) {
            System.out.println(i);
        }
        System.out.println("------------------");

        temp=0;

        for (int i = 0; i < numAry.length; i++) {
            for (int j = i+1; j < numAry.length; j++) {
                if(numAry[i] < numAry[j]) {
                    temp = numAry[i];
                    numAry[i]=numAry[j];
                    numAry[j]=temp;
                }
            }
        }

        for(int i : numAry) {
            System.out.println(i);
        }
	}
}
