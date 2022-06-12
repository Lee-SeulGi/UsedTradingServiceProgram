package H_Test;
//수정

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import db.DB;
import H_Test.MainFrame;
import post.HintTextArea_post;
import post.HintTextField_post;
import H_Test.Login;

public class CreatePosting extends JFrame implements ActionListener{

	private JPanel cPanelNorth;
	private JButton btnClose;
	private JLabel lblWriteT;
	private JButton btnPerfect;
	private JPanel cPanelCenter;
	private JPanel cPanelCenter2;
	private JLabel clblTitle;
	private JPanel cPanelCenter1;
	private HintTextField_post ctfTitle;
	private JLabel clblPrice;
	private JTextField ctfPrice;
	private JLabel clblCondition;
	private JRadioButton cbtnCondition1;
	private JRadioButton cbtnCondition2;
	private JRadioButton cbtnCondition3;
	private JRadioButton cbtnCondition4;
	private JRadioButton cbtnCondition5;
	private JLabel clblContent;
	private JTextArea ctaContent;
	private JComboBox ccomboUsedate;
	private String usedatelist[] = {"미사용", "1개월 미만", "3개월 미만", "5개월 미만", "8개월 미만",
			"10개월 미만", "1년 미만", "1년 이상", "5년 이상", "10년 이상"};
	private JLabel clblUsedate;
	private MainFrame mainFrame;
	private MainFrame mf;
	private Posting posting;
	private ButtonGroup bg;
	
	static String dbURL = "jdbc:mysql://49.50.174.207/powerrainzo";
	static String dbID = "blue";
	static String dbPassword = "1234";
	
	public static String Myid;

	public CreatePosting() {
		
		String iD = Login.Myid;
		
		
		setTitle("게시물 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 700);
		setLocationRelativeTo(this); 
		setLayout(new BorderLayout());
		
		cPanelNorth();
		cPanelCenter();
		
		setVisible(true);
	}
	
	// 상단 패널
	private void cPanelNorth() {
		cPanelNorth = new JPanel();
		cPanelNorth.setLayout(new FlowLayout());
		
		ImageIcon iconClose = new ImageIcon("images/close.png");
		Image imgClose = iconClose.getImage();
		Image changeImgClose = imgClose.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon changeIconClose = new ImageIcon(changeImgClose);
		btnClose = new JButton(changeIconClose);
		btnClose.setPreferredSize(new Dimension(55, 37));
		btnClose.addActionListener(this);
		
		ImageIcon iconWTitle = new ImageIcon("images/WriteTitle.png");
		Image imgWTitle = iconWTitle.getImage();
		Image changeImgWTitle = imgWTitle.getScaledInstance(210, 32, Image.SCALE_AREA_AVERAGING);
		ImageIcon changeIconWTitle = new ImageIcon(changeImgWTitle);
		lblWriteT = new JLabel(changeIconWTitle);
		lblWriteT.setPreferredSize(new Dimension(335, 40));
		
		btnPerfect = new JButton("완료");
		btnPerfect.setFont(new Font("a소나무L", Font.BOLD, 15));
		btnPerfect.setPreferredSize(new Dimension(60, 37));
		btnPerfect.addActionListener(this);
		
		// 버튼의 내용영역 채우기 사용 안함
		btnClose.setContentAreaFilled(false);
		btnPerfect.setContentAreaFilled(false);
		// 버튼이 선택되었을때 생기는 테두리 사용 안함
		btnClose.setFocusPainted(false);
		btnPerfect.setFocusPainted(false);
		// 버튼을 투명하게 설정
		btnClose.setOpaque(false);
		btnPerfect.setOpaque(false);
		
		cPanelNorth.add(btnClose);
		cPanelNorth.add(lblWriteT);
		cPanelNorth.add(btnPerfect);
		
		add(cPanelNorth,BorderLayout.NORTH);
		cPanelNorth.setBackground(Color.WHITE);
	}

	// 중간 패널
	private void cPanelCenter() {
		cPanelCenter = new JPanel();
		cPanelCenter.setLayout(new GridLayout(2,1));
		cPanelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		cPanelCenter.setBackground(new Color(125, 230, 119));
		
		// 제목, 가격, 상태, 사용기간
		cPanelCenter1 = new JPanel();
		cPanelCenter1.setLayout(null);
		cPanelCenter1.setBackground(Color.WHITE);
		
		clblTitle = new JLabel("제    목 : ");
		clblTitle.setFont(new Font("a소나무L", Font.PLAIN, 17));
		clblTitle.setBounds(35, 48, 100, 20);
		
		ctfTitle = new HintTextField_post(" 글 제목 (20자 이내)");
		ctfTitle.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 19;
				if(ctfTitle.getText().length() > max+1) {
					e.consume();
					String shortened = ctfTitle.getText().substring(0, max);
					ctfTitle.setText(shortened);
				}
				else if(ctfTitle.getText().length() > max) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
//		ctfTitle.setDocument((new JTextFieldLimit(20)));
//		ctfTitle.setFont(new Font("a소나무L", Font.PLAIN, 18));
		ctfTitle.setBounds(126, 42, 275, 30);
		
		clblPrice = new JLabel("가    격 : ");
		clblPrice.setFont(new Font("a소나무L", Font.PLAIN, 17));
		clblPrice.setBounds(35, 108, 100, 20);
		
		ctfPrice = new JTextField();
		ctfPrice = new HintTextField_post(" 상품 가격 (20자 이내)");
		ctfPrice.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 19;
				if(ctfPrice.getText().length() > max+1) {
					e.consume();
					String shortened = ctfPrice.getText().substring(0, max);
					ctfPrice.setText(shortened);
				}
				else if(ctfPrice.getText().length() > max) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
//		ctfPrice.setDocument((new JTextFieldLimit(20)));
//		ctfPrice.setFont(new Font("a소나무L", Font.PLAIN, 18));
		
		ctfPrice.setBounds(126, 104, 275, 30);
		
		clblCondition = new JLabel("상    태 : ");
		clblCondition.setFont(new Font("a소나무L", Font.PLAIN, 17));
		clblCondition.setBounds(35, 168, 100, 20);
		
		cbtnCondition1 = new JRadioButton("최상");
		cbtnCondition1.setFont(new Font("a소나무L", Font.PLAIN, 17));
		cbtnCondition1.setSelected(true);
		cbtnCondition1.setBounds(126, 168, 60, 20);
		cbtnCondition1.setBackground(Color.white);
		
		cbtnCondition2 = new JRadioButton("상");
		cbtnCondition2.setFont(new Font("a소나무L", Font.PLAIN, 17));
		cbtnCondition2.setBounds(192, 168, 45, 20);
		cbtnCondition2.setBackground(Color.white);
		
		cbtnCondition3 = new JRadioButton("중");
		cbtnCondition3.setFont(new Font("a소나무L", Font.PLAIN, 17));
		cbtnCondition3.setBounds(245, 168, 45, 20);
		cbtnCondition3.setBackground(Color.white);
		
		cbtnCondition4 = new JRadioButton("하");
		cbtnCondition4.setFont(new Font("a소나무L", Font.PLAIN, 17));
		cbtnCondition4.setBounds(294, 168, 45, 20);
		cbtnCondition4.setBackground(Color.white);
		
		cbtnCondition5 = new JRadioButton("최하");
		cbtnCondition5.setFont(new Font("a소나무L", Font.PLAIN, 17));
		cbtnCondition5.setBounds(344, 168, 60, 20);
		cbtnCondition5.setBackground(Color.white);
		
		bg = new ButtonGroup();
		bg.add(cbtnCondition1);
		bg.add(cbtnCondition2);
		bg.add(cbtnCondition3);
		bg.add(cbtnCondition4);
		bg.add(cbtnCondition5);
		
		clblUsedate = new JLabel("사용기간 :");
		clblUsedate.setFont(new Font("a소나무L", Font.PLAIN, 17));
		clblUsedate.setBounds(35, 228, 100, 20);
		
		ccomboUsedate = new JComboBox(usedatelist);
		ccomboUsedate.setFont(new Font("a소나무L", Font.PLAIN, 15));
		ccomboUsedate.setBounds(126, 224, 275, 30);
		
		// 내용
		cPanelCenter2 = new JPanel();
		cPanelCenter2.setLayout(null);
		cPanelCenter2.setBackground(Color.WHITE);
		
		clblContent = new JLabel("내     용 : ");
		clblContent.setFont(new Font("a소나무L", Font.PLAIN, 17));
		clblContent.setBounds(35, 0, 100, 30);
		
		ctaContent = new JTextArea();
		ctaContent = new HintTextArea_post(" 게시판에 올릴 게시글 내용을 작성해주세요.\n 가품 및 판매 금지품목은 신고 대상이 될 수 \n 있습니다. (190자 이내)");
		ctaContent.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 189;
				if(ctaContent.getText().length() > max+1) {
					e.consume();
					String shortened = ctaContent.getText().substring(0, max);
					ctaContent.setText(shortened);
				}
				else if(ctaContent.getText().length() > max) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
//		ctaContent.setFont(new Font("a소나무L", Font.PLAIN, 18));
//		ctaContent.setDocument((new JTextFieldLimit(190)));	// 글자 수 190자 제한
		ctaContent.setLineWrap(true);		// 자동 줄바꿈
		JScrollPane scrollPane = new JScrollPane(ctaContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(126,3,275,238);
		
		// 패널 1
		cPanelCenter1.add(clblTitle);
		cPanelCenter1.add(ctfTitle);
		cPanelCenter1.add(clblPrice);
		cPanelCenter1.add(ctfPrice);
		cPanelCenter1.add(clblCondition);
		cPanelCenter1.add(cbtnCondition1);
		cPanelCenter1.add(cbtnCondition2);
		cPanelCenter1.add(cbtnCondition3);
		cPanelCenter1.add(cbtnCondition4);
		cPanelCenter1.add(cbtnCondition5);
		cPanelCenter1.add(clblUsedate);
		cPanelCenter1.add(ccomboUsedate);
		
		// 패널 2
		cPanelCenter2.add(clblContent);
		cPanelCenter2.add(scrollPane);
		
		
		cPanelCenter.add(cPanelCenter1);
		cPanelCenter.add(cPanelCenter2);
		
		add(cPanelCenter,BorderLayout.CENTER);
	}
	
	String cdt;	// 상태 - 라디오버튼 데이터 넣기
	private String use_name;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		// (상태) 라디오버튼 체크된 데이터 찾기
		if(cbtnCondition1.isSelected()) {
			cdt = cbtnCondition1.getText();
		}
		if(cbtnCondition2.isSelected()) {
			cdt = cbtnCondition2.getText();
		}
		if(cbtnCondition3.isSelected()) {
			cdt = cbtnCondition3.getText();
		}
		if(cbtnCondition4.isSelected()) {
			cdt = cbtnCondition4.getText();
		}
		if(cbtnCondition5.isSelected()) {
			cdt = cbtnCondition5.getText();
		}
		if(obj == btnClose) {
			// 입력된 값이 없으면 바로 종료
			if(ctfTitle.getForeground().equals(Color.GRAY) && ctfPrice.getForeground().equals(Color.GRAY) && ctaContent.getForeground().equals(Color.GRAY)) {
				mf = new MainFrame();
				setVisible(false);
			}
			// 하나라도 입력된 값이 있다면 메시지 박스 보이기
			else if(ctfTitle.getText().isEmpty() == false || ctfPrice.getText().isEmpty() == false || ctaContent.getText().isEmpty() == false){
				if(JOptionPane.showConfirmDialog(this, "정말 글쓰기를 종료하시겠습니까?", "종료", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					mf = new MainFrame();
					
					setVisible(false);
				}
			}
		}
		else if(obj == btnPerfect) {
			if(ctfTitle.getForeground().equals(Color.GRAY) || ctfPrice.getForeground().equals(Color.GRAY) || ctaContent.getForeground().equals(Color.GRAY)) {
				JOptionPane.showMessageDialog(null, "비어있는 칸이 존재합니다.", "메시지", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				String title = ctfTitle.getText().toString();
				String price = ctfPrice.getText().toString();
				String condition = cdt;
				String usedate = ccomboUsedate.getSelectedItem().toString();
				String content = ctaContent.getText().toString();
				
				String sql_username = "SELECT user_name FROM User where user_id ='"+ Myid +"';" ;
				ResultSet rs = DB.DBselect(sql_username);
				
				
				try {
					if(rs.next()) {	//sql문에 내용이 있을 때
						Myid = rs.getString("user_name");
						System.out.println(use_name);
					} else { //내용이 없으면 false
						System.out.println("no");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				String sqlInsert = "INSERT into Post" + "(user_id, post_title, post_price, post_state, post_term, post_memo, user_name)"
									+ "values('" + Myid + "', '" + title + "', '" + price + "', '" + condition + "', '" + usedate + "', '" + content + "', '"+ use_name+"')";
				int rss = DB.DBinsert(sqlInsert);
				
				
				
				JOptionPane.showMessageDialog(null, "게시물이 등록되었습니다.", "메시지", JOptionPane.PLAIN_MESSAGE);
				posting = new Posting();
				setVisible(false);
			}
		}
	}
	public String getId() {
		return Myid;
	}
	
	public void setId(String Myid) {
		this.Myid = Myid;
	}
	
	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
		new CreatePosting();
	}
}