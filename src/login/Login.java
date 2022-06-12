package login;
// 수정

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DB;
import main.MainFrame;


public class Login extends JFrame implements MouseListener, ActionListener {

		private ImageIcon logoimg;

		private JLabel logolbl;

		private JPanel backpanel;

		private JPanel logopanel;

		private JPanel loginpanel;

		private JPanel login;

		private JTextField idntf;

		private JLabel idlbl;

		private JLabel pwlbl;

		private JPanel loginbackpanel;

		private JPanel enter;

		private JButton enterbutton;

		private JPanel join;

		private JButton joinbutton;

		private JLabel joinlbl;

		private JoinFrame jf;

		private MainFrame mf;

		private JPasswordField pwtf;

		
		

		
		//DB연결
		static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
		static String dbID="blue";
		static String dbPassword="1234";

		
		
		
 

		public Login(String title){

			setSize(500, 700);

			setLocationRelativeTo(this); 

			setTitle(title);
			
			

			

			setbackground();

			setLogin();
			setUserLogin();
			

			setVisible(true);

		}

 




	private void setbackground() {

	

			

			

			//기본패널

			backpanel = new JPanel();

			backpanel.setLayout(new BorderLayout());

			backpanel.setBackground(new Color(125, 230, 119));

			backpanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

			

			add(backpanel);

			

		}

	private void setUserLogin() {
		
	}

	private void setLogin() {

			Font font = new Font("a소나무L", Font.BOLD, 15);
			Font font2 = new Font("a소나무L", Font.BOLD, 12);

		

			//중앙패널

			loginpanel = new JPanel();

			loginpanel.setLayout(null);

			loginpanel.setBounds(25, 23, 430, 610);

			loginpanel.setBounds(25, 23, 430, 610);

			loginpanel.setBackground(Color.white);

			backpanel.add(loginpanel);

		

			

			//로고패널

			logopanel = new JPanel();

			logopanel.setBackground(Color.white);

			logopanel.setBounds(110, 140, 200, 130);

			
			logoimg = new ImageIcon("images/mugigaejoguman.jpg");
			Image logoimage = logoimg.getImage();
			Image changeimg = logoimage.getScaledInstance(110, 120, Image.SCALE_SMOOTH);
			ImageIcon changelogo = new ImageIcon(changeimg);
			logolbl = new JLabel(changelogo);
			
			logopanel.add(logolbl);
			loginpanel.add(logopanel);

			

			//로그인패널

			loginbackpanel = new JPanel();

			loginbackpanel.setBounds(55, 260, 200, 140);

			loginbackpanel.setBackground(Color.white);

			

			login = new JPanel();

			login.setLayout(new GridLayout(4,1,5,5));

			login.setBackground(Color.WHITE);

		

			idlbl = new JLabel("아이디");

			idlbl.setFont(font);

			idntf = new JTextField(15);
			idntf.setPreferredSize(new Dimension(150, 24));

			pwlbl = new JLabel("비밀번호");

			pwlbl.setFont(font);

			pwtf = new JPasswordField();
//			pwtf = new HintTextField("비밀번호 입력");
			pwtf.setPreferredSize(new Dimension(150, 24));

			

			login.add(idlbl);

			login.add(idntf);

			login.add(pwlbl);

			login.add(pwtf);

			loginbackpanel.add(login);

			

			//로그인 버튼

			enter = new JPanel();

			enter.setBounds(260, 290, 93,85);

			enterbutton = new JButton("로그인");
			enterbutton.setBackground(new Color(255, 255, 170));
			
			enterbutton.addActionListener(this);

			enterbutton.setFont(font);

//			enterbutton.setContentAreaFilled(false);

			enterbutton.setFocusPainted(false);

//			enterbutton.setOpaque(false);

			enterbutton.setPreferredSize(new Dimension(90, 80));
			

			enter.setBackground(Color.white);

			enter.add(enterbutton);

			loginpanel.add(enter);

			

			//회원가입

			join = new JPanel();
			join.setBackground(new Color(255, 255, 170));

			join.setBounds(165, 385, 100, 50);

			join.setBackground(Color.WHITE);

			joinlbl = new JLabel("회원가입");
			
			joinlbl.addMouseListener(this);
			
			joinlbl.setOpaque(true); 

			joinlbl.setBackground(Color.white);

			joinlbl.setForeground(new Color(128, 128, 128)); 

			joinlbl.setFont(font2);

			join.add(joinlbl, BorderLayout.CENTER);

			loginpanel.add(join);

			

			

			loginpanel.add(loginbackpanel);

			

		}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		
		if(obj == joinlbl) {
			jf = new JoinFrame("회원가입", this);
			dispose();
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//로그인 버튼을 눌렀을때
		if(obj == enterbutton) {
			String id = idntf.getText();//아이디 tf 받아오기
			String pw = pwtf.getText(); //비밀번호 tf 받아오기
			
			
			if (id.isEmpty() && pw.isEmpty()) {	//id와 pw 값이 비어있는지 확인
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.", "로그인 실패", JOptionPane.OK_CANCEL_OPTION); //INFORMATION_MESSAGE, QUESTION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE
			} else if (id.isEmpty()) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "로그인 실패", JOptionPane.OK_CANCEL_OPTION);
			} else if (pw.isEmpty()){
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "로그인 실패", JOptionPane.OK_CANCEL_OPTION);
			} else { 
				
				boolean check = checkIDPW(id, pw);
				if(check) {
					JOptionPane.showMessageDialog(null, id + "님 안녕하세요.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
					
					if(id.equals("Admin")) {//관리자 페이지 연결
						//adminForm = new UserList();
						this.setVisible(false);
					} else {//관리자가 아니면
						mf = new MainFrame();
						//ID값 보내기
						mf.setId(id);
						//mf.setname(name);
						this.setVisible(false);
					}
				} else {//아디이와 비밀번호가 없을시 id,pw 초기화
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인해주세요.", "로그인 실패", JOptionPane.OK_CANCEL_OPTION);
					idntf.setText("");
					pwtf.setText("");
					idntf.requestFocus();
				}
			}
			
			
		}
	}
private boolean checkIDPW(String id, String pw) {
		
		boolean check = false;
		
		String sql = "SELECT * FROM User WHERE user_id = '" + id + "' AND user_pw='" + pw + "'"; //아이디 비밀번호 찾기 sql문
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
 

	public static void main(String[] args) {
		
		DB.DBconnect(dbURL, dbID, dbPassword);
		Login login = new Login("채팅");
		
	}
}