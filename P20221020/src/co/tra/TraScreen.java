package co.tra;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TraScreen extends JFrame implements ActionListener, MouseListener{
	private static final MouseEvent MouseEvent = null;
	private String[] labels = {"강사ID", "강사PW", "강사이름"};
	private JTextField[] fields = new JTextField[3];
	
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;
	
	private JTable table;
	
	private JButton addBtn, findBtn, delBtn, updBtn;
	
	TrainingDAO dao = new TrainingDAO();
	List<Manager> list;
	
	public TraScreen() {
		setTitle("강사 관리 화면");
		setLayout(new BorderLayout(5,5));
		
		topPanel = new JPanel(new GridLayout(3, 2));
		for(int i=0; i<labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		
		String[] headers = {"강사ID", "강사이름"};
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);
		
		rightPanel = new JPanel(new GridLayout(4,1));
		addBtn = new JButton("강사 추가");
		findBtn = new JButton("강사 조회");
		delBtn = new JButton("강사 삭제");
		updBtn = new JButton("강사 수정");
		
		addBtn.addActionListener(this);
		findBtn.addActionListener(this);
		delBtn.addActionListener(this);
		updBtn.addActionListener(this);
		
		rightPanel.add(addBtn);
		rightPanel.add(findBtn);
		rightPanel.add(delBtn);
		rightPanel.add(updBtn);
		
		add("North", topPanel);
		add("Center", centerPanel);
		add("East", rightPanel);
		
		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		int allCnt = model.getRowCount();
		for(int i=0; i<allCnt; i++) {
			model.removeRow(0);
		}
		
		String[] record = new String[2];
		
		list = dao.magList(new Manager(fields[0].getText(), fields[1].getText(), fields[2].getText()));
		for(int i=0; i<list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getMagId());
			record[1] = String.valueOf(list.get(i).getMagName());
			
			model.addRow(record);
		}
	}
	
	public void addData() {
		String[] records = new String[3];
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0; i<fields.length; i++) {
			records[i] = fields[i].getText();
		}
		
		Manager mag = new Manager(records[0], records[1], records[2]);
		dao.magInsert(mag);
		
		model.addRow(records);
		
		for(int i=0; i<fields.length; i++) {
			fields[i].setText(null);
		}
	}
	
	public void removeData() {
		int selectedRow = table.getSelectedRow();
		if(selectedRow < 0) {
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String magId = (String) model.getValueAt(selectedRow, 0);
		
		model.removeRow(selectedRow);
	}
	
	public void updateData() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == addBtn) {
			addData();
			System.out.println("추가 완료");
		} else if (src == findBtn) {
			searchData();
			System.out.println("조회 완료");
		} else if (src == delBtn) {
			removeData();
			System.out.println("삭제 완료");
		} else if (src == updBtn) {
			updateData();
			System.out.println("수정완료");
		}
	}
	
	public static void main(String[] args) {
		new TraScreen();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = table.getSelectedRow();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String magId = (String) model.getValueAt(selectedRow, 0);
//		model.removeRow(selectedRow);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
