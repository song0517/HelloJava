package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//20221018 : pw찾을 경우 이메일 또는 문자로 일회성 비밀번호 전송에 사용
public class MailScreen extends JFrame {
	
	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(35, 15);

	// 컴포넌트를 모아놓기 위한 컨테이너
	JPanel center, bottom;
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블
	JTextField fromTxt, toTxt, subjectTxt; // 텍스트필드
	JTextArea contentTxt; // 내용 : 여러라인에 걸쳐서 작성(textarea)
	JButton send, cancel; // 전송, 취소 버튼

	MailApp app = new MailApp();

	//화면만들기
	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());
		
		// 패널설정
		center = new JPanel();
		bottom = new JPanel();
		
		// 라벨세팅
		toLbl = new JLabel("받는 사람");
		toLbl.setPreferredSize(lbl1);
		fromLbl = new JLabel("보내는 사람");
		fromLbl.setPreferredSize(lbl1);
		subjectLbl = new JLabel("제목: ");
		subjectLbl.setPreferredSize(lbl1);
		contentLbl = new JLabel("내용");
		contentLbl.setPreferredSize(lbl2);
		
		// 텍스트필드
		fromTxt = new JTextField(22);
		toTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);
		
		// 버튼
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); //ActionListener 인테페이스 -> 구현객체
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		// 컨테이너 컴포넌트 배치
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		bottom.add(send);
		bottom.add(cancel);
		
		// 윈도우에 컨테이너 배치
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	// 기능을 실행하는 구현객체
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//어떤 객체에 이벤트가 발생했는지 알려줌
			Object src = e.getSource();
			
			if(src == send) {
				System.out.println("보내기 버튼 action Performed");
				String from = fromTxt.getText(); //텍스트 필드에 있는 값 읽어들이기
				String to = toTxt.getText();
				String subject = subjectTxt.getText();
				String content = contentTxt.getText();
//				String[] content2 = content.split(" ");
//				for(int i=0; i<content2.length; i++) {
//					System.out.println(content2[i]);
//				}
				
				if(app.sendMail(from, to, subject, content).equals("Success")){
					//콘솔에 성공여부 출력 : "성공" -> 값 지우기
//					System.out.println("전송성공");
				    
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				} else {
					//"실패"
//					System.out.println("전송실패");
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				}
				
			} else if(src == cancel) {
				System.out.println("취소 버튼 action Performed");
			}
			
		}
	}

	// 화면시작
	public static void main(String[] args) {
		new MailScreen();
	}
}
