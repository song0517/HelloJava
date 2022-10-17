package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

// 20221017 - UI
public class ComponentExam extends JFrame{
	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300,  250));
		
		//컨테이너 : component를 묶어서 한번에 나타내기...?
		//기본설정 : FlowLayout 배치, ()안에 설정 관리
		JPanel panel = new JPanel();
		
		//라벨 생성 : 설명위주로 작성
		JLabel label1 = new JLabel("Color Label");
		label1.setForeground(Color.yellow);
		label1.setFont(new Font("Arial", Font.ITALIC, 20));
		//라벨의 값을 지정하고 싶으면 setText를 사용해서 변경하고 싶은 텍스트 설정.
		label1.setText("Yellow Font");
		
		JLabel label2 = new JLabel("Font Label");
		label2.setFont(new Font("Arial", Font.BOLD, 25));
		label2.setForeground(Color.GREEN);
		
		//이미지 넣기 -> 이미지 크기 지정 다시 파악
		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("C:/Temp/flower.jpg");
		label3.setIcon(icon);
		//이미지 크기 설정, dimension->너비와 높이 지정.
		label3.setPreferredSize(new Dimension(200, 200));
		
		//컨테이너에 라벨 부착
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		//윈도우에 부착
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new ComponentExam();
	}
}
