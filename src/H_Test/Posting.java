package H_Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import chat.ChatServer;
import chat.report;
import db.DB;
import H_Test.MainFrame;
import H_Test.Login;
import H_Test.Posting;

public class Posting extends JFrame implements ActionListener{
	
	// 제발 합쳐주세요.
	private JButton btnBack;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JButton btnChat;
	private JButton btnInterest;
	private JLabel lblb1;
	private JLabel lblb2;
	private JLabel lblUser;
	private JLabel lblTitle;
	private JLabel lblContent;
	private JLabel lblPrice;
	private JLabel lblCondition;
	private JLabel user;
	private JLabel title;
	private JTextArea content;
	private JLabel price;
	private JLabel condition;
	private JPanel panelCenter;
	private JPanel panelC1;
	private JPanel panelC2;
	private JPanel panelC3;
	private JPanel panelC4;
	private JPanel panelC5;
	private JPanel panelCenter1;
	private JPanel panelCenter2;
	private JButton btnHome;
	private JLabel lblN1;
	private JLabel lblN2;
	private JLabel lblN3;
	private JLabel lblN4;
	private JLabel lblN5;
	private JLabel lblN6;
	private JLabel lblN7;
	private JButton btnReport;
	private JLabel lblUsedate;
	private JLabel usedate;
	private MainFrame mainFrame;
	
	int click = 0;
	private MainFrame mf;
	private ChatServer chatS;
	private JLabel lblN8;
	private report rp;
	private JLabel userTitle;
	private String user_name;

	private static String id;
	
	private String Myid;
	
	
	static String dbURL = "jdbc:mysql://49.50.174.207/powerrainzo";
	static String dbID = "blue";
	static String dbPassword = "1234";
	
	
	
	public Posting() {
		
		String iD = Login.Myid;
		
		setTitle("게시물");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocation(200, 50);
		setSize(500, 700);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout());
		
		panelNorth();
		panelCenter();
		panelSouth();
		
		setVisible(true);
	}

	// 상단 패널
	private void panelNorth() {
		panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1, 10));
		panelNorth.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		ImageIcon iconBack = new ImageIcon("images/return.png");
		Image img1 = iconBack.getImage();
		Image changeImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		btnBack = new JButton(changeIcon1);
		btnBack.addActionListener(this);
		
		
		// 빈 공간
		lblN1 = new JLabel();
		lblN2 = new JLabel();
		lblN3 = new JLabel();
		lblN4 = new JLabel();
		lblN5 = new JLabel();
		lblN6 = new JLabel();
		lblN7 = new JLabel();
		lblN8 = new JLabel();
		
		ImageIcon iconReport = new ImageIcon("images/report.png");
		Image img3 = iconReport.getImage();
		Image changeImg3 = img3.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImg3);
		btnReport = new JButton(changeIcon3);
		btnReport.addActionListener(this);
		
		// 버튼의 내용영역 채우기 사용 안함
		btnBack.setContentAreaFilled(false);
//		btnHome.setContentAreaFilled(false);
		btnReport.setContentAreaFilled(false);
		// 버튼이 선택되었을때 생기는 테두리 사용 안함
		btnBack.setFocusPainted(false);
//		btnHome.setFocusPainted(false);
		btnReport.setFocusPainted(false);
		// 버튼을 투명하게 설정
		btnBack.setOpaque(false);
//		btnHome.setOpaque(false);
		btnReport.setOpaque(false);
		
		panelNorth.add(btnBack);
//		panelNorth.add(btnHome);
		panelNorth.add(lblN1);
		panelNorth.add(lblN2);
		panelNorth.add(lblN3);
		panelNorth.add(lblN4);
		panelNorth.add(lblN5);
		panelNorth.add(lblN6);
		panelNorth.add(lblN7);
		panelNorth.add(lblN8);
		panelNorth.add(btnReport);
		
		add(panelNorth,BorderLayout.NORTH);
		panelNorth.setBackground(Color.WHITE);
	}
	
	// 중간 패널
	private void panelCenter() {
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(2, 1));
		panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelCenter.setBackground(new Color(125, 230, 119));
		
		// 사용자, 제목, 가격, 상태
		panelCenter1 = new JPanel();
		panelCenter1.setLayout(null);
		panelCenter1.setBackground(Color.WHITE);
		
		ImageIcon iconUser = new ImageIcon("images/user.png");
		Image img3 = iconUser.getImage();
		Image changeImg3 = img3.getScaledInstance(46, 46, Image.SCALE_AREA_AVERAGING);
		ImageIcon changeIcon3 = new ImageIcon(changeImg3);
		lblUser = new JLabel(changeIcon3, JLabel.CENTER);
		lblUser.setBounds(86, 32, 50, 50);
		
		
		// 게시물 작성자 = 판매자 이름 설정
	      String username = "SELECT user_name FROM User where user_id ='" + Myid + "';" ;
	      ResultSet rs = DB.DBselect(username);
	      		
	      
	      try {
	         if(rs.next()) {   //sql문에 내용이 있을 때
	        	 username = rs.getString("user_name");
	            
	            System.out.println(username);
	         } else { //내용이 없으면 false
	            System.out.println(id);
	            System.out.println("오류");
	         }
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
		
		user = new JLabel(username);
		user.setFont(new Font("a소나무L", Font.BOLD, 25));
		user.setBounds(145, 32, 220, 50);
		
		userTitle = new JLabel("    님의 게시물");
		userTitle.setFont(new Font("a소나무L", Font.PLAIN, 20));
		userTitle.setBounds(216, 32, 220, 50);
		
		lblTitle = new JLabel("제    목 :");
		lblTitle.setFont(new Font("a소나무L", Font.PLAIN, 17));
		lblTitle.setBounds(50, 115, 70, 20);
		
		// 글자 수 20자 제한
		title = new JLabel("미개봉 신라면 판매합니다.");
		title.setFont(new Font("a소나무L", Font.PLAIN, 14));
		title.setBounds(136, 113, 260, 20);
		
		lblPrice = new JLabel("가    격 :");
		lblPrice.setFont(new Font("a소나무L", Font.PLAIN, 17));
		lblPrice.setBounds(50, 163, 70, 20);
		
		price = new JLabel("15,000원");
		price.setFont(new Font("a소나무L", Font.PLAIN, 14));
		price.setBounds(136, 160, 200, 20);
		
		lblCondition = new JLabel("상    태 :");
		lblCondition.setFont(new Font("a소나무L", Font.PLAIN, 17));
		lblCondition.setBounds(50, 210, 70, 20);
		
		condition = new JLabel("최상");
		condition.setFont(new Font("a소나무L", Font.PLAIN, 14));
		condition.setBounds(136, 208, 200, 20);
		
		panelCenter1.add(lblUser);
		panelCenter1.add(user);
		panelCenter1.add(userTitle);
		panelCenter1.add(lblTitle);
		panelCenter1.add(title);
		panelCenter1.add(lblPrice);
		panelCenter1.add(price);
		panelCenter1.add(lblCondition);
		panelCenter1.add(condition);
		
		// 사용기간, 내용
		panelCenter2 = new JPanel();
		panelCenter2.setLayout(null);
		panelCenter2.setBackground(Color.WHITE);
		
		lblUsedate = new JLabel("사용기간 :");
		lblUsedate.setFont(new Font("a소나무L", Font.PLAIN, 17));
		lblUsedate.setBounds(50, 1, 70, 20);
		
		usedate = new JLabel("미사용");
		usedate.setFont(new Font("a소나무L", Font.PLAIN, 14));
		usedate.setBounds(136, 0, 200, 20);
		
		lblContent = new JLabel("내     용 :");
		lblContent.setFont(new Font("a소나무L", Font.PLAIN, 17));
		lblContent.setBounds(50, 48, 74, 20);
		
		// 글자 수 190 이하
		content = new JTextArea("가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 1234567891011121314161718");
		content.setFont(new Font("a소나무L", Font.PLAIN, 14));
		content.setLineWrap(true);	// 자동 줄바꿈
		content.setEditable(false);
		content.setBounds(136, 46, 260, 175);
		
		panelCenter2.add(lblUsedate);
		panelCenter2.add(usedate);
		panelCenter2.add(lblContent);
		panelCenter2.add(content);
		
		panelCenter.add(panelCenter1);
		panelCenter.add(panelCenter2);
		
		add(panelCenter,BorderLayout.CENTER);
	}
	
	// 하단 패널
	private void panelSouth() {
		panelSouth = new JPanel();
		panelSouth.setLayout(new GridLayout());
		panelSouth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		ImageIcon iconInterest = new ImageIcon("images/interest.png");
		Image img2 = iconInterest.getImage();
		Image changeImg2 = img2.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		btnInterest = new JButton(changeIcon2);
		btnInterest.addActionListener(this);

		lblb1 = new JLabel();
		lblb2 = new JLabel();
		
		btnChat = new JButton("채팅하기");
		btnChat.setFont(new Font("a소나무L", Font.BOLD, 16));
		btnChat.setAlignmentX(RIGHT_ALIGNMENT);
		btnChat.addActionListener(this);
		
		// 버튼의 내용영역 채우기 사용 안함
		btnInterest.setContentAreaFilled(false);
		btnChat.setContentAreaFilled(false);
		// 버튼이 선택되었을때 생기는 테두리 사용 안함
		btnInterest.setFocusPainted(false);
		btnChat.setFocusPainted(false);
		// 버튼을 투명하게 설정
		btnInterest.setOpaque(false);
		btnChat.setOpaque(false);
		
		
		
		panelSouth.add(btnInterest);
		panelSouth.add(lblb1);
		panelSouth.add(lblb2);
		panelSouth.add(btnChat);
		
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setBackground(Color.WHITE);
	}
	
	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
		new Posting();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		
		//관심 테이블에 게시물 내용 삽입
		if(obj == btnInterest) {
			
			//관심버튼을 누른 사용자 이름
			String loveid = Myid;
			String posttitle = title.getText().toString();
			String postprice = price.getText().toString();
			//게시물 판매자 이름
			String username = "조구만";
			
			//관심목록 중복 체크
			click = click + 1;
			boolean check = checkIike(posttitle, username);
			if(!check) {

			String sqlInLike = "INSERT into Interest" + "(love_id, post_title, post_price, user_name)"
					+ "values('" + loveid + "', '" + posttitle + "', '" + postprice + "', '" + username +  "')";
			int rs = DB.DBinsert(sqlInLike);
			  
				JOptionPane.showMessageDialog(null, "관심 목록에 추가되었습니다.", "메시지", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "이미 관심 목록에 있습니다.", "메시지", JOptionPane.ERROR_MESSAGE);
			} 

			
		}else if(obj == btnBack) {
			mf = new MainFrame();
			setVisible(false);
		}else if(obj == btnChat) {
			chatS = new ChatServer("채팅서버", id);
			setVisible(false);
			Thread th = new Thread(chatS);
			th.start();
		}else if(obj == btnReport) {
			if(JOptionPane.showConfirmDialog(this, "사용자를 신고하시겠습니까?", "신고"
					, JOptionPane.YES_NO_OPTION
					, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				rp = new report("사용자 신고", 518	, 80);
			}
		}
	}
	private boolean checkIike(String posttitle, String username) {
		
		boolean check = false;
		
		String sql = "SELECT * FROM Interest WHERE post_title = '" + posttitle + "' AND user_name='" + username + "'"; //아이디 비밀번호 찾기 sql문
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
	public String getId() {
		return Myid;
	}
	
	public void setId(String Myid) {
		this.Myid = Myid;
	}
	
	
}
