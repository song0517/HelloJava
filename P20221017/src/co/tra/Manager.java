package co.tra;

public class Manager {
	private String magId; //관리자ID
	private String magPw; //관리자PW
	private String magName; //관리자이름
	
	//생성자
	public Manager(String magId, String magPw, String magName) {
		this.magId = magId;
		this.magPw = magPw;
		this.magName = magName;
	}

	//get, set
	public String getMagId() {
		return magId;
	}
	public void setMagId(String magId) {
		this.magId = magId;
	}

	public String getMagPw() {
		return magPw;
	}
	public void setMagPw(String magPw) {
		this.magPw = magPw;
	}

	public String getMagName() {
		return magName;
	}
	public void setMagName(String magName) {
		this.magName = magName;
	}
}
