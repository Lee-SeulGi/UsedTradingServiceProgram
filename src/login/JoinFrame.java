package login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
/*
 * 1. 비밀번호가 일치하면 글씨 지우고 체크표시.
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DB;


public class JoinFrame extends JFrame implements ActionListener, KeyListener{


	
private JPanel Alljp;
private JPanel info;
private JPanel namepanel;
private JLabel lblname;
private JTextField tfname;
private JPanel idpanel;
private JLabel lblid;
private JTextField tfid;
private JLabel lblidbothcheck;
private JButton btnidcheck;
private JPanel pwpanel;
private JLabel lblpw;
private JPasswordField tfpw;
private JPanel pwcheckpanel;
private Component lblpwcheck;
private JPasswordField tfpwcheck;
private JLabel lblpwsamecheck;
private JPanel numberpanel;
private JLabel lblnumber;
private JButton btnjoin;
private Vector<String> vecCombo;
private JComboBox<String> combo1;
private JLabel lblstick1;
private JLabel lblstick2;
private JTextField numbertf1;
private JTextField numbertf2;
private Vector<String> vecCombo2;
private JComboBox<String> combo2;
private JPanel areapanel;
private JLabel lblarea;
private JPanel joinpanel;
private JButton btnchiso;
private Container c;
private JPanel agreepanel;
private JCheckBox[] agreecheck;
private JButton btnpwcheck;
private int sign = 0;
private Login login;
private Login lg;
private Font gibonfont;
private Font tffont;
private boolean checkphone;




		//DB연결
		static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
		static String dbID="blue";
		static String dbPassword="1234";


public JoinFrame(String title, Login login) {
	
	this.login = login;
		
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setLocationRelativeTo(this); 
		
		
		Alljp = new JPanel();
		Alljp.setLayout(new BorderLayout());
		Alljp.setBackground(new Color(125, 230, 119));
		Alljp.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));	
		
		gibonfont = new Font("a소나무L", Font.PLAIN, 13);
		tffont = new Font("a소나무L", Font.PLAIN, 11);
		

		setCenter();
		setSouth();
		setNorth();
		
		add(Alljp);
		
		setVisible(true);
		
	}
	
	private void setNorth() {
		JPanel dinojp = new JPanel();
		dinojp.setLayout(null);
		dinojp.setBackground(Color.WHITE);
		dinojp.setPreferredSize(new Dimension(100, 100));
		

		ImageIcon dinomarket = new ImageIcon("images/sodino.png");
		Image img = dinomarket.getImage();
		Image imgsize = img.getScaledInstance(125, 75, Image.SCALE_SMOOTH);
		ImageIcon imgdino = new ImageIcon(imgsize);
		JLabel dino = new JLabel(imgdino);
		dino.setSize(180, 90);
		dino.setLocation(120, 7);
		
		dinojp.add(dino);
		
		Alljp.add(dinojp, BorderLayout.NORTH);
}

	private void setCenter() {
		info = new JPanel();
		info.setBackground(Color.white);
		info.setLayout(new GridLayout(7,1,10,10));
		info.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));	
		
		nameP();
		idP();
		pwP();
		pwcheckP();
		numberP();
		areaP();
		agreeP();
		
		
		info.add(namepanel);
		info.add(idpanel);
		info.add(pwpanel);
		info.add(pwcheckpanel);
		info.add(numberpanel);
		info.add(areapanel);
		info.add(agreepanel);
		Alljp.add(info, BorderLayout.CENTER);
}
	

	private void nameP() {
		namepanel = new JPanel();
		namepanel.setBackground(Color.white);
		namepanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		lblname = new JLabel("이름",JLabel.CENTER);
		lblname.setFont(gibonfont);
		lblname.setPreferredSize(new Dimension(95, 20));
		
		tfname = new JTextField(23);
		tfname.setPreferredSize(new Dimension(23, 25));
		tfname.setFont(tffont);
		/* 체크표시
		JLabel lblOK1 = new JLabel("-", JLabel.CENTER);
		lblOK1.setForeground(new Color(0, 200, 0));
		lblOK1.setPreferredSize(new Dimension(30, 20));
		*/
		namepanel.add(lblname);
		namepanel.add(tfname);
	}
	
	private void idP() {
		idpanel = new JPanel();
		idpanel.setBackground(Color.white);
		idpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblid = new JLabel("아이디", JLabel.CENTER);
		lblid.setPreferredSize(new Dimension(95, 20));
		lblid.setFont(gibonfont);
		tfid = new JTextField(23);
		tfid.setPreferredSize(new Dimension(23, 25));
		tfid.setFont(tffont);
		
		btnidcheck = new JButton("중복확인");
		btnidcheck.addActionListener(this);
		btnidcheck.setFont(tffont);
		btnidcheck.setPreferredSize(new Dimension(100,25));
		btnidcheck.setBackground(new Color(255, 255, 170));
		
		btnidcheck.setFocusPainted(false);
		
		JLabel lblspace1 = new JLabel("");
		lblspace1.setPreferredSize(new Dimension(118, 10));
		
		lblidbothcheck = new JLabel("");	//"사용 가능한 아이디입니다."
		lblidbothcheck.setFont(new Font("a소나무L", Font.PLAIN, 11));
		
		idpanel.add(lblid);
		idpanel.add(tfid);
		idpanel.add(btnidcheck);
		idpanel.add(lblspace1);
		idpanel.add(lblidbothcheck);
	}
	
	private void pwP() {
		pwpanel = new JPanel();
		pwpanel.setBackground(Color.white);
		pwpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblpw = new JLabel("비밀번호", JLabel.CENTER);
		lblpw.setFont(gibonfont);
		lblpw.setPreferredSize(new Dimension(95, 20));
		tfpw = new JPasswordField(23);
		tfpw.setPreferredSize(new Dimension(23, 25));
		tfpw.setFont(tffont);
		pwpanel.add(lblpw);
		pwpanel.add(tfpw);
	}
	
	private void pwcheckP() {
		pwcheckpanel = new JPanel();
		pwcheckpanel.setBackground(Color.white);
		pwcheckpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lblpwcheck = new JLabel("비밀번호 확인",JLabel.CENTER);
		lblpwcheck.setFont(gibonfont);
		lblpwcheck.setPreferredSize(new Dimension(95, 20));
		
		tfpwcheck = new JPasswordField(23);
		tfpwcheck.setPreferredSize(new Dimension(23, 25));
		tfpwcheck.setFont(tffont);
		
		btnpwcheck = new JButton("비밀번호확인");
		btnpwcheck.addActionListener(this);
		btnpwcheck.setFont(tffont);
		btnpwcheck.setPreferredSize(new Dimension(100,25));
		btnpwcheck.setBackground(new Color(255, 255, 170));
		
		JLabel lblspace2 = new JLabel("");
		lblspace2.setPreferredSize(new Dimension(118, 10));
		
		lblpwsamecheck = new JLabel("");	//비밀번호가 같습니다.
		lblpwsamecheck.setFont(new Font("a소나무L", Font.PLAIN, 11));
		
		pwcheckpanel.add(lblpwcheck);
		pwcheckpanel.add(tfpwcheck);
		pwcheckpanel.add(btnpwcheck);
		pwcheckpanel.add(lblspace2);
		pwcheckpanel.add(lblpwsamecheck);
	}
	
	private void numberP() {
		numberpanel = new JPanel();
		numberpanel.setBackground(Color.white);
		numberpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lblnumber = new JLabel("전화번호", JLabel.CENTER);
		lblnumber.setFont(gibonfont);
		lblnumber.setPreferredSize(new Dimension(95, 20));
		
		vecCombo = new Vector<>();		
		vecCombo.add(" 010 ");
		vecCombo.add(" 011 ");
		vecCombo.add(" 016 ");
		vecCombo.add(" 017 ");
		vecCombo.add(" 018 ");
		vecCombo.add(" 019 ");
		combo1 = new JComboBox<>(vecCombo);
		combo1.setBackground(Color.white);
		combo1.setPreferredSize(new Dimension(60,25));
		combo1.setFont(tffont);
		
		lblstick1 = new JLabel(" - ");
		
		numbertf1 = new JTextField(10);
		numbertf1.setPreferredSize(new Dimension(10, 25));
		numbertf1.setFont(tffont);
		numbertf1.addKeyListener(this);
		
		lblstick2 = new JLabel(" - ");
		
		numbertf2 = new JTextField(10);
		numbertf2.setPreferredSize(new Dimension(10, 25));
		numbertf2.setFont(tffont);
		numbertf2.addKeyListener(this);
	
		
		
		numberpanel.add(lblnumber);
		numberpanel.add(combo1);
		numberpanel.add(lblstick1);
		numberpanel.add(numbertf1);
		numberpanel.add(lblstick2);
		numberpanel.add(numbertf2);
	}
	
	private void areaP() {
		areapanel = new JPanel();
		areapanel.setBackground(Color.white);
		areapanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblarea = new JLabel("지역", JLabel.CENTER);
		lblarea.setFont(gibonfont);
		lblarea.setPreferredSize(new Dimension(95, 20));
		vecCombo2 = new Vector<>();		
		vecCombo2.add(" 서울 ");
		vecCombo2.add(" 인천 ");
		vecCombo2.add(" 부산 ");
		vecCombo2.add(" 대전 ");
		vecCombo2.add(" 광주 ");
		vecCombo2.add(" 대구 ");
		vecCombo2.add(" 울산 ");
		vecCombo2.add(" 경기도 ");
		vecCombo2.add(" 강원도 ");
		vecCombo2.add(" 충청북도 ");
		vecCombo2.add(" 충청남도 ");
		vecCombo2.add(" 전라북도 ");
		vecCombo2.add(" 전라남도 ");
		vecCombo2.add(" 경상북도 ");
		vecCombo2.add(" 경상남도 ");
		vecCombo2.add(" 제주 ");
		vecCombo2.add(" 세종 ");
		combo2 = new JComboBox<>(vecCombo2);
		combo2.setBackground(Color.white);
		combo2.setFont(tffont);
		areapanel.add(lblarea);
		areapanel.add(combo2);
	}
	
	private void agreeP() {
		agreepanel = new JPanel();
		agreepanel.setLayout(new GridLayout(3,1,5,5));
		agreepanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		agreepanel.setBackground(Color.white);
		
		String[] question = {"(필수) 서비스 이용약관 동의","(필수) 개인정보 수집 및 이용 동의","(선택) 마케팅 수신동의"};
		
		agreecheck = new JCheckBox[3];
		for (int i = 0; i < agreecheck.length; i++) {
			agreecheck[i] = new JCheckBox(question[i]);
			agreecheck[i].setFont(tffont);
			agreecheck[i].setBackground(Color.white);
			agreepanel.add(agreecheck[i]);
		}
		
		
		
	}

	private void setSouth() {
		joinpanel = new JPanel();
		joinpanel.setLayout(new GridLayout(1,2,20,30));
		joinpanel.setBorder(BorderFactory.createEmptyBorder(15, 90, 55, 90));
		joinpanel.setBackground(Color.white);
		joinpanel.setPreferredSize(new Dimension(100, 90));
		
		btnchiso = new JButton(" 취소 ");
		btnchiso.addActionListener(this);
		btnchiso.setFont(gibonfont);
		btnchiso.setBackground(new Color(255, 255, 170));
		btnjoin = new JButton("가입하기");
		btnjoin.addActionListener(this);
		btnjoin.setFont(gibonfont);
		btnjoin.setBackground(new Color(255, 255, 170));
		
		btnchiso.setFocusPainted(false);
		btnjoin.setFocusPainted(false);
		
		joinpanel.add(btnchiso);
		joinpanel.add(btnjoin);
		
		Alljp.add(joinpanel, BorderLayout.SOUTH);
		
	}


	public static void main(String[] args) {
		new JoinFrame("회원가입", null); 
		DB.DBconnect(dbURL, dbID, dbPassword);
	}

		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String id = tfid.getText();//아이디 tf 받아오기
		
		//아이디 중복확인하는 액션
		if(obj == btnidcheck) {
			if(tfid.getText().trim().length()==0) {						//비어있으면 오류창
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요", "입력", JOptionPane.WARNING_MESSAGE);
				tfid.requestFocus();
				
			}else {		
				//데베에 데이터가 있냐 없냐
				boolean check = checkID(id);
				
				if(check) { 				//데이터가 이미 있으면 오류창
					JOptionPane.showMessageDialog(this, "이미 사용 중인 아이디입니다.", "오류", JOptionPane.ERROR_MESSAGE);
					tfid.setText("");
					tfid.requestFocus();
				}else { 										//데이터가 없다면 라벨로 가능여부 표시
					lblidbothcheck.setText("사용 가능한 아이디입니다.");
					lblidbothcheck.setOpaque(true);				//안하면 라벨에 색 적용안됨.
					lblidbothcheck.setForeground(Color.red);	//글자색
					lblidbothcheck.setBackground(Color.white);	//배경색
				}
				
			} 
		//비밀번호 확인하는 액션	
		}else if(obj == btnpwcheck) {

			if(tfpw.getText().trim().length()==0 || tfpwcheck.getText().trim().length()==0) {						//비어있으면 오류창
				if(tfpw.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요", "입력", JOptionPane.WARNING_MESSAGE);
					tfpw.requestFocus();
				}else {
					JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요", "입력", JOptionPane.WARNING_MESSAGE);
					tfpwcheck.requestFocus();
				}
			}else {			//데베에 데이터가 있냐 없냐
				if(tfpw.getText().trim().equals(tfpwcheck.getText().trim())) { 		
					lblpwsamecheck.setText("비밀번호가 일치합니다.");
					lblpwsamecheck.setOpaque(true);
					lblpwsamecheck.setForeground(Color.red);	//글자색
					lblpwsamecheck.setBackground(Color.white);	//배경색	
					
				}else {	
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					tfpwcheck.setText("");
					tfpwcheck.requestFocus();
				}
			}
		//취소를 누를 때 한번 더 확인하는 창
		}else if(obj == btnchiso) {
			if(JOptionPane.showConfirmDialog(this, "정말 회원가입을 중단하시겠습니까?", "종료"
					, JOptionPane.YES_NO_OPTION
					, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
				lg = new Login("로그인");
			}
		//가입하기 누를 때 1. 하나라도 빈칸이 있으면 오류창 2.아이디체크나 비밀번호 체크를 안하면 오류창
		}else if(obj == btnjoin) {
			if (tfname.getText().trim().length() == 0 || tfid.getText().trim().length() == 0
				|| tfpw.getText().trim().length() == 0 || tfpwcheck.getText().trim().length()==0 
				|| numbertf1.getText().trim().length() == 0 || numbertf2.getText().trim().length() == 0 ){
				JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			}else if(lblidbothcheck.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "아이디 중복확인을 해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}else if(lblpwsamecheck.getText().trim().length()==0) {
				JOptionPane.showMessageDialog(this, "비밀번호 확인을 해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}else if(sign < 0) {
				System.out.println("음수에여");
			}else if(!agreecheck[0].isSelected() || !agreecheck[1].isSelected()) {
				JOptionPane.showMessageDialog(this, "필수 약관에 동의해주세요.", "약관 동의 오류", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				//int no = rs.getInt("user_no");
				String signid = tfid.getText().toString();
				String signname = tfname.getText().toString();
				String signpw = tfpw.getText().toString();
				String signphonenum = (combo1.getSelectedItem().toString() + numbertf1.getText().toString() + numbertf2.getText().toString());
				String signresidence = combo2.getSelectedItem().toString();
				
				
				String sqlSign = "INSERT into User" + "(user_id, user_name, user_pw, user_phonenum, user_res)"
						+ "values('" + signid + "', '" + signname + "', '" + signpw + "', '" + signphonenum + "', '" + signresidence + "')";
				int rs = DB.DBinsert(sqlSign);
				

				JOptionPane.showMessageDialog(this, " 회원가입이 완료되었습니다.\n 로그인을 해주세요.", "회원가입"
						, JOptionPane.PLAIN_MESSAGE);
				lg = new Login("로그인");
				dispose();
			}
		}

	}

private boolean checkID(String id) {
		
		boolean check = false;
		
		String sql = "SELECT user_id FROM User WHERE user_id IN('" + id + "')"; ; //아이디 비밀번호 찾기 sql문
		ResultSet rs = DB.DBselect(sql);
		
		
		try {
			if(rs.next()) {	//sql문에 내용이 있을 때
				check = true;
			} else { //내용이 없으면 false
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return check;
	}

//핸드폰번호 중복 체크
	private boolean CheckPhone(String tel) {
		
		String sql = "SELECT user_phonenum FROM User WHERE user_phonenum IN('" + tel + "')"; //sql문으로 검색
		ResultSet rs = DB.DBselect(sql); 
		
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		checkphone = true; //아이디 중복확인 설정
		return false;
	}
 
	
	//전화번호 숫자만 입력 + 4개 입력되면 다음 tf2로 넘어가도록.(tf1, tf2 다 4개로 제한)
	@Override
	public void keyTyped(KeyEvent e) {
		Object obj = e.getSource();
		
		char c = e.getKeyChar();
		
		if(!Character.isDigit(c)) {
			e.consume();
			return;
		}
		
		if(obj == numbertf1) {
			if(numbertf1.getText().length() >= 4) {
				e.consume();
				numbertf2.requestFocus();
			}
		}
		if(obj == numbertf2) {
			if(numbertf2.getText().length() >= 4) {
				e.consume();
			}
		}
	 }
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


		
	
}