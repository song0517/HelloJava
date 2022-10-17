package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

//20221017 - UI
public class ComponentExam2 extends JFrame {

	public ComponentExam2() {
		setTitle("입력필드 UI");
		setSize(300, 150);
		//공통되는 속성 따로 설정하여 변수이름만 넣기.
		Dimension lblDim = new Dimension(60, 16);

		setLayout(new BorderLayout());
		
		//패널 2개 사용해서 구역 나누기.
		JPanel center = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel();
		
		//center 패널
		// 입력할 수 있는 텍스트 필드 생성 : 아이디 비번 입력창
		JLabel idLb1 = new JLabel("id");
		idLb1.setPreferredSize(lblDim);
		JLabel pwLb1 = new JLabel("password");
		pwLb1.setPreferredSize(lblDim);
	
		//크기 지정 : 괄호안에 매개값 지정
		JTextField idTxt = new JTextField(23);
		JPasswordField pwTxt = new JPasswordField(23);  //passwordfield이용해서 패스워드 부분 점으로 표시되게 설정.
		
		center.add(idLb1);
		center.add(idTxt);
		center.add(pwLb1);
		center.add(pwTxt);
		
		//bottom 패널
		JButton btn = new JButton("확인");
		bottom.add(btn);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComponentExam2();
	}
}
