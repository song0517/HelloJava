package co.edu.board;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String resposibility;

	
	public MemberVO(String id, String passwd, String name, String email) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}


	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
