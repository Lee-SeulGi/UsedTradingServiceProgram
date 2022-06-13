package review;
// 수정

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import profile.Mypage;

public class Receive extends JFrame implements ActionListener {
	private JPanel panelNorth;
	private JButton btnBack;
	private JPanel basePanel;
	private JPanel smilePanel;
	private JPanel chkPanel;
	private JPanel textPanel;
	private Mypage mypage;
	private String id;

	public Receive() {
		
		setResizable(false);
		setTitle("받은 후기");
		setSize(500, 700);
		setLayout(new BorderLayout());
		setLocationRelativeTo(this);
		
		setnorth();
		setcenter();
		
		setVisible(true);
		
	}

	private void setnorth() {
		
		panelNorth = new JPanel();
	    panelNorth.setLayout(new GridLayout(1,3));
	    panelNorth.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
	    panelNorth.setBackground(Color.white);
      
	    JPanel firstP = new JPanel(); //기본 패널의 첫 번쨰 패널(3열)
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
	         
	     JLabel lbl1 = new JLabel(); //여백
	     JLabel lbl2 = new JLabel(); //여백
	     
	      firstP.add(btnBack); 
	      firstP.add(lbl1); 
	      firstP.add(lbl2);
	      
	      JLabel lbl3 = new JLabel("사용자 후기 열람"); //기본 패널의 두 번쨰 패널
	      lbl3.setFont(new Font("a소나무L", Font.BOLD, 22));
	      JLabel lbl4 = new JLabel(); //기본 패널의 세 번째 패널
	      
	      panelNorth.add(firstP);
	      panelNorth.add(lbl3); //타이틀
	      panelNorth.add(lbl4); //여백
	      
	      add(panelNorth,BorderLayout.NORTH);
		
	}

	private void setcenter() {
		basePanel = new JPanel();
		basePanel.setBackground(new Color(125, 230, 119));
		basePanel.setLayout(new BorderLayout());
		basePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		setsmile();
		setchk();
		settext();
		
		add(basePanel);
		
	}

	private void setsmile() {
		smilePanel = new JPanel();
		smilePanel.setLayout(new BorderLayout());
		smilePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 15));
		smilePanel.setPreferredSize(new Dimension(100, 133));
		smilePanel.setBackground(Color.white);
		
			//만족도 평가 문구
			JPanel smilesignP = new JPanel();
			smilesignP.setLayout(new FlowLayout(FlowLayout.LEFT));
			smilesignP.setBackground(new Color(225,240,182));
			smilesignP.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 0));
			smilesignP.setPreferredSize(new Dimension(100,50));

			JLabel smilesignlbl = new JLabel("만족도 평가");
			smilesignlbl.setFont(new Font("a소나무L", Font.BOLD, 20));
			smilesignP.add(smilesignlbl);
			
			//이미지
			JPanel smileimgP = new JPanel();
			smileimgP.setLayout(new FlowLayout(FlowLayout.LEFT));
			smileimgP.setBackground(Color.white);
			smileimgP.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 0));
			smileimgP.setPreferredSize(new Dimension(100,110));
			
			ImageIcon verygood = new ImageIcon("images/good.png");
		    Image verygoodimg = verygood.getImage();
		    Image verygoodsize = verygoodimg.getScaledInstance(65, 53, Image.SCALE_SMOOTH);
		    ImageIcon verygoodicon = new ImageIcon(verygoodsize);
		    JLabel verygoodlbl = new JLabel(verygoodicon);
			smileimgP.add(verygoodlbl);
		
		smilePanel.add(smilesignP, BorderLayout.NORTH);
		smilePanel.add(smileimgP, BorderLayout.CENTER);
		basePanel.add(smilePanel, BorderLayout.NORTH);
		
	}

	private void setchk() {
		chkPanel = new JPanel();
		chkPanel.setLayout(new BorderLayout());
		chkPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		chkPanel.setBackground(Color.white);
		
			//매너 평가 문구
			JPanel chksignP = new JPanel();
			chksignP.setLayout(new FlowLayout(FlowLayout.LEFT));
			chksignP.setBackground(new Color(225,240,182));
			chksignP.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 0));
			chksignP.setPreferredSize(new Dimension(100,50));
			
			JLabel chksignlbl = new JLabel("매너 평가");
			chksignlbl.setFont(new Font("a소나무L", Font.BOLD, 20));
			chksignP.add(chksignlbl);
			
			//매너 평가 
			JPanel chklistP = new JPanel();
			chklistP.setLayout(new GridLayout(6,1,5,10));
			chklistP.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 0));
			chklistP.setBackground(Color.white);
			
			Font chkfont = new Font("a소나무L", Font.PLAIN, 14);
			JLabel chk1 = new JLabel("-  시간을 잘 지켜요."); chk1.setFont(chkfont);
			JLabel chk2 = new JLabel("-  상품 설명이 자세해요."); chk2.setFont(chkfont);
			JLabel chk3 = new JLabel("-  응답이 빨리요."); chk3.setFont(chkfont);
			JLabel chk4 = new JLabel("-  친절하고 매너가 좋아요."); chk4.setFont(chkfont);
			JLabel chk5 = new JLabel("-  저렴하게 판매해요."); chk5.setFont(chkfont);
			JLabel chk6 = new JLabel("-  나눔을 해주셨어요."); chk6.setFont(chkfont);
			chklistP.add(chk1);
			chklistP.add(chk2);
			chklistP.add(chk3);
			chklistP.add(chk4);
			chklistP.add(chk5);
			chklistP.add(chk6);
			
		chkPanel.add(chksignP, BorderLayout.NORTH);
		chkPanel.add(chklistP);
		basePanel.add(chkPanel, BorderLayout.CENTER);
		
		
	}

	private void settext() {
		textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
		textPanel.setPreferredSize(new Dimension(100, 180));
		textPanel.setBackground(Color.white);
			
			//후기
			JPanel textsignP = new JPanel();
			textsignP.setLayout(new FlowLayout(FlowLayout.LEFT));
			textsignP.setBackground(new Color(225,240,182));
			textsignP.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 0));
			textsignP.setPreferredSize(new Dimension(100,50));
			
			JLabel textsignlbl = new JLabel("후기");
			textsignlbl.setFont(new Font("a소나무L", Font.BOLD, 20));
			textsignP.add(textsignlbl);
			
			//텍스트에리어
			JTextArea textarP = new JTextArea();
			textarP.setBackground(Color.white);
			textarP.setLayout(new BorderLayout());
			textarP.setBorder(BorderFactory.createEmptyBorder(4, 2, 3, 2));
			
			JTextArea textar = new JTextArea("안녕하세요.");
			textar.setFont(new Font("a소나무L", Font.PLAIN, 14));
			textar.setBackground(Color.white);
			textar.setLineWrap(true);
			textar.setEditable(false);
			
			JScrollPane jscroll = new JScrollPane(textar, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
			textarP.add(jscroll, BorderLayout.CENTER);
		
		
		textPanel.add(textsignP, BorderLayout.NORTH);
		textPanel.add(textarP, BorderLayout.CENTER);
		basePanel.add(textPanel, BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {
		Receive receive = new Receive();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnBack) {
			mypage = new Mypage("마이페이지", id);
		}
		
	}

}
