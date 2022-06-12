package profile;
// 수정

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import db.DB;

public class Policy extends JFrame implements ActionListener {
	
	private JPanel sPanelNorth;
	private JPanel sPanelCenter;
	private JLabel lblServiceTitle;
	private JButton btnBack;
	private JPanel sPanelCenterWhite;
	private JTextArea taServiceData;
	private Mypage mypage;

	private static String id;
	
	static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
	static String dbID="blue";
	static String dbPassword="1234";
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
		
	}
	
	public Policy(String title, String id) {
		this.id = id;
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 50);
		setSize(500, 700);
		setLayout(new BorderLayout());
		setLocationRelativeTo(this); 
		
		servicePanelNorth();
		servicePanelCenter();
		
		setVisible(true);
	}

	// 상단 패널
	private void servicePanelNorth() {
		sPanelNorth = new JPanel();
		sPanelNorth.setLayout(new FlowLayout());
		
		lblServiceTitle = new JLabel("개인정보처리방침        ");
		lblServiceTitle.setFont(new Font("a소나무L", Font.BOLD, 24));
		lblServiceTitle.setHorizontalAlignment(JLabel.CENTER);
		lblServiceTitle.setPreferredSize(new Dimension(400, 39));
		
		ImageIcon iconBack = new ImageIcon("images/return.png");
		Image imgBack = iconBack.getImage();
		Image changeImgBack = imgBack.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		ImageIcon changeIconBack = new ImageIcon(changeImgBack);
		btnBack = new JButton(changeIconBack);
		btnBack.setPreferredSize(new Dimension(55, 37));
		btnBack.addActionListener(this);
		
		
		
		// 버튼의 내용영역 채우기 사용 안함
		btnBack.setContentAreaFilled(false);
		// 버튼이 선택되었을때 생기는 테두리 사용 안함
		btnBack.setFocusPainted(false);
		// 버튼을 투명하게 설정
		btnBack.setOpaque(false);
		
		sPanelNorth.add(btnBack);
		sPanelNorth.add(lblServiceTitle);
		
		add(sPanelNorth,BorderLayout.NORTH);
		sPanelNorth.setBackground(Color.WHITE);
	}
	
	// 중간 패널
	private void servicePanelCenter() {
		
		sPanelCenter = new JPanel();
		sPanelCenter.setLayout(new BorderLayout());
		sPanelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		sPanelCenter.setBackground(new Color(125, 230, 119));
		
		sPanelCenterWhite = new JPanel();
		sPanelCenterWhite.setLayout(new BorderLayout());
		sPanelCenterWhite.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		sPanelCenterWhite.setBackground(Color.WHITE);
		
		taServiceData = new JTextArea(" 다이노마켓 주식회사(이하 “회사” 또는 “다이노마켓”이라 함)는 개인정보 보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다."
				+ "\n\n 1. 개인정보의 처리 목적\r\n"
				+ "다이노마켓은 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며, 이용 목적이 변경되는 경우에는 개인정보 보호법 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.\r\n"
				+ "\n가.홈페이지 회원 가입 및 관리\r\n"
				+ "회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정이용 방지, 각종 고지·통지 등을 목적으로 개인정보를 처리합니다.\r\n"
				+ "나.재화 또는 서비스 제공\r\n"
				+ "물품배송, 서비스 제공, 콘텐츠 제공, 맞춤서비스 제공, 본인인증, 연령인증, 요금결제·정산 등을 목적으로 개인정보를 처리합니다.\r\n"
				+ "다.마케팅 및 광고에의 활용\r\n"
				+ "신규 서비스(제품) 개발 및 맞춤 서비스 제공, 이벤트 참여기회 제공, 광고성 정보제공, 접속빈도 파악 또는 회원의 서비스 이용에 대한 통계 등을 목적으로 개인정보를 처리합니다.\r\n"
				+ "라.회원간의 사기 및 분쟁 방지\r\n"
				+ "거래관련 사기 및 분쟁 방지, 발생된 거래관련 사기 및 분쟁에 대한 대응 등을 목적으로 개인정보를 처리합니다."
				+ "\n\n2. 개인정보 처리 및 보유기간\r\n"
				+ "전자상거래 등에서의 소비자 보호에 관한 법률, 전자금융거래법, 통신비밀보호법 등 법령에서 일정기간 정보의 보관을 규정하는 경우는 아래와 같습니다. 다이노마켓는 이 기간 동안 법령의 규정에 따라 개인정보를 보관하며, 본 정보를 다른 목적으로는 절대 이용하지 않습니다."
				+ "\n\n3. 개인정보의 제3자 제공\r\n"
				+ "다이노마켓은 고객의 개인정보를 서비스이용약관, 개인정보처리방침의 개인정보의 처리 목적에서 알린 범위 내에서 사용하며, 이 범위를 초과하여 이용하거나 타인 또는 다른 기업·기관에 제공하지 않습니다. 단, 고객의 동의가 있거나 법령에 의하여 정해진 절차에 따라 정보를 요청받은 경우는 예외로 하며, 이 경우 주의를 기울여 개인정보를 이용 및 제공할 수 있습니다."
				+ "\n\n- 제3자 제공 업무 발생 시, 필요시점에 고객에게 별도로 알리고 동의받는 절차가 진행됩니다.\r\n"
				+ "- 제3자 제공 동의를 거부하실 수 있으며, 동의 거부는 회원가입과 서비스 사용에 영향을 미치지 않습니다.\r\n"
				+ "- 다이노마켓가 제공하는 서비스를 통해 거래가 성사되었을 때에는 쌍방 당사자간의 물품거래와 배송과 관련한 정보를 필요한 범위 내에서 쌍방당사자에게 제공합니다.\r\n"
				+ "- 개인정보 제공 현황은 제휴관계의 개시 또는 종료에 따라 변동될 수 있으며 개인정보 제공과 함께 목록에 게시됩니다. 제휴관계가 종료되면 개인정보의 파기와 함께 목록에서 삭제 됩니다."
				+ "\n\n4. 개인정보처리의 위탁\r\n"
				+ "다이노마켓는 업무위탁계약서 등을 통하여 위탁업무 수행목적 외 개인정보의 처리 금지에 관한 사항, 개인정보의 기술적, 관리적 보호조치에 관한 사항, 위탁업무의 목적 및 범위, 재위탁 제한에 관한 사항, 개인정보에 대한 접근 제한 등 안전성 확보 조치에 관한 사항, 위탁업무와 관련하여 보유하고 있는 개인정보의 관리현황 점검 등 감독에 관한 사항, 개인정보 사고시의 책임부담, 처리 종료 후의 개인정보의 반환 또는 파기 의무 등을 규정하고, 이를 준수하도록 관리하고 있습니다.\r\n"
				+ "다이노마켓는 보다 나은 서비스 제공, 고객편의 제공 등 원활한 업무 수행을 위하여 다음과 같이 개인정보 처리 업무를 외부 전문업체에 위탁하여 운영하고 있습니다.\r\n"
				+ "수탁업체 리스트는 해당 서비스 변경 및 계약기간에 따라 변경될 수 있으며 변경 시 개인정보처리방침을 통해 공지합니다."
				+ "\n\n5. 정보주체의 권리/의무 및 행사방법\r\n"
				+ "가. 정보주체는 다이노마켓에 언제든지 개인정보 열람·정정·삭제·처리정지 요구 등의 권리를 행사할 수 있습니다.\r\n"
				+ "나. ‘가’항에 따른 열람·정정 권리 행사는 아래와 같이 하실 수 있으며 다이노마켓는 이에 대해 지체없이 조치하겠습니다.\r\n"
				+ "다. ‘가’항에 따른 삭제·처리정지 권리 행사는 회원탈퇴 또는 고객센터를 통해 처리할 수 있으며 다이노마켓는 이에 대해 지체없이 조치하겠습니다.\r\n"
				+ "라. ‘가’항에 따른 권리 행사는 개인정보 보호법 제38조 제1항에 따라 정보주체의 위임을 받은 대리인을 통하여 하실 수도 있습니다. 이 경우 개인정보 처리 방법에 관한 고시 별지 제 11 호 서식에 따른 위임장을 제출하셔야 합니다.\r\n"
				+ "마. 개인정보 열람·정정·삭제·처리정지 요구는 개인정보 보호법 제35조 제4항, 제 36조 1항, 제37조제 2항에 의하여 정보주체의 권리가 제한될 수 있습니다."
				+ "\n\n6. 처리하는 개인정보의 항목\r\n"
				+ "다이노마켓는 서비스 이용에 반드시 필요한 개인정보를 다음과 같은 목적을 위하여 처리합니다. 처리하는 개인정보는 다음의 목적 이외의 용도로는 처리되지 않으며, 처리 목적과 항목이 변경되는 경우에는 필요한 조치를 이행할 것입니다."
				+ "서비스 이용과정이나 개인정보 처리과정에서 다음과 같은 정보들이 자동생성/수집되고 다음의 목적으로 이용될 수 있습니다.\r\n"
				+ "\r\n"
				+ "가. 서비스 이용내역, 결제내역, 불량이용기록, 접속로그, 번개톡 대화내역, 상담내용 : 서비스 제공 관련 고객상담, 분쟁처리 등의 목적\r\n"
				+ "나. 휴대폰 모델명 : 통계 및 서비스 품질 향상을 위한 목적\r\n"
				+ "다. 접속 IP 주소 : 의심거래 이용자에 대한 수사협조 목적\r\n"
				+ "라. 광고식별자, 단말기 OS 정보 : 마케팅 프로모션 시 사용자 및 기기 구분, 맞춤형 광고 서비스\r\n"
				+ "마. 위치정보 : 위치기반서비스 이용약관에 명시된 목적과 부정이용 방지 목적\r\n"
				+ "\r\n"
				+ "※ 안내 : 위치기반서비스는 단말기의 설정을 변경함으로써 위치정보의 수집을 차단할 수 있습니다."
				+ "");
		taServiceData.setEditable(false);	// 수정 불가능
		taServiceData.setLineWrap(true);
		taServiceData.setFont(new Font("a소나무L", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(taServiceData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 25, 400, 525);
		
		sPanelCenterWhite.add(scrollPane);
		
		sPanelCenter.add(sPanelCenterWhite, BorderLayout.CENTER);
		add(sPanelCenter,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		DB.DBconnect(dbURL, dbID, dbPassword);
//		new Policy("개인정보처리방침", id);
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