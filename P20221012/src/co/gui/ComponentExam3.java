package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//20221017 - UI
//간단한 계산기
public class ComponentExam3 extends JFrame {

	// 키에 들어갈 값 배열 선언
	String[] keys = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/" };
	// 버튼이 들어갈 배열 선언...
	JButton[] keyBtn = new JButton[16];
	String displayText = "";
	String left, right;

	public ComponentExam3() {
		setTitle("계산기 UI");
		// 만들어지는 위치(x,y), 윈도우 크기 지정.
		setBounds(100, 100, 300, 220);

		setLayout(new FlowLayout());

		// display 정보를 출력하기 위한 panel
		JPanel displayPanel = new JPanel();
		JTextField display = new JTextField("0", 20); // (초기값, 필드크기)
		display.setHorizontalAlignment(JTextField.RIGHT); //텍스트필드 오른쪽 정렬
		displayPanel.add(display);

		// 버튼을 생성하기 위한 panel
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < keyBtn.length; i++) {
			// keys의 인덱스 값으로 라벨 부착, keyBtn배열에 i번째에 keys i번째 값을 넣어준다.
			keyBtn[i] = new JButton(keys[i]);
			
			// 버튼 이벤트
			keyBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//버튼이 가지고 있는 메소드 사용..., 해당되는 값을 읽어오기..
					//console에 출력.
					System.out.println(((JButton) e.getSource()).getText());
					
					//display에 값 담기
					String keyOper = ((JButton) e.getSource()).getText();
					// 계산처리.
					if(keyOper.equals("=")) {
						left = displayText.substring(0, displayText.indexOf("+"));
						right = displayText.substring(displayText.indexOf("+") + 1);
						//처음은 string타입이기 때문에 int타입을 변경 후 출력할 때 다시 string타입으로 변경
						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right));
						display.setText(displayText);
						//actionPerformed 종료.
						return;
					}
					
					if(keyOper.equals("C")) {
						displayText = "0";
						display.setText(displayText);
						return;
					}
				
					displayText += keyOper;
					display.setText(displayText);
				}
			});
			
			// 만들어진 keyBtn을 keyPanel에 추가.
			keyPanel.add(keyBtn[i]);
		}

		add(displayPanel);
		add(keyPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ComponentExam3();
	}
}
