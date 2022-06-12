package zKHB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.MainFrame;


public class report extends JFrame implements ActionListener{
	private JPanel panelNorth;
	private JButton btnBack;
	private JLabel lblN1;
	private JLabel lblN2;
	private JLabel lblN3;
	private JLabel lblN4;
	private JLabel lblN5;
	private JLabel lblN6;
	private JLabel lblN7;
	private JLabel lblN8;
	private JLabel lblN9;
	private JCheckBox[] reportcheck;
	private JButton btnreport;
	private MainFrame mf;

	public report(String title, int x, int y) {
		
		
		setTitle(title);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(x, y);
		setSize(500, 700);
		setLayout(new BorderLayout());
		
		setNorth();
		setCenter();
		setSouth();
		
		setVisible(true);	
		
	}


	private void setNorth() {
			panelNorth = new JPanel();
			panelNorth.setLayout(new GridLayout(1,3));
			panelNorth.setBackground(Color.white);
			panelNorth.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
			
			JPanel firstP = new JPanel();
			firstP.setLayout(new GridLayout(1,3,10,0));
			firstP.setBackground(Color.white);
			
			ImageIcon iconBack = new ImageIcon("images/return.png");
		    Image img1 = iconBack.getImage();
		    Image changeImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		    ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		    btnBack = new JButton(changeIcon1);
		    btnBack.addActionListener(this);
		    
		    lblN1 = new JLabel();
		    lblN2 = new JLabel();
		    
		    firstP.add(btnBack);
		    firstP.add(lblN1);
		    firstP.add(lblN2);
		    
		    lblN3 = new JLabel("사용자 신고", JLabel.CENTER);
		    lblN3.setFont(new Font("a아이스께끼", Font.BOLD, 19));
		    lblN4 = new JLabel();

		    btnBack.setContentAreaFilled(false);	//버튼 배경색 없앰(푸르딩딩한거)
		    btnBack.setFocusPainted(false);			//버튼 누르면 이미지에 맞춰 테두리 생기는거 없앰.
		    
		    panelNorth.add(firstP);
		    panelNorth.add(lblN3);
		    panelNorth.add(lblN4);
		    
		    add(panelNorth, BorderLayout.NORTH);
		
	}
	private void setCenter() {
		JPanel panelcenter = new JPanel();
		panelcenter.setBackground(new Color(222, 255, 210));

		panelcenter.setLayout(new GridLayout(7,1));
		panelcenter.setBorder(BorderFactory.createEmptyBorder(30, 20, 40, 20));	
		
		JLabel reasonlbl = new JLabel("  신고하는 이유를 선택해주세요.");
		reasonlbl.setForeground(Color.white);
		reasonlbl.setBackground(new Color(50, 100, 50));
		reasonlbl.setOpaque(true);
		reasonlbl.setFont(new Font("a아이스께끼", Font.BOLD, 15));
		
		panelcenter.add(reasonlbl);
		
		String[] reportlist = {" 비매너 사용자에요", " 욕설을 해요", " 성희롱을 해요"
							, " 사기당했어요", " 거래 / 환불 분쟁", " 전문 판매업자 같아요"};
		
		reportcheck = new JCheckBox[6];
		for (int i = 0; i < reportcheck.length; i++) {
			reportcheck[i] = new JCheckBox(reportlist[i]);
			reportcheck[i].setFont(new Font("a아이스께끼", Font.PLAIN, 13));
			reportcheck[i].setBackground(Color.white);
			panelcenter.add(reportcheck[i]);
		}
		
		add(panelcenter, BorderLayout.CENTER);
		
	}
	

	private void setSouth() {
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(222, 255, 210));
		panelSouth.setPreferredSize(new Dimension(100, 200));
		
		btnreport = new JButton("신고하기");
		btnreport.addActionListener(this);
		btnreport.setFont(new Font("a아이스께끼", Font.PLAIN, 16));
		btnreport.setPreferredSize(new Dimension(100,30));
		btnreport.setBackground(new Color(255, 255, 170));
		
		btnreport.setFocusPainted(false);
		
		panelSouth.add(btnreport);
		
		add(panelSouth, BorderLayout.SOUTH);
	}

//	public static void main(String[] args) {
//		new report("신고하기");
//	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnreport) {
			if(!reportcheck[0].isSelected() && !reportcheck[1].isSelected() 
					&& !reportcheck[2].isSelected() && !reportcheck[3].isSelected()
					&& !reportcheck[4].isSelected() && !reportcheck[5].isSelected()) {
				JOptionPane.showMessageDialog(this, "신고하는 이유를 선택해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "신고가 처리되었습니다.\n감사합니다.", "신고", JOptionPane.PLAIN_MESSAGE);
				mf = new MainFrame();
				dispose();
			}
		}else if(obj == btnBack) {
			if(JOptionPane.showConfirmDialog(this, "신고를 취소 하시겠습니까?", "신고 취소"
					, JOptionPane.YES_NO_OPTION
					, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
//				ChatServer cs = new ChatServer("채팅하기");
				dispose();
			}
		}
	}
}
