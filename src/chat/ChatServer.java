package chat;

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import chat.ChatServer;
import db.DB;
import main.MainFrame;
import post.Posting;
import review.WriteReview;

public class ChatServer extends JFrame implements ActionListener, Runnable, MouseListener{
	
//	private JPanel panelCenter;
//	private JPanel panelSouth;
//	
//	private JTextField tf;
//	private JButton btn;
//	private JButton btn2;
	
//	private JTextArea ta;
	
	private JPanel panelCenter;
	private JPanel panelSouth;
	
	private JTextField tf =null;
	private JButton btn;
	
	private JPanel panelNorth;
	private JButton btnBack;

	private JButton btnreport;
	private JButton btnhouse;
	private JLabel lblclient;
	private ImageIcon imgclient;
	private Image imgsize2;
	private Image img2;
	private ImageIcon iconclient;
	private report rp;
	private JButton btnphoto;
	
	private ServerSocket server = null;
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private JLabel lblN8;
	private JButton btnwritehugi;
	private JTextPane jtp;
	private ChatClient cc;
	
	SimpleAttributeSet Wait = new SimpleAttributeSet();
	SimpleAttributeSet Itsme = new SimpleAttributeSet();
	SimpleAttributeSet Sandebang = new SimpleAttributeSet();
	
	private ImageIcon iconphoto;
	private File selectedFile;
	private Posting gesimul;
	private MainFrame mf;
	private WriteReview writeR;
	private ChatServer chatserver;
	private static String id;
	
	static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
	static String dbID="blue";
	static String dbPassword="1234";

	public ChatServer(String title, String id) {
		this.id = id;
		
		//연결 중
		StyleConstants.setItalic(Wait, true);
		StyleConstants.setFontSize(Wait, 12);
		
		//본문 글자 - 나
//	    StyleConstants.setForeground(Itsme, Color.blue);
	    StyleConstants.setBold(Itsme, true);
	    //본문 글자 - 너
//	    StyleConstants.setForeground(Sandebang, Color.black);
		
		
		setTitle(title);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocation(500, 80);
		setSize(500, 700);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout());
		
		setNorth();
		
		setCenter();
		
		setSouth();	
		
		setVisible(true);
		
//		tf.setFocusable(true);
		tf.requestFocus();
	}

	private void setNorth() {
		panelNorth = new JPanel();
		panelNorth.setBackground(Color.white);
		panelNorth.setLayout(new FlowLayout());
		panelNorth.addMouseListener(this);
		
		JPanel panelbtn2 = new JPanel();
		panelbtn2.setBackground(Color.white);
		panelbtn2.setLayout(new GridLayout(1,2,2,5));
		panelbtn2.setPreferredSize(new Dimension(110, 35));
		
		ImageIcon iconBack = new ImageIcon("images/return.png");
	    Image img1 = iconBack.getImage();
	    Image changeImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon1 = new ImageIcon(changeImg1);
	    btnBack = new JButton(changeIcon1);
	    btnBack.addActionListener(this);
	    
	    ImageIcon iconHome = new ImageIcon("images/house.png");
	    Image img2 = iconHome.getImage();
	    Image changeImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon2 = new ImageIcon(changeImg2);
	    btnhouse = new JButton(changeIcon2);
	    btnhouse.addActionListener(this);
	    
	    panelbtn2.add(btnBack);
	    panelbtn2.add(btnhouse);
	    
	    JLabel lblJEMOC = new JLabel("    채팅하기", JLabel.CENTER);
	    lblJEMOC.setFont(new Font("a소나무L", Font.BOLD, 18));
	    lblJEMOC.setPreferredSize(new Dimension(195,40));
	    
	    btnwritehugi = new JButton("거래확정 >");
	    btnwritehugi.addActionListener(this);
	    
	    btnwritehugi.setFont(new Font("a소나무L", Font.BOLD, 11));
	    btnwritehugi.setPreferredSize(new Dimension(86,36));
	    btnwritehugi.setBackground(new Color(255, 255, 170));
	    btnwritehugi.setFocusPainted(false);

	    
	    
	    ImageIcon iconMore = new ImageIcon("images/report.png");
	    Image img3 = iconMore.getImage();
	    Image changeImg3 = img3.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon3 = new ImageIcon(changeImg3);
	    btnreport = new JButton(changeIcon3);
	    btnreport.setPreferredSize(new Dimension(50,35));
	    btnreport.addActionListener(this);
	    
	    btnBack.setContentAreaFilled(false);	//버튼 배경색 없앰(푸르딩딩한거)
	    btnhouse.setContentAreaFilled(false);
	    btnreport.setContentAreaFilled(false);
	    
	    btnBack.setFocusPainted(false);			//버튼 누르면 이미지에 맞춰 테두리 생기는거 없앰.
	    btnhouse.setFocusPainted(false);
	    btnreport.setFocusPainted(false);
	    
	    panelNorth.add(panelbtn2);
	    panelNorth.add(lblJEMOC);
	    panelNorth.add(btnreport);
	    panelNorth.add(btnwritehugi);

	    
	    add(panelNorth, BorderLayout.NORTH);
	}


	private void setCenter() {
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(125, 230, 119));
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
		
		
		jtp = new JTextPane();
		jtp.setFont(new Font("a소나무L", Font.PLAIN, 14));
		
		JScrollPane sp = new JScrollPane(jtp,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(460, 533));
		
		panelCenter.add(sp);
		
		add(panelCenter, BorderLayout.CENTER);
	}

	public JTextPane getJtp() {
		return jtp;
	}

	private void setSouth() {	
		panelSouth = new JPanel();
		panelSouth.setBackground(Color.white);
		panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	
		
		ImageIcon iconphoto = new ImageIcon("images/photo.png");
		Image img2 = iconphoto.getImage();
		Image imgsize2 = img2.getScaledInstance(42, 35, Image.SCALE_SMOOTH);
		ImageIcon imgphoto = new ImageIcon(imgsize2);
		btnphoto = new JButton(imgphoto);
		btnphoto.setPreferredSize(new Dimension(40, 30));		
		btnphoto.addActionListener(this);
		
		btnphoto.setContentAreaFilled(false);
		btnphoto.setFocusPainted(false);
		btnphoto.setOpaque(false);
		
		panelSouth.add(btnphoto);
		
		tf = new JTextField(41);
		tf.setFont(new Font("a소나무L", Font.PLAIN, 12));
		tf.setPreferredSize(new Dimension(41, 28));
		tf.addActionListener(this);
		panelSouth.add(tf);
		
		
		btn = new JButton("전 송");
		btn.setFont(new Font("a소나무L", Font.BOLD, 11));
		btn.setBackground(new Color(255, 255, 170));
		btn.setPreferredSize(new Dimension(80, 28));
		btn.addActionListener(this);
		btn.setFocusPainted(false);
		panelSouth.add(btn);
		
		add(panelSouth, BorderLayout.SOUTH);
	}

	public void setSocketServer() {
		System.out.println("XXX");
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn || obj == tf) {
			localType();
		}else if(obj == btnreport) {
			if(JOptionPane.showConfirmDialog(this, "사용자를 신고하시겠습니까?", "신고"
					, JOptionPane.YES_NO_OPTION
					, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				report rp = new report("신고하기", 500, 80);
//				dispose();
			}
		}else if(obj == btnBack) {
			if(JOptionPane.showConfirmDialog(this, "채팅창을 나가시겠습니까?\n대화내용은 복원되지않습니다.", "종료", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
				gesimul = new Posting("게시물", null, null, null);
				dispose();
			}
		}else if(obj == btnhouse) {
			if(JOptionPane.showConfirmDialog(this, "채팅창을 나가시겠습니까?\n대화내용은 복원되지않습니다.", "종료", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
				mf = new MainFrame();
				dispose();
			}
		}else if(obj == btnwritehugi){
			if(JOptionPane.showConfirmDialog(this, "거래 확정 여부는 판매자만 선택 할 수 있습니다.\n후기를 작성하시겠습니까?", "거래확정", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.CANCEL_OPTION) == JOptionPane.YES_OPTION) {
				writeR = new WriteReview();
				dispose();
			}
		}else if(obj == btnphoto) {
			JFileChooser fc = new JFileChooser();
			
			fc.addChoosableFileFilter(new FileNameExtensionFilter("PNG", "png"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg"));
			
			fc.showOpenDialog(null);
			
			selectedFile = fc.getSelectedFile();
			BufferedReader br = null;
			String line = null;
			
			String filepath = fc.getSelectedFile().getPath();
			try {
				out.write(filepath + "\n");
				out.flush();
				iconphoto = new ImageIcon(filepath);
				Image img2 = iconphoto.getImage();
				Image imgsize2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				
				insertDocContent("[구매자] : \n",  Itsme);
				insertDocContent(new ImageIcon(imgsize2));
				insertDocContent( "\n",  Itsme);
			
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			
		}
			
		
	}

	private void localType() {
		try {
			
			String outMessage = tf.getText();
			out.write(outMessage + "\n");
			out.flush();
//			ta.append("[구매자] : " + outMessage + "\n");
			insertDocContent("[구매자] : " + outMessage + "\n",  Itsme);
			
			tf.setText("");
			tf.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public JButton getBtn() {
		return btn;
	}

	
	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
		ChatServer cs = new ChatServer("구매자", id);
		Thread th = new Thread(cs);
		th.start();
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket(9999);
			insertDocContent(">> 판매자의 응답을 기다리는 중입니다.\n",  Wait);
			socket = server.accept();
			insertDocContent(">> 판매자와 채팅이 연결되었습니다!\n",  Wait);
			insertDocContent("------------------------------------------------------------------------------\n",  Wait);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMessage = in.readLine();
				
				if(inMessage.equals("수고하십시오.")) {
					insertDocContent("\n>> 판매자가 거래를 확정하였습니다. 거래확정을 누르시면, 후기를 작성하실 수 있습니다.",  Wait);
					break;	
				}

				if(inMessage.contains("\\")) {
					
					ImageIcon iconphoto = new ImageIcon(inMessage);
					Image img2 = iconphoto.getImage();
					Image imgsize2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					
					insertDocContent("[판매자] : \n",  Sandebang);
					insertDocContent(new ImageIcon(imgsize2));
					insertDocContent( "\n",  Sandebang);
					
					}else {
						
						insertDocContent("[판매자] : "+ inMessage + "\n",  Sandebang);
					}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	  //커서를 textpane 끝으로 이동
	  private void setInsertiontoDocEnd()
	  {
	    Document doc = jtp.getDocument();
	    int CurrentDocLength = doc.getLength();
	    jtp.setSelectionStart(CurrentDocLength);
	    jtp.setSelectionEnd(CurrentDocLength);
	  }
	  
	  
	  //이미지 넣기
	  private void insertDocContent(ImageIcon img)
	  {
	    setInsertiontoDocEnd();
	    jtp.insertIcon(img);
	  }  
	  
	  
	  //기본 텍스트 (+스타일)
	  private void insertDocContent(String text, SimpleAttributeSet TextStyle)
	  {
		  
	    setInsertiontoDocEnd();
	    Document doc = jtp.getDocument();
	    try {
	      doc.insertString(doc.getLength(), text, TextStyle);
	    } catch (BadLocationException e) {
	      e.printStackTrace();
	    }
	  }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			cc = new ChatClient("판매자", chatserver, id);
			Thread th = new Thread(cc);
			th.start();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
