package zJSI;
// 수정

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import db.DB;
import main.MainFrame;
import post.HintTextArea_post;

public class WriteReview3 extends JFrame implements ActionListener, ItemListener {



Font font = new Font("a아이스께끼", Font.BOLD, 23);

Font font2 = new Font("a아이스께끼", Font.PLAIN, 15);

private JPanel mainpanel;
private JRadioButton bad;
private JRadioButton good;
private JRadioButton verygood;
private JCheckBox[] choiceQcheckbox;
private JTextArea ta;
private JPanel Alljp;
private JButton btnexit;
private JButton btnsent;

private JPanel panelsouth;

private JPanel panelBack;

private JButton btnBack;

static String dbURL = "jdbc:mysql://49.50.174.207/powerrainzo";
static String dbID = "blue";
static String dbPassword = "1234";



public WriteReview3() {
	   setSize(500, 700);
	   setLocationRelativeTo(this); 
	   setTitle("거래후기작성");
	   setLayout(new BorderLayout());
	   
	   Alljp = new JPanel();
	   Alljp.setLayout(new BorderLayout());
	   Alljp.setBackground(new Color(125, 230, 119));
	   Alljp.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));	
		
	   setNorth();
	   setCenter();
	   setSouth();
	   
	   add(Alljp);
	   
	   setVisible(true);
   }


private void setNorth() {
	//거래~~어쩌구 말이랑 얼굴 세개를 올리기
	JPanel panel1 = new JPanel();
	panel1.setPreferredSize(new Dimension(100, 190));
	panel1.setLayout(new GridLayout(2,1,0,10));
	panel1.setBackground(Color.white);	
	
	JPanel panel1jemoc = new JPanel();
	panel1jemoc.setBackground(Color.white);	
	panel1jemoc.setBorder(BorderFactory.createEmptyBorder(25,40,20,40));
	JLabel lbljemoc = new JLabel("<HTML><body><center>거래는 어떠셨나요?"
			+ "<br>따뜻한 후기를 남겨주세요</center></body></HTML>");
	lbljemoc.setFont(font); 
	
	JPanel panel1ulgul = new JPanel();
	panel1ulgul.setBackground(Color.white);	
	panel1ulgul.setLayout(new GridLayout(1, 3, 25, 0));
	panel1ulgul.setBorder(BorderFactory.createEmptyBorder(15,110,15,110));
	
	ImageIcon sosoicon = new ImageIcon("images/bad.png");
    Image image4 = sosoicon.getImage();
    Image changeimg4 = image4.getScaledInstance(45, 45,Image.SCALE_SMOOTH);
    ImageIcon changeicon4 = new ImageIcon(changeimg4);
	
    ImageIcon goodicon = new ImageIcon("images/good.png");
    Image image5 = goodicon.getImage();
    Image changeimg5 = image5.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
    ImageIcon changeicon5 = new ImageIcon(changeimg5);

    ImageIcon verygoodicon = new ImageIcon("images/verygood.png");
    Image image6 = verygoodicon.getImage();
    Image changeimg6 = image6.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
    ImageIcon changeicon6 = new ImageIcon(changeimg6);
    
    bad = new JRadioButton(changeicon4);
    good = new JRadioButton(changeicon5);
    verygood = new JRadioButton(changeicon6);
    
    bad.setSelectedIcon(changeicon4);
    bad.setBorderPainted(true);
    bad.setContentAreaFilled(false);
    bad.setContentAreaFilled(false);
    bad.addActionListener(this);
    

    good.setSelectedIcon(changeicon5);
    good.setBorderPainted(true);
    good.setContentAreaFilled(false);
    good.setContentAreaFilled(false);
    good.addActionListener(this);

    
    verygood.setSelectedIcon(changeicon6);
    verygood.setBorderPainted(true);
    verygood.setContentAreaFilled(false);
    verygood.addActionListener(this);
    
    //중복선택불가
    ButtonGroup radiogroup = new ButtonGroup();
    radiogroup.add(bad);
    radiogroup.add(good);
    radiogroup.add(verygood);
    
	panel1jemoc.add(lbljemoc);
	
    panel1ulgul.add(bad);
    panel1ulgul.add(good);
    panel1ulgul.add(verygood);
	
	panel1.add(panel1jemoc);
	panel1.add(panel1ulgul);
	
	Alljp.add(panel1, BorderLayout.NORTH);
}




private void setCenter() {
	mainpanel = new JPanel();
	mainpanel.setLayout(new GridLayout(2,1,0,0));
	mainpanel.setBackground(Color.white);
	
	setpaenlcheck();
	setpanelwrite();

	
	Alljp.add(mainpanel, BorderLayout.CENTER);
	
}



private void setpaenlcheck() {
	JPanel panel2 = new JPanel();	
	panel2.setBackground(Color.white);
	panel2.setLayout(new GridLayout(3,2,5,10));
	panel2.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
	
	String[] choiceQ = {" 시간을 잘 지켜요.", " 상품 설명이 자세해요.",
			" 응답이 빨라요.", " 친절하고 매너가 좋아요.",
			" 저렴하게 판매해요.",
			" 나눔을 해주셨어요."};
	
	choiceQcheckbox = new JCheckBox[6];
	for (int i = 0; i < choiceQ.length; i++) {
		choiceQcheckbox[i] = new JCheckBox(choiceQ[i]);
		choiceQcheckbox[i].setFont(font2);
		choiceQcheckbox[i].setBackground(Color.white);
		choiceQcheckbox[i].addItemListener(this);
		panel2.add(choiceQcheckbox[i]);
	}
	
	
	mainpanel.add(panel2);
}


private void setpanelwrite() {
	JPanel panel3 = new JPanel();
	panel3.setBackground(Color.white);
	panel3.setLayout(null);
	
	JLabel hugijacsung = new JLabel("< 후기 작성란 >", JLabel.LEFT);
	hugijacsung.setFont(new Font("a소나무L", font.BOLD, 13));
	hugijacsung.setBounds(50, 10, 100, 20);
	
	ta = new JTextArea();
	ta = new HintTextArea_post("후기 작성(100자 이내)");
	ta.setBackground(new Color(226, 244, 198));
	ta.setLineWrap(true);	//자동 줄바꿈
	ta.setFont(font2);
	ta.setBounds(50, 35, 350, 100);
	ta.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			if(ta.getText().length() >= 50) {
				e.consume();
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
		
	});
	
	
	panel3.add(hugijacsung);
	panel3.add(ta);
	
	mainpanel.add(panel3);
	
	
}


private void setSouth() {
	panelsouth = new JPanel();
	panelsouth.setLayout(new GridLayout(1,2,20,30));
	panelsouth.setBorder(BorderFactory.createEmptyBorder(5, 110, 55, 110));
	panelsouth.setBackground(Color.white);
	panelsouth.setPreferredSize(new Dimension(100, 90));
	
	btnexit = new JButton("건너뛰기");
	btnexit.addActionListener(this);
	btnexit.setFont(font2);
	btnexit.setBackground(new Color(255, 255, 170));

	
	btnsent = new JButton("보내기");
	btnsent.addActionListener(this);
	btnsent.setFont(font2);
	btnsent.setBackground(new Color(255, 255, 170));
	
	btnexit.setFocusPainted(false);
	btnsent.setFocusPainted(false);
	
	panelsouth.add(btnexit);
	panelsouth.add(btnsent);
	
	Alljp.add(panelsouth, BorderLayout.SOUTH);
	
	
}


public static void main(String[] args) {
	  DB.DBconnect(dbURL, dbID, dbPassword); 
      WriteReview3 rv = new WriteReview3();

   }



private String Satisfaction;

private String check;

private String memo;

@Override
public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();
	
	//만족도(얼굴 라디오버튼) 값 받기
			if(bad.isSelected()) {
				Satisfaction = "나쁨";
			}
			if(good.isSelected()) {
				Satisfaction = "좋음";
			}
			if(verygood.isSelected()) {
				Satisfaction = "매우 좋음";
		}
			
	if(obj == btnexit) {
        if(JOptionPane.showConfirmDialog(this, "후기를 작성하지않고 거래를 끝내시겠습니까?\n(추후 후기 작성은 불가합니다.)", "거래 완료", 
              JOptionPane.YES_NO_OPTION,
              JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
           MainFrame mf = new MainFrame();
           dispose();
        }
     }else if(obj == btnsent) {
    	 
    	 //매너평가(체크박스 값 받기)
    	 check = chk1 + "" + chk2 + "" + chk3 + "" +chk4 + "" + chk5 + "" + chk6;
    	
    	 //후기 값 받기
    	 memo = ta.getText();
    	 
    	 if(!bad.isSelected() && !good.isSelected() && !verygood.isSelected()) {
    		 JOptionPane.showMessageDialog(this, "만족도를 체크해주세요.", "만족도 평가", JOptionPane.ERROR_MESSAGE);
    	 }
    	 else if(!choiceQcheckbox[0].isSelected() && !choiceQcheckbox[1].isSelected() &&!choiceQcheckbox[2].isSelected()
    			 && !choiceQcheckbox[3].isSelected() && !choiceQcheckbox[4].isSelected() && !choiceQcheckbox[5].isSelected()) {
    		 JOptionPane.showMessageDialog(this, "매너평가를 체크해주세요.", "매너평가 체크", JOptionPane.ERROR_MESSAGE);
    	 }
    	 else if(JOptionPane.showConfirmDialog(this, "후기를 전송하시겠습니까?\n(추후 후기 수정은 불가합니다.)", "거래 완료", 
              JOptionPane.YES_NO_OPTION,
              JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
           MainFrame mf  = new MainFrame();
           dispose();
        }
    	 System.out.println(Satisfaction);
    	 System.out.println(check);
    	 System.out.println(memo);
     }
}

//매너평가(중복x)
String chk1;
String chk2;
String chk3;
String chk4;
String chk5;
String chk6;

@Override
public void itemStateChanged(ItemEvent e) {
Object obj = e.getItemSelectable();
	

	if(obj == choiceQcheckbox[0]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk1 = "";
		}else {
			chk1 = choiceQcheckbox[0].getText();
		}
	}
	
	if(obj == choiceQcheckbox[1]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk2 = "";
		}else {
			chk2 = choiceQcheckbox[1].getText();
		}
	}
	
	if(obj == choiceQcheckbox[2]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk3 = "";
		}else {
			chk3 = choiceQcheckbox[2].getText();
		}
	}
	
	if(obj == choiceQcheckbox[3]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk4 = "";
		}else {
			chk4 = choiceQcheckbox[3].getText();
		}
	}
	
	if(obj == choiceQcheckbox[4]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk5 = "";
		}else {
			chk5 = choiceQcheckbox[4].getText();
		}
	}
	
	if(obj == choiceQcheckbox[5]) {
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			chk6 = "";
		}else {
			chk6 = choiceQcheckbox[5].getText();
		}
	}
	

	
}
	
	
}