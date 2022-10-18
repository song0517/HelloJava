package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//20221018 : pw찾을 경우 이메일 또는 문자로 일회성 비밀번호 전송에 사용
public class SmsScreen extends JFrame {
	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(35, 15);
	
	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt;
	JTextArea contentText;
	JButton send, cancel;
	
	SmsApp app = new SmsApp();
	
	public SmsScreen() {
		setTitle("문자 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());
		
		center = new JPanel();
		bottom = new JPanel();
		
		toLbl = new JLabel("받는 사람");
		toLbl.setPreferredSize(lbl1);
		fromLbl = new JLabel("보내는 사람");
		fromLbl.setPreferredSize(lbl1);
		contentLbl = new JLabel("내용");
		contentLbl.setPreferredSize(lbl2);
		
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		contentText = new JTextArea(10, 25);
		
		send = new JButton("보내기");
		send.addActionListener(new SmsActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new SmsActionListener());
		
		center.add(toLbl);
		center.add(toTxt);
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(contentLbl);
		center.add(contentText);
		
		bottom.add(send);
		bottom.add(cancel);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	class SmsActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			if(src == send) {
				System.out.println("보내기 버튼 실행");
				String to = toTxt.getText();
				String from = fromTxt.getText();
				String content = contentText.getText();
				
				app.sendSms(to, from, content);
				
			} else if(src == cancel) {
				System.out.println("취소 버튼 실행");
			}
			
		}
	}
	
	public static void main(String[] args) {
		new SmsScreen();
	}
}
