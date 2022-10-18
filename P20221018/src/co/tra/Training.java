package co.tra;

public class Training {
	private int traId; //과목ID
	private String traName; //과목이름
	private String tName; //강사
	private String traTime; //수업시간
	private String traDay; //수업요일
	private int stCo; //가능한 인원수
	private int checkCo; //현재 등록 인원
	
	//생성자
	public Training(int traId, String traName, String tName, String traTime, String traDay, int stCo, int checkCo) {
		this.traId = traId;
		this.traName = traName;
		this.tName = tName;
		this.traTime = traTime;
		this.traDay = traDay;
		this.stCo = stCo;
		this.checkCo = checkCo;
	}

	//get, set
	public int getTraId() {
		return traId;
	}
	public void setTraId(int traId) {
		this.traId = traId;
	}

	public String getTraName() {
		return traName;
	}
	public void setTraName(String traName) {
		this.traName = traName;
	}

	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}

	public String getTraTime() {
		return traTime;
	}
	public void setTraTime(String traTime) {
		this.traTime = traTime;
	}

	public String getTraDay() {
		return traDay;
	}
	public void setTraDay(String traDay) {
		this.traDay = traDay;
	}

	public int getStCo() {
		return stCo;
	}
	public void setStCo(int stCo) {
		this.stCo = stCo;
	}

	public int getCheckCo() {
		return checkCo;
	}
	public void setCheckCo(int checkCo) {
		this.checkCo = checkCo;
	}

	@Override
	public String toString() {
		return "과목ID: " + traId + ", 과목이름: " + traName + ", 강사: " + tName + ", 수업시간: " + traTime
				+ ", 수업 요일: " + traDay + ", 가능한 인원: " + stCo + "명" + ", 등록인원" + checkCo + "명";
	}
}
