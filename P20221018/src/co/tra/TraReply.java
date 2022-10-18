package co.tra;

public class TraReply {
	private int traId; //과목ID
	private String reContent; //후기 내용
	private String reWriter; //후기 작성자
	private String reDate; //후기 작성시간
	
	//생성자
	public TraReply(int traId, String reContent, String reWriter, String reDate) {
		this.traId = traId;
		this.reContent = reContent;
		this.reWriter = reWriter;
		this.reDate = reDate;
	}

	//get, set
	public int getTraId() {
		return traId;
	}
	public void setTraId(int traId) {
		this.traId = traId;
	}

	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReWriter() {
		return reWriter;
	}
	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	@Override
	public String toString() {
		return "후기: " + reContent + ", 작성자ID: " + reWriter + ", 작성일자: " + reDate;
	}
}
