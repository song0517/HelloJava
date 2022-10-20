package co.gui.dao;

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

public class EmpScreen extends JFrame implements ActionListener, MouseListener {

	// 입력항목 처리 컴포넌트
	private String[] labels = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
	private JTextField[] fields = new JTextField[6];

	// 컨테이너 역할
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;

	// 데이터를 테이블 형식으로 그려주겠다.
	private JTable table;

	// 이벤트 일으키기 위한 버튼
	private JButton addBtn, delBtn, findBtn, initBtn;

	// 이벤트 처리
	EmpDAO dao = new EmpDAO();
	List<EmployeeVO> list;

	public EmpScreen() {
		setTitle("사원정보 관리 화면");
		setLayout(new BorderLayout(5, 5));

		// top패널에 부착될 컴포넌트들
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}

		// center패널 추가
		String[] headers = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		// 마우스 이벤트 발생 처리
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);

		// right 패널(버튼) 추가
		rightPanel = new JPanel(new GridLayout(4, 1));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");

		// empscreen 인스턴스를 가리킨다 -> this
		// 이벤트 실행
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);

		// 위 입력항목들 배치
		add("North", topPanel);
		add("Center", centerPanel);
		add("East", rightPanel);

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	} // end of EmpScreen()

	// DB 조회 후 table 결과 반영
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		// 화면에 조회된 결과 있으면 clear
		int allCnt = model.getRowCount();
		for(int i=0; i<allCnt; i++) {
			// 화면에서 하나씩 지우겠다. 지우면 다음행도 1번째행이기 때문에 0으로
			model.removeRow(0);
		}
		String[] record = new String[6];

		list = dao.empList(new EmployeeVO(0, fields[1].getText(), fields[2].getText(), fields[3].getText(), fields[4].getText(), fields[5].getText()));
		for (int i = 0; i < list.size(); i++) {
			// 각각에 어떤 값을 넣을지 설정
			record[0] = String.valueOf(list.get(i).getEmployeeId());
			record[1] = String.valueOf(list.get(i).getFirstName());
			record[2] = String.valueOf(list.get(i).getLastName());
			record[3] = String.valueOf(list.get(i).getEmail());
			record[4] = String.valueOf(list.get(i).getHireDate());
			record[5] = String.valueOf(list.get(i).getJobId());

			// 가져온 값들 model에 추가
			model.addRow(record);
		}
	}

	// 삭제위한 메소드.
	public void removeData() {
		// 선택된 row(행 번호)위치 알기
		int selectedRow = table.getSelectedRow();
		if(selectedRow < 0) {
			return;
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// 선택되어져 있는 인덱스 값을 기준으로 몇번째 컬럼의 값을 가져오고 싶은지 설정(숫자 변경 0,1,2...)
		// 0은 사원번호열의 값 가져오기
		int empId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));

		//DB에서 삭제
		dao.deleteEmp(empId);
		
		//화면에서도 삭제
		model.removeRow(selectedRow);
	}
	
	// 등록위한 메소드
	public void addData() {
		String[] records = new String[6];
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0; i<fields.length; i++) {
			records[i] = fields[i].getText();
		}
		
		EmployeeVO emp = new EmployeeVO(0, records[1], records[2], records[3], records[4], records[5]);
		dao.insertEmp(emp);
		//String.valueOf를 통해 int타입을 String 타입으로 바꾸기
		records[0] = String.valueOf(emp.getEmployeeId());
		
		model.addRow(records);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼이 눌러졌는지 구분 코드
		// 이벤트가 발생한 것이 무엇인지 구분
		Object src = e.getSource();

		if (src == addBtn) {
			addData();
		} else if (src == delBtn) {
			removeData();
		} else if (src == findBtn) {
			searchData();
			
		} else if (src == initBtn) {

		}
	} // end of actionPerformend(ActionEvent e)

	// 마우스 이벤트 처리.
	@Override
	public void mouseClicked(MouseEvent e) {
		// table 이벤트.
	}

	// 프로그램의 시작
	public static void main(String[] args) {
		new EmpScreen();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

} // end of class.
