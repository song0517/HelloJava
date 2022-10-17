package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.DomainCombiner;

//*를 붙이면 모든 요소 import
import javax.swing.*;

//20221017 - UI구성
public class MyFrame extends JFrame {

	public MyFrame() {

		// 윈도우 타이틀 지정
		setTitle("윈도우 UI");
		// 윈도우 크기
		setSize(300, 250);

		// 배치관리자
		setLayout(new FlowLayout());

		// 버튼 생성
		JButton btn = new JButton("확인");
		JButton btn2 = new JButton("취소");

		// 버튼을 눌렀을때 이벤트 발생 - 매개값에 설정되어 있는 인터페이스(동작) 실행
//		btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("확인버튼 클릭 ok");
//			}
//		});
		
		//람다표현식, 한줄일 때는 중괄호 생략 가능.
		btn.addActionListener(e -> System.out.println("확인버튼 클릭 ok"));
		
		btn2.addActionListener((e) -> {
			System.out.println("취소버튼 클릭 ok");
			// 버튼을 눌렀을 때 프로그램 종료.
			System.exit(0);
		});

		// 컨트롤 등록
		add(btn);
		add(btn2);

		// 화면에 나타나도록 설정
		setVisible(true);
		// X버튼을 눌러서 화면 종료, 모두 종료.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
