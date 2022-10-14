package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12, 9};
		
		// 반복적인 처리.
		//numAry = {12, 21, 34};
		// 케이스 : n1 > n2 > n3  => 풀기  break위치 바꾸는 연습?
		// 케이스 : n1 < n2 < n3  => 풀기
		/*
			int temp=0;
	        int temp2 = 0;

			//1) 4개 -> 3번 비교, 2번비교, 1번비교
	        if(numAry[0] > numAry[1]) {   //34와 12을 비교  34>12
	            temp = numAry[0]; //34
	            numAry[0] = numAry[1]; //12
	            numAry[1] = temp; //34
	        }
	        if(numAry[1] > numAry[2]) {
	            temp = numAry[1];
	            numAry[1] = numAry[2];
	            numAry[2] = temp;
	        }
	        if(numAry[2] > numAry[3]) {
	            temp = numAry[2];
	            numAry[2] = numAry[3];
	            numAry[3] = temp;
	        }
	        //2)
	        if(numAry[0] > numAry[1]) {   
	            temp = numAry[0]; 
	            numAry[0] = numAry[1];
	            numAry[1] = temp; 
	        }
	        if(numAry[1] > numAry[2]) {
	            temp = numAry[1];
	            numAry[1] = numAry[2];
	            numAry[2] = temp;
	        }
	        //3)
	        if(numAry[0] > numAry[1]) {   
	            temp = numAry[0]; 
	            numAry[0] = numAry[1];
	            numAry[1] = temp; 
	        }
	         
	        System.out.println("오름차순 정렬");
	        for(int n : numAry) {
	            System.out.print(n + " ");
	        }
	        System.out.println('\n');
	        
	        if(numAry[0] < numAry[1]) {   
	            temp = numAry[0]; 
	            numAry[0] = numAry[1]; 
	            numAry[1] = temp; 
	        }
	        if(numAry[1] < numAry[2]) {
	            temp = numAry[1];
	            numAry[1] = numAry[2];
	            numAry[2] = temp;
	        }
	        if(numAry[0] < numAry[1]) {   
	            temp = numAry[0]; 
	            numAry[0] = numAry[1];
	            numAry[1] = temp; 
	        }
	        System.out.println("내림차순 정렬");
	        for(int n : numAry) {
	            System.out.print(n + " ");
	        }
	    */
		for(int j=0; j<numAry.length - 1; j++) {
			for(int i=0; i<numAry.length - 1; i++) {
				if(numAry[i] > numAry[i+1]) {
					int temp = 0;
					temp = numAry[i];
					numAry[i] = numAry[i+1];
					numAry[i+1] = temp;
				}
			}
		}
			for(int n : numAry) {
	            System.out.print(n + " ");
	        }
	    
		
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
        
        
		
        /*
			int temp = numAry[0];
			numAry[0] = numAry[2];
			numAry[2] = temp;
			
			for(int n : numAry) {
				System.out.println(n);
			}
		*/
	}
}
