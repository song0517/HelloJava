package co.gui;

import java.awt.BorderLayout;

import javax.swing.*;

//20221017 - UI구성
public class BatchFrame2 extends JFrame{
	
	public BatchFrame2() {
		setTitle("BorderLayout 관리자");
		setSize(300, 250);
		
		//2. 배치관리자 BorderLayout(); -> 특별한 위치에 배치 가능
		//좌우, 위아래 여백 설정 -> ()안에 설정.
		setLayout(new BorderLayout(10, 10));
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		//동서남북 기준으로 배치
		add("North", top);
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		//설정 위에 있을 경우 아래에 있는 코드들이 나타나지 않아 마지막 부분에 해주는 것이 좋다.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//모니터 화면 중앙에 생성
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new BatchFrame2();
	}
}
