package profile;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import main.MainFrame;
import review.Receive;


public class Review extends JFrame implements ActionListener, MouseListener{

	private JPanel PanBase,PanNor, PanMid, PanCen, PanTop;
	private JToolBar toolBar;
	private JButton btnExit,btnHome, btnMore;
	private JLabel profilelbl,reviewlbl;
	private DefaultListModel reviewmodel;
	private JList reviewlist;
	private ImageIcon iconExit;
	private JLabel lblprofile;
	private JPanel toolPan, p, p1, p2;
	private JLabel lblN1,lblN2,lblN3,lblN4,lblN5,lblN6,lblN7, lblN8, lblI;
	private MainFrame mainFrame;
	private MainFrame mf;
	private JLabel lblN9;
	private Receive receive;

	public Review(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		setTitle("거래 후기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocation(350,5);
		setSize(500, 700);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout());
		
		setBase();
		
		add(PanBase);
		setVisible(true);
	}
	
	private void setBase() {
		PanBase = new JPanel();
		PanBase.setBackground(Color.white);
		PanBase.setLayout(new BorderLayout());
		
		setNor();
		setCen();
		
		PanBase.add(PanNor,BorderLayout.NORTH);
		PanBase.add(PanCen,BorderLayout.CENTER);
	}
	private void setNor() {
		PanNor = new JPanel();
		PanNor.setBackground(Color.white);
		PanNor.setLayout(new BorderLayout());
	
		toolPan = new JPanel();
		toolPan.setLayout(new GridLayout(1,10));
		toolPan.setBackground(Color.white);
		toolPan.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		
		iconExit = new ImageIcon("images/return.png");//뒤로가기 버튼 이미지 넣기
		Image img = iconExit.getImage();
		Image imgsize = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon imgcha = new ImageIcon(imgsize);
		btnExit = new JButton(imgcha);
		btnExit.addActionListener(this);
		
//		ImageIcon iconHome = new ImageIcon("images/HOME.png");
//	    Image img2 = iconHome.getImage();
//	    Image changeImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
//	    ImageIcon changeIcon2 = new ImageIcon(changeImg2);
//	    btnHome = new JButton(changeIcon2);
//	    btnHome.addActionListener(this);
	    
	    btnExit.setContentAreaFilled(false);
	    btnExit.setFocusPainted(false);
	    
//	    btnHome.setContentAreaFilled(false);
//	    btnHome.setFocusPainted(false);
	    
	    
	    lblN1 = new JLabel();
	    lblN2 = new JLabel();
	    lblN3 = new JLabel();
	    lblN4 = new JLabel();
	    lblN5 = new JLabel();
	    lblN6 = new JLabel();
	    lblN7 = new JLabel();
	    lblN8 = new JLabel();
	    lblN9 = new JLabel();

	    btnExit.setContentAreaFilled(false);
//	    btnHome.setContentAreaFilled(false);
	    
	    toolPan.add(btnExit);
//		toolPan.add(btnHome);
		toolPan.add(lblN1);
		toolPan.add(lblN2);
		toolPan.add(lblN3);
		toolPan.add(lblN4);
		toolPan.add(lblN5);
		toolPan.add(lblN6);
		toolPan.add(lblN7);      
		toolPan.add(lblN8);
		toolPan.add(lblN9);

		PanNor.add(toolPan);
	}

	private void setCen() {
		PanCen = new JPanel();
		PanCen.setBackground(new Color(125,230,119));
		PanCen.setLayout(new BorderLayout());
		PanCen.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		PanMid = new JPanel();
		PanMid.setLayout(new BorderLayout());
		PanMid.setBackground(Color.WHITE);
		PanMid.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setBackground(Color.WHITE);
		p1.setBorder(BorderFactory.createEmptyBorder(10,20,0,10));

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.setBackground(Color.WHITE);
		p2.setBorder(BorderFactory.createEmptyBorder(15,25,5,0));
		
		ImageIcon iconProfile = new ImageIcon("images/na.png");
		Image img = iconProfile.getImage();
		Image imgsize = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imgcha = new ImageIcon(imgsize);
		lblprofile = new JLabel(imgcha);
		
		profilelbl = new JLabel("김조구만");
		profilelbl.setFont(new Font("a소나무L",Font.BOLD, 25));
		
		ImageIcon iconI = new ImageIcon("images/star.png");
		Image imgI = iconI.getImage();
		Image imgIsize = imgI.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		ImageIcon imgIcha = new ImageIcon(imgIsize);
		
		lblI = new JLabel(imgIcha);		
		
		reviewlbl = new JLabel("거래 후기"); 
		reviewlbl.setFont(new Font("a소나무L",Font.PLAIN, 17));
		
		reviewmodel = new DefaultListModel<>();
		reviewmodel.addElement("후기1");
		reviewmodel.addElement("후기2");
		reviewmodel.addElement("후기3");
		
		reviewlist = new JList<>(reviewmodel);
		reviewlist.setFont(new Font("a소나무L",Font.PLAIN, 15));
		reviewlist.addMouseListener(this);
		
		p = new JPanel();
		p.setBackground(Color.WHITE);
		
		JScrollPane sp = new JScrollPane(reviewlist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(390,380));
		
		p.setBorder(BorderFactory.createEmptyBorder(0,20,40,20)); //위,왼쪽,아래,오른
		
		
		p1.add(lblprofile);
		p1.add(profilelbl);
		p2.add(lblI);
		p2.add(reviewlbl);
		PanMid.add(p1, BorderLayout.NORTH);
		PanMid.add(p2, BorderLayout.CENTER);
		p.add(sp);
		PanCen.add(PanMid, BorderLayout.NORTH);
		PanCen.add(p, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		Review rv = new Review(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =  e.getSource();
		if(obj == btnExit) {//뒤로가기 버튼 누르면...
			mf = new MainFrame();
			setVisible(false);
		}else if(obj == btnHome) {//홈 버튼 누르면,,,
			//ChatFrame cf = new ChatFrame();
		}//리스트에서 후기 누르면~~
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(e.getClickCount() == 2) {
			receive = new Receive();
			setVisible(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		reviewlist.setLocation(e.getPoint());
//		System.out.println("!");
		
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