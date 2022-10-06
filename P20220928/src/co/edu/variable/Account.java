package co.edu.variable;

public class Account {
//	private String accNO;  // 계좌번호, 두단어의 조합: 2번째 첫번째 대문자.
//	private String owner; // 예금주
//	private int balance; // 예금액. 잔고
	
	 String accNO;  // 계좌번호, 두단어의 조합: 2번째 첫번째 대문자.
	 String owner; // 예금주
	 int balance; // 예금액. 잔고
	
	// setter, getter 정의
	//계좌번호
	void setAccNo(String accNo) {
		this.accNO = accNo;
	}
	String getAccNo() {
		return this.accNO;
	}
	
	//예금주
	void setOwner(String owner) {
		this.owner = owner;
	}
	String getOwner() {
		return this.owner;
	}
	
	//예금액
	void setBalance(int balance) {
		this.balance = balance;
	}
	int getBalance() {
		return this.balance;
	}
	
	public String showInfo() {
		return "이름은 " + this.owner + "이고 계좌번호는 " + this.accNO + "입니다.";
	}
	@Override
	public String toString() {
		return "Account [accNO=" + accNO + ", owner=" + owner + ", balance=" + balance + "]";
	}
	
	
}


