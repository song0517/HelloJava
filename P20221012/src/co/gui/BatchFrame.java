package co.gui;

import java.awt.FlowLayout;

import javax.swing.*;

//20221017 - UI구성
public class BatchFrame extends JFrame{
	
	public BatchFrame() {
		setTitle("배치관리자 UI");
		setSize(300, 250);
		
		//레이아웃 설정 - 화면구성
		
		//1. 배치관리자 FlowLayout(); -> 오른쪽으로 순차적으로 정렬, 공간이 없을 경우 다음 줄로 넘어가서 정렬.
		setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("취소");
		JButton btn3 = new JButton("추가");
		JButton btn4 = new JButton("수정");
		JButton btn5 = new JButton("삭제");
		JButton btn6 = new JButton("조회");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BatchFrame();
	}
}
