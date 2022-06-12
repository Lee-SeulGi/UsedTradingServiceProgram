package profile;
// 수정
//수정2
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import db.DB;
import login.Login;
import main.MainFrame;
import review.QnA;

public class Mypage extends JFrame implements ActionListener, MouseListener {

   private JPanel pPanelNorth;
   private JButton btnBack;
   private JLabel lblMyT;
   private JPanel pPanelCenter;
   private JPanel pPanelCenterC;
   private JLabel lblUser;
   private JLabel userName;
   private JLabel userArea;
   private JLabel lblIf;
   private JLabel lblLogout;
   private JButton btnReview;
   private JButton btnInterest;
   private JButton btnMore;
   private JButton btnAsk;
   private JButton btnService;
   private JButton btnPolicy;
   private JLabel lblVersion;
   private MainFrame mf;
   private Interest iterest;
   private Review reivew;
   private Service service;
   private Policy policy;
   private QnA qna;
   private Login login;
   private JLabel lbltaltae;
   private String use_name;
   
   private static String id;

   static String dbURL = "jdbc:mysql://49.50.174.207/powerrainzo";
   static String dbID = "blue";
   static String dbPassword = "1234";
   
//   public String getId() {
//      return id;
//   }
//
//   public void setId(String id) {
//      this.id = id;
//   }
   
   public Mypage(String title, String id) {
      this.id = id;
      
      setTitle(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setLocation(800, 50);
      setSize(500, 700);
      setLocationRelativeTo(this);
      setLayout(new BorderLayout());
      
      pPanelNorth();
      pPanelCenter();
      
      setVisible(true);
   }
   
   private void pPanelNorth() {
      pPanelNorth = new JPanel();
      pPanelNorth.setLayout(new FlowLayout());
      
      ImageIcon iconBack = new ImageIcon("images/return.png");
      Image img1 = iconBack.getImage();
      Image changeImg1 = img1.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
      ImageIcon changeIcon1 = new ImageIcon(changeImg1);
      btnBack = new JButton(changeIcon1);
      btnBack.setPreferredSize(new Dimension(55, 37));
      btnBack.addActionListener(this);
      
      ImageIcon iconMyTitle = new ImageIcon("images/my.png");
      Image imgMyTitle = iconMyTitle.getImage();
      Image changeImgMyTitle = imgMyTitle.getScaledInstance(172, 33, Image.SCALE_AREA_AVERAGING);
      ImageIcon changeIconMtTitle = new ImageIcon(changeImgMyTitle);
      lblMyT = new JLabel(changeIconMtTitle);
      lblMyT.setPreferredSize(new Dimension(335, 40));
      
      ImageIcon iconMore = new ImageIcon("images/more.png");
      Image img4 = iconMore.getImage();
      Image changeImg4 = img4.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
      ImageIcon changeIcon4 = new ImageIcon(changeImg4);
      btnMore = new JButton(changeIcon4);
      btnMore.setPreferredSize(new Dimension(55, 37));
      
      // 버튼의 내용영역 채우기 사용 안함
      btnBack.setContentAreaFilled(false);
      btnMore.setContentAreaFilled(false);
      // 버튼이 선택되었을때 생기는 테두리 사용 안함
      btnBack.setFocusPainted(false);
      btnMore.setFocusPainted(false);
      // 버튼을 투명하게 설정
      btnBack.setOpaque(false);
      btnMore.setOpaque(false);
      
      pPanelNorth.add(btnBack);
      pPanelNorth.add(lblMyT);
      pPanelNorth.add(btnMore);
      
      add(pPanelNorth,BorderLayout.NORTH);
      pPanelNorth.setBackground(Color.WHITE);
   }

   private void pPanelCenter() {
      pPanelCenter = new JPanel();
      pPanelCenter.setLayout(new GridLayout(1,1));
      pPanelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      pPanelCenter.setBackground(new Color(125, 230, 119));
      
      // 흰색 배경 영역
      pPanelCenterC = new JPanel();
      pPanelCenterC.setLayout(null);
      pPanelCenterC.setBackground(Color.WHITE);
      
      // 프로필 사진
      ImageIcon iconUser = new ImageIcon("images/user.png");
      Image img3 = iconUser.getImage();
      Image changeImg3 = img3.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
      ImageIcon changeIcon3 = new ImageIcon(changeImg3);
      lblUser = new JLabel(changeIcon3, JLabel.CENTER);
      lblUser.setBounds(50, 45, 55, 55);
      
      // 사용자 이름
      this.id = id;
      
      
      String username = "SELECT user_name FROM User where user_id ='" + id + "';" ;
      ResultSet rs = DB.DBselect(username);
      
      try {
         if(rs.next()) {   //sql문에 내용이 있을 때
            use_name = rs.getString("user_name");
            System.out.println(use_name);
         } else { //내용이 없으면 false
            System.out.println(id);
            System.out.println("이름 전달 실패");
         }
      } catch (SQLException e1) {
         e1.printStackTrace();
      }
      
      userName = new JLabel(use_name);
      userName.setFont(new Font("a소나무L", Font.BOLD, 23));
      userName.setBounds(119, 38, 73, 50);
      
      // 사용자 지역
      userArea = new JLabel("인천");
      userArea.setFont(new Font("a소나무L", Font.PLAIN, 15));
      userArea.setBounds(122, 62, 73, 50);
      
      // 다른 고객님이라면,
      lblIf = new JLabel("다른 고객님이라면,");
      lblIf.setFont(new Font("a소나무L", Font.PLAIN, 13));
      lblIf.setBounds(295, 36, 100, 50);
      
      // 로그아웃 버튼
      lblLogout = new JLabel("로그아웃");
      lblLogout.setFont(new Font("a소나무L", Font.BOLD, 16));
      lblLogout.setForeground(new Color(21, 105, 64));
      lblLogout.setBounds(335, 70, 100, 25);
      lblLogout.addMouseListener(this);
      
//      font_Activity = new Font("a소나무L", Font.BOLD, 18);
      
      // 나의 활동 (관심 목록, 거래 후기)
//      panelActivity = new JPanel();
//      panelActivity.setBackground(Color.white);
//      panelActivity.setBorder(new TitledBorder(new LineBorder(new Color(125, 230, 119), 2, true),"나의 활동",
//            TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_POSITION, font_Activity));
////      panelActivity.setLayout(new GridLayout(2, 1, 100, 5));
//      panelActivity.setLayout(null);
//      panelActivity.setBounds(33, 125, 380, 170);
      
      // 관심 버튼
      btnInterest = new JButton(" 관심 목록                                   >");
      btnInterest.setFont(new Font("a소나무L", Font.PLAIN, 18));
      ImageIcon iconInterest = new ImageIcon("images/heart.png");
      btnInterest.setIcon(iconInterest);
      btnInterest.setBackground(Color.WHITE);
      btnInterest.setBounds(48, 128, 350, 62);
      btnInterest.setBorder(BorderFactory.createLineBorder(new Color(158, 158, 158),1));
//      btnReview.setBorderPainted(false);
      btnInterest.setFocusPainted(false);
      btnInterest.addActionListener(this);
      
      
      // 거래 후기 버튼  
      ImageIcon iconReview = new ImageIcon("images/star.png");
      Image img6 = iconReview.getImage();
      Image changeImg6 = img6.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
      ImageIcon changeIcon6 = new ImageIcon(changeImg6);
      btnReview = new JButton(" 거래 후기                                   >");
      btnReview.setFont(new Font("a소나무L", Font.PLAIN, 18));
      btnReview.setIcon(changeIcon6);
      btnReview.setBackground(Color.WHITE);
      btnReview.setBounds(48, 204, 350, 62);
      btnReview.setBorder(BorderFactory.createLineBorder(new Color(158, 158, 158),1));
//      btnReview.setBorderPainted(false);
      btnReview.setFocusPainted(false);
      btnReview.addActionListener(this);
      
      pPanelCenterC.add(btnInterest);
      pPanelCenterC.add(btnReview);
      
      // 자주묻는질문 버튼  
      ImageIcon iconAsk = new ImageIcon("images/ask.png");
      Image img5 = iconAsk.getImage();
      Image changeImg5 = img5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
      ImageIcon changeIcon5 = new ImageIcon(changeImg5);
      btnAsk = new JButton(" 자주묻는질문                              >");
      btnAsk.setFont(new Font("a소나무L", Font.PLAIN, 18));
      btnAsk.setIcon(changeIcon5);
      btnAsk.setBackground(Color.WHITE);
      btnAsk.setBounds(48, 280, 350, 62);
      btnAsk.setBorder(BorderFactory.createLineBorder(new Color(158, 158, 158),1));
//      btnReview.setBorderPainted(false);
      btnAsk.setFocusPainted(false);
      btnAsk.addActionListener(this);
      
      // 서비스이용약관 버튼
      ImageIcon iconService = new ImageIcon("images/service.png");
      Image img7 = iconService.getImage();
      Image changeImg7 = img7.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
      ImageIcon changeIcon7 = new ImageIcon(changeImg7);
      btnService = new JButton(" 서비스이용약관                           >");
      btnService.setFont(new Font("a소나무L", Font.PLAIN, 18));
      btnService.setIcon(changeIcon7);
      btnService.setBackground(Color.WHITE);
      btnService.setBounds(48, 355, 350, 62);
      btnService.setBorder(BorderFactory.createLineBorder(new Color(158, 158, 158),1));
//      btnReview.setBorderPainted(false);
      btnService.setFocusPainted(false);
      btnService.addActionListener(this);
      
      // 개인정보처리방침 버튼
      ImageIcon iconPolicy = new ImageIcon("images/policy.png");
      Image img8 = iconPolicy.getImage();
      Image changeImg8 = img8.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
      ImageIcon changeIcon8 = new ImageIcon(changeImg8);
      btnPolicy = new JButton(" 개인정보처리방침                        >");
      btnPolicy.setFont(new Font("a소나무L", Font.PLAIN, 18));
      btnPolicy.setIcon(changeIcon8);
      btnPolicy.setBackground(Color.WHITE);
      btnPolicy.setBounds(48, 432, 350, 62);
      btnPolicy.setBorder(BorderFactory.createLineBorder(new Color(158, 158, 158),1));
//      btnReview.setBorderPainted(false);
      btnPolicy.setFocusPainted(false);
      btnPolicy.addActionListener(this);
      
      // 버전
      lblVersion = new JLabel("현재 버전 v2022.20-21");
      lblVersion.setFont(new Font("a소나무L", Font.PLAIN, 14));
      lblVersion.setBounds(153, 505, 200, 54);
      
      lbltaltae = new JLabel("회원 탈퇴하기");
      
      pPanelCenter.add(pPanelCenterC);
      
      pPanelCenterC.add(lblUser);
      pPanelCenterC.add(userName);
      pPanelCenterC.add(userArea);
      pPanelCenterC.add(lblIf);
      pPanelCenterC.add(lblLogout);
      
      pPanelCenterC.add(btnAsk);
      pPanelCenterC.add(btnService);
      pPanelCenterC.add(btnPolicy);
      pPanelCenterC.add(lblVersion);
      
      add(pPanelCenter,BorderLayout.CENTER);
   }


	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
		new Mypage("마이페이지", id);
	}


   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      
      if(obj == btnBack) {
         mf = new MainFrame();
         setVisible(false);
      }else if(obj == btnInterest) {
         iterest =new Interest(null);
         setVisible(false);
            //if(obj == Interest.getBtnExit())
      }else if(obj == btnReview) {
         reivew = new Review(null);
         setVisible(false);
      }else if(obj == btnAsk) {
         qna = new QnA("자주 묻는 질문");
      }else if(obj==btnService) {
         service= new Service("서비스이용약관");
         setVisible(false);
      }else if(obj == btnPolicy) {
         policy = new Policy("개인정보처리방침");
         setVisible(false);
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }


	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblLogout) {
			if(JOptionPane.showConfirmDialog(this, "정말 로그아웃을 하시겠습니까?", "로그아웃", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
						login = new Login("로그인");
						dispose();
			}
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
      
}