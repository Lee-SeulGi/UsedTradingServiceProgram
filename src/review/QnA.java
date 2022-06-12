package review;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import db.DB;
import profile.Mypage;


public class QnA extends JFrame implements ActionListener {
   private JPanel basepanel;
   private JPanel panelNorth;
   private JButton btnBack;
   private JPanel centerpanel;
   private JPanel signpanle;
   private JLabel signlbl;
   private JPanel qnapanel;
   private JPanel qna1, qna2, qna3, qna4, qna5, qna6;
   private JLabel Q1, Q2, Q3, Q4, Q5, Q6;
   private JLabel A1, A2, A3, A4, A5, A6;
   private Mypage mypage;
   private String id;

   static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
   static String dbID="blue";
   static String dbPassword="1234";
	
   public String getId() {
		return id;
   }
	
   public void setId(String id) {
	   this.id = id;
   }
   
   public QnA(String title, String id){
	  this.id = id;
	   
      setSize(500, 700);
      setLocationRelativeTo(null); 
      setTitle(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setnorth();
      
      basepanel = new JPanel();
      basepanel.setLayout(new BorderLayout());
      basepanel.setBackground(new Color(125, 230, 119));
      basepanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(basepanel);
      
      setcenter();
      
      setVisible(true);
   }

   private void setnorth() {
      panelNorth = new JPanel();
      panelNorth.setLayout(new GridLayout(1,3));
      panelNorth.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      panelNorth.setBackground(Color.white);
      
      
      JPanel firstP = new JPanel();
      firstP.setLayout(new GridLayout(1,3,10,0));
      firstP.setBackground(Color.white);
      
      ImageIcon iconBack = new ImageIcon("images/return.png");
      Image img1 = iconBack.getImage();
      Image changeImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
      ImageIcon changeIcon1 = new ImageIcon(changeImg1);
      btnBack = new JButton(changeIcon1);
         btnBack.setContentAreaFilled(false); // 버튼의 내용영역 채우기 사용 안함
         btnBack.setFocusPainted(false); // 버튼이 선택되었을때 생기는 테두리 사용 안함
         btnBack.setOpaque(false); // 버튼을 투명하게 설정
         btnBack.addActionListener(this);
      
      JLabel lbl1 = new JLabel();
      JLabel lbl2 = new JLabel();
      
      firstP.add(btnBack);
      firstP.add(lbl1);
      firstP.add(lbl2);
      
      JLabel lbl3 = new JLabel("자주 묻는 질문");
      lbl3.setFont(new Font("a소나무L", Font.BOLD, 25));
      JLabel lbl4 = new JLabel();
      
      panelNorth.add(firstP);
      panelNorth.add(lbl3);
      panelNorth.add(lbl4);
      
      add(panelNorth,BorderLayout.NORTH);
                  
   }

   private void setcenter() {
      centerpanel = new JPanel();
      centerpanel.setBackground(Color.white);
      centerpanel.setLayout(new BorderLayout());
      basepanel.add(centerpanel);
      
    
      setqna();
      
      //centerpanel.add(signpanle, BorderLayout.NORTH);
      centerpanel.add(qnapanel, BorderLayout.CENTER);
   }

  

   private void setqna() {
      qnapanel = new JPanel();
      qnapanel.setBackground(Color.white);
      qnapanel.setLayout(new GridLayout(6,1, 0,3));
      qnapanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
      
      
      qna1 = new JPanel();
      qna1.setBackground(new Color(225,240,182));
      qna1.setLayout(new GridLayout(2,1));
         Q1 = new JLabel( "   Q. 판매 금지 물품");
         Q1.setFont(new Font("a소나무L", Font.BOLD, 18));
         A1 = new JLabel("    A. 가품, 주류, 담배 등 금지 품목으로 등록되어 있습니다.");
         A1.setFont(new Font("a소나무L", Font.PLAIN, 14));
      qna1.add(Q1);
      qna1.add(A1);
      
      qna2 = new JPanel();
      qna2.setBackground(new Color(250,250,204));
      qna2.setLayout(new GridLayout(2,1));
         Q2 = new JLabel("   Q. 중고거래 운영정책");
         Q2.setFont(new Font("a소나무L", Font.BOLD, 18));
         A2 = new JLabel("    A. 상호 존중, 무단 거래 파기 등 거래 매너를 지켜주세요. ");
         A2.setFont(new Font("a소나무L", Font.PLAIN, 14));
      qna2.add(Q2);
      qna2.add(A2);
      
      qna3 = new JPanel();
      qna3.setBackground(new Color(225,240,182));
      qna3.setLayout(new GridLayout(2,1));
         Q3 = new JLabel("   Q. 판매자에게 보이는 거래 후기");
         Q3.setFont(new Font("a소나무L", Font.BOLD, 18));
         A3 = new JLabel("    A. 구매자가 직접 선택하고 작성한 내용들만 전송됩니다.");
         A3.setFont(new Font("a소나무L", Font.PLAIN, 14));
      qna3.add(Q3);
       qna3.add(A3);
      
      qna4 = new JPanel();
      qna4.setBackground(new Color(250,250,204));
      qna4.setLayout(new GridLayout(2,1));
         Q4 = new JLabel("   Q. 반려동물 무료 분양");
         Q4.setFont(new Font("a소나무L", Font.BOLD, 18));
         A4 = new JLabel("    A. 본 서비스는 생명을 거래하는 행위를 금하고 있습니다.");
         A4.setFont(new Font("a소나무L", Font.PLAIN, 14));
       qna4.add(Q4);
       qna4.add(A4);
      
      qna5 = new JPanel();
      qna5.setBackground(new Color(225,240,182));
      qna5.setLayout(new GridLayout(2,1));
         Q5 = new JLabel("   Q. 신고 방법");
         Q5.setFont(new Font("a소나무L", Font.BOLD, 18));
         A5 = new JLabel("    A. 해당 게시글의 우측 상단의 버튼으로 신고 가능합니다.");
         A5.setFont(new Font("a소나무L", Font.PLAIN, 14));
       qna5.add(Q5);
        qna5.add(A5);
      
      qna6 = new JPanel();
      qna6.setBackground(new Color(250,250,204));
      qna6.setLayout(new GridLayout(2,1));
         Q6 = new JLabel("   Q. 중고 거래 사기 주의");
         Q6.setFont(new Font("a소나무L", Font.BOLD, 18));
         A6 = new JLabel("    A. 외부링크, 외부연락 수단 사용을 지양해주세요.");
         A6.setFont(new Font("a소나무L", Font.PLAIN, 14));
      qna6.add(Q6);
      qna6.add(A6);
      
      qnapanel.add(qna1);
      qnapanel.add(qna2);
      qnapanel.add(qna3);
      qnapanel.add(qna4);
      qnapanel.add(qna5);
      qnapanel.add(qna6);
   }

   public static void main(String[] args) {
	   DB.DBconnect(dbURL, dbID, dbPassword);
//      QnA qna = new QnA("자주 묻는 질문");

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj == btnBack) {
    	  mypage = new Mypage("마이페이지", id);
    	  dispose();
      }
         
      
   }

}