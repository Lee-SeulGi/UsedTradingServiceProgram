package start;


import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import db.DB;
import login.Login;

 

public class Start extends JFrame implements ActionListener {

	private ImageIcon mainimg;

	private JLabel mainlbl;

	private JPanel mainpanel;

	private JButton startbutton;

	private JPanel startpanel;

	private JPanel imgpanel;

	private Login lg;

	static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
	static String dbID="blue";
	static String dbPassword="1234";
	
	public Start(String title){

		setSize(500, 700);
		setLocationRelativeTo(this); 
		setTitle("시작창");

		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		
		imgpanel = new JPanel();
		imgpanel.setBounds(0,0,485,670);
		imgpanel.setBackground(new Color(226, 244, 198));
		imgpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15,25));	

 

		mainimg = new ImageIcon("images/startdino.png"); //300px540px
		Image imgset = mainimg.getImage();
		Image imgsize = imgset.getScaledInstance(455, 635, Image.SCALE_SMOOTH);
		ImageIcon chamain = new ImageIcon(imgsize);
		mainlbl = new JLabel(chamain);
		
		
		imgpanel.add(mainlbl);
		

		startpanel = new JPanel();
		startpanel.setBackground(Color.white);
		startpanel.setBounds(190,360,100,100);


		startbutton = new JButton("시작하기");
		startbutton.setBackground(new Color(255, 255, 170));
		startbutton.setFont(new Font("a소나무L", Font.BOLD, 15));
		startbutton.addActionListener(this);
		
		startbutton.setPreferredSize(new Dimension(99,40));
		startbutton.setFocusPainted(false);



		startpanel.add(startbutton);


		mainpanel.add(imgpanel);
		mainpanel.add(startpanel);

		

		add(mainpanel);

		

		

		setVisible(true);

	}
 

	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
		Start main = new Start("채팅");

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == startbutton) {
			lg = new Login("채팅");
			dispose();
		}
	}

 

}