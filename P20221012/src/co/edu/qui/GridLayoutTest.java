package co.edu.qui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame{
	JButton[] jbtn = new JButton[16];
	String[] keypad = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};
	JPanel panel;
	JTextField display;
	JPanel displayPanel;
	
	GridLayoutTest() {
		setTitle("ui test");
		
		setLayout(new GridLayout(4,4));
		setBounds(10, 10, 300, 350);
		
		display = new JTextField();
		display.setAlignmentY(RIGHT_ALIGNMENT);
		displayPanel.add(display);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
//		for (int i=0; )
	}
}
