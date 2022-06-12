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

public class Service extends JFrame implements ActionListener {
	
	private JPanel sPanelNorth;
	private JPanel sPanelCenter;
	private JLabel lblServiceTitle;
	private JButton btnBack;
	private JPanel sPanelCenterWhite;
	private JTextArea taServiceData;
	private Mypage mypage;
	private String id;


	public Service(String title) {
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
		
		lblServiceTitle = new JLabel("서비스이용약관     "
				+ " ");
		lblServiceTitle.setFont(new Font("a소나무L", Font.BOLD, 24));
		lblServiceTitle.setHorizontalAlignment(JLabel.CENTER);
		lblServiceTitle.setPreferredSize(new Dimension(400, 39));
		
		ImageIcon iconBack = new ImageIcon("images/return.png");
		Image imgBack = iconBack.getImage();
		Image changeImgBack = imgBack.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon changeIconBack = new ImageIcon(changeImgBack);
		btnBack = new JButton(changeIconBack);
		btnBack.setPreferredSize(new Dimension(55, 37));
		
		// 버튼의 내용영역 채우기 사용 안함
		btnBack.setContentAreaFilled(false);
		// 버튼이 선택되었을때 생기는 테두리 사용 안함
		btnBack.setFocusPainted(false);
		// 버튼을 투명하게 설정
		btnBack.setOpaque(false);
		
		btnBack.addActionListener(this);
	
		
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
		
		taServiceData = new JTextArea("제1장 총칙\r\n"
				+ "\n제1조 (목적)\r\n"
				+ "본 약관은 서비스 이용자가 다이노마켓 주식회사(이하 “회사”라 합니다)가 제공하는 온라인 서비스 (이하 “서비스”라 합니다)에 회원으로 가입하고 이를 이용함에 있어 회사와 그 이용자의 권리⋅의무 및 책임 사항을 규정함을 목적으로 합니다."
				+ "\n\n제2조 (정의)\r\n"
				+ "본 약관에서 사용하는 용어의 정의는 다음과 같습니다. 정의되지 않은 본 약관상 용어의 의미는 일반적인 거래 관행에 의합니다.\r\n"
				+ "\r\n"
				+ "1. 회원: 본 약관에 동의하고 회사와 서비스 이용계약을 체결한 자를 말합니다.\r\n"
				+ "2. 판매자: 물품을 판매하기 위해 회사의 판매자 등록 절차를 완료한 회원(회사가 판매자로서 직접 판매하거나, 위탁판매서비스를 통해 특정 물품의 판매를 위탁 받아 판매하는 경우에는 회사)을 말합니다. 물품의 판매를 업(業)으로 하는 판매자(이하 “통신판매업자인 판매자”, 개인인지 법인인지 여부를 불문)인 경우와 그렇지 아니한 판매자 (이하 이 둘을 통칭하여 “판매자”)인 경우 판매자 등록 절차 및 다이노마켓 서비스 이용 시 적용되는 권리와 의무에 차이가 있을 수 있습니다.\r\n"
				+ "3. 위탁자: 위탁판매서비스를 통하여 회사에 위탁판매를 의뢰하는 자를 말합니다.\r\n"
				+ "4. 구매자: 판매자가 판매하는 물품을 구매하고자 하는 회원을 말합니다.\r\n"
				+ "5. 다이노페이: 구매자가 물품 구매를 위해 회사에 물품 대금을 결제할 수 있는 결제 시스템을 말합니다.\r\n"
				+ "6. 다이노톡: 서비스 내에서 회원들 간에 메시지 송수신할 수 있는 기능을 말합니다.\r\n"
				+ "7. 다이노페이거래: 회원이 다른 회원이 판매하는 물품을 구매하기 위하여 회사에 구매 청약의 접수를 하고 판매자와 구매 계약을 체결한 후 다이노페이를 통해 물품 대금을 지급하는 거래 형태를 말합니다.\r\n"
				+ "8. 다이노톡거래: 회원이 회사를 통하지 않고 회원간 다이노톡을 통해 메시지를 주고 받아 물품을 거래하는 형태를 말합니다.\r\n"
				+ "9. 다이노포인트: 회원의 누적 물품 구매 액수 또는 회사가 진행하는 이벤트 당첨 결과 등에 따라 회사가 회원에게 부여하고 회원이 적립하여 배송비 결제 등 회사가 지정하는 용도에 사용할 수 있는 혜택을 말합니다."
				+ "\n\n제3조 (약관의 게시와 개정)\r\n"
				+ "\r\n"
				+ "1. 회사는 본 약관의 내용을 회원이 쉽게 확인할 수 있도록 기술적 조치를 취합니다.\r\n"
				+ "2. 회사는 콘텐츠산업진흥법, 전자상거래 등에서의 소비자보호에 관한 법률, 약관의 규제에 관한 법률, 소비자기본법 등 관련 법령을 위반하지 않는 범위 내에서 본 약관을 개정할 수 있습니다.\r\n"
				+ "3. 회사가 약관을 개정할 경우 기존 약관과 개정 약관 및 개정 약관 적용 일자와 개정 사유를 명시하고 기존 약관과 함께 개정 약관 적용 일자 7일 전부터 적용 일자 이후 상당한 기간 동안, 개정 약관의 내용이 회원에게 불리한 경우 개정 약관 적용 일자 30일 전부터 적용 일 이후 상당한 기간 동안, 이를 서비스 웹페이지 및 어플리케이션 화면에 게시하거나 기타 방법으로 회원에게 통지합니다.\r\n"
				+ "4. 회사가 ‘전항에 따라 회원에게 통지한 후 개정 약관 고지일로부터 개정 약관 시행일 이후 7일이 지나는 날까지 회원이 거부 의사를 표시하지 아니할 경우 회원이 개정 약관에 동의한 것으로 본다는 뜻’을 고지하였음에도 회원의 거부 의사표시가 없는 경우 개정 약관에 동의한 것으로 간주합니다. 회원이 개정 약관에 동의하지 않을 경우 해당 회원은 서비스 이용 계약을 해지할 수 있습니다.\r\n"
				+ "5. 회원은 회사가 제공하는 서비스를 이용함에 있어서 전자상거래 등에서의 소비자보호에 관한 법률, 전자금융거래법, 소비자기본법, 표시∙광고의 공정화에 관한 법률, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 관련 법령을 준수하여야 하며, 본 약관의 규정을 들어 관련법령 위반에 대한 면책을 주장할 수 없습니다."
				+ "\n\n제2장 서비스의 내용 및 회원 가입\r\n"
				+ "\r\n"
				+ "제4조 (서비스 이용 계약)\r\n"
				+ "\r\n"
				+ "1. 회사가 제공하는 서비스를 이용하기 위한 이용 계약은 회사의 서비스를 이용하고자 하는 자의 회원가입 신청에 대하여 회사가 승낙함으로써 성립합니다.\r\n"
				+ "2. 전항의 회원가입 신청을 하기 위해서는 회사가 정한 온라인 회원가입 신청서에 필수 기재사항을 입력하고 본인인증 절차를 완료하여야 합니다.\r\n"
				+ "3. 회원가입 신청을 위해 필수적으로 기재한 항목이 변경된 경우(폐업 등의 사유 발생 포함) 해당 회원은 위 변경 사실을 직접 수정하거나 회사에 1:1문의 또는 전화를 통해 통지하여야 하며, 통지하지 않음으로 인하여 발생한 회원의 불이익에 관하여는 회원이 책임을 집니다.\r\n"
				+ "4. 회사가 정한 필수 기재사항을 입력하지 않거나 허위의 정보를 입력하거나 회원가입 신청을 하려는 자가 만 14세 미만일 경우 회원가입 신청이 제한될 수 있습니다.\r\n"
				+ "5. 회사는 회원에게 유익한 정보를 제공하기 위해 위 필수 기재사항 이외에도 회원가입을 신청하는 자에게 취미, 관심사 등 정보 제공을 요청할 수 있으나 회원가입을 신청하는 자는 위 정보의 제공을 거절할 수 있습니다.\r\n"
				+ "6. 회사는 회사의 서비스를 이용하기 위해 회원가입 신청을 한 자가 본조 제2.항에서 정한 필수 기재사항을 정확하게 입력하고 본 약관에 동의한 경우 원칙적으로 서비스의 이용을 승낙합니다. 다만, 회사는 다음과 같은 사유가 있는 경우 회원가입 신청의 승낙을 거절 또는 보류할 수 있고, 이 경우 회사는 승낙 거절 또는 보류의 사유와 승낙에 필요한 추가 요청 정보 등 관련 사항을 통지합니다.\r\n"
				+ "\r\n"
				+ "- 회사의 설비에 여유가 없는 경우\r\n"
				+ "- 회사의 서비스 제공에 기술적인 문제가 있는 경우\r\n"
				+ "- 가입 신청자가 본 약관에 따라 회원 자격을 상실하거나 이용 계약이 해지된 적이 있는 경우 (단, 회사의 회원 재가입 승낙을 얻은 경우는 예외)\r\n"
				+ "- 타인의 명의를 도용한 경우\r\n"
				+ "- 허위의 정보를 기재한 경우\r\n"
				+ "- 기타 회사의 합리적인 판단 하에 필요하다고 인정하는 경우"
				+ "\n\n제5조 (판매자 등록)\r\n"
				+ "\r\n"
				+ "1. 제4조에 따라 회사로부터 회원가입 신청을 승낙 받아 이용 계약이 성립된 회원이 회사의 서비스를 이용하여 다른 회원에게 물품을 판매하고자 할 경우 판매자 등록 절차를 거쳐야 합니다.\r\n"
				+ "2. 판매자 등록을 하기 위해서는 회사가 정한 온라인 등록 신청서에 다음의 필수 기재사항을 입력하여야 하며, 업자인 판매자의 다음 각 호의 정보는 회원에게 공개됩니다.\r\n"
				+ "\r\n"
				+ "- 상호\r\n"
				+ "- 이름(법인인 경우 대표자 성명)\r\n"
				+ "- 주소\r\n"
				+ "- 전화번호\r\n"
				+ "- 이메일주소\r\n"
				+ "- 사업자등록번호\r\n"
				+ "- 통신판매업신고 번호\r\n"
				+ "\r\n"
				+ "3. 통신판매업자가 아닌 판매자가 서비스 이용을 위해 입력하여 제공한 신원정보는 판매자의 물품에 대한 구매 청약을 한 구매자의 요청에 따라 해당 구매자에게 제공될 수 있습니다."
				+ "\r"
				+ "\n\n제6조 (서비스의 제공)\r\n"
				+ "\r\n"
				+ "1. 회사가 제공하는 서비스의 종류는 아래와 같습니다.\r\n"
				+ "- 가. 거래중개서비스 : 회사가 제공하는 웹사이트 또는 어플리케이션을 통하여 회원 상호간에 물품 거래가 이루어질 수 있는 사이버 거래 장소의 제공\r\n"
				+ "- 나. 위탁판매서비스 : 특정 회원이 소유하는 물품의 판매를 회사에 위탁하여 회사가 해당 물품을 판매하고, 해당 물품이 판매되는 경우 수수료 공제 후 그 판매금액을 회원에게 지급하는 서비스\r\n"
				+ "- 다. 정품 검수 서비스 : 특정 물품에 대하여 판매자 및 구매자가 해당 서비스 이용에 동의할 경우에 회사가 구매자에게 발송되기 전에 해당 물품의 정품 여부를 검수하는 서비스\r\n"
				+ "- 라. 슈클린 서비스 : 스니커즈 제품에 대하여 구매자의 신청 및 판매자의 수락 또는 위탁자의 스니커즈 판매 위탁이 있는 경우 회사가 해당 스니커즈 제품을 세탁하는 서비스\r\n"
				+ "- 마. 유료서비스 : 광고 서비스: 회원이 회사에 광고 수수료를 지급하고 판매하는 물품 등을 다른 회원에게 광고할 수 있는 서비스, 다이노페이 서비스: 회원 상호간 물품 거래가 다이노페이거래로 이루어질 경우 구매자의 청약, 계약 체결 및 물품 대금 정산을 위해 필요한 부수적인 서비스 일체, 배송 서비스: 회사가 제3자와 업무 제휴를 통해 제공하는 통합 택배 서비스\r\n"
				+ "- 바. 기타 부가서비스 : 다이노톡 서비스: 회원 상호간 메시지를 주고 받을 수 있는 다이노톡 메신저 서비스, 거래 활성화를 위한 부수적인 서비스: 거래 후기 작성, 찜 기능 등 회원의 서비스 이용을 돕는 부수적인 서비스, 다이노포인트: 회사가 회원의 누적 물품 구매 액수 또는 회사가 진행하는 이벤트 당첨 결과 등에 따라 회원에게 서비스 내에서 사용할 수 있는 포인트를 부여하여 회원이 포인트를 회사가 지정하는 용도로 현금 대신 사용할 수 있는 서비스\r\n"
				+ "\r\n"
				+ "2. 회사는 연중무휴, 24시간 서비스를 제공함을 원칙으로 하되, 컴퓨터 등 정보통신설비의 보수, 점검, 교체, 고장 등 운영상 상당한 이유가 있는 경우 회원에게 통지한 후 서비스의 제공을 일시적으로 중단할 수 있습니다. 다만, 회사가 사전에 서비스의 중단을 통지할 수 없었던 부득이한 사유가 있는 경우 사후에 통지할 수 있습니다.\r\n"
				+ "3. 회사는 서비스의 제공을 위한 별도의 계약 종료, 신규 서비스 개시, 기존 서비스 개정 등의 사유로 서비스의 내용을 변경할 수 있습니다.\r\n"
				+ "4. 회사는 서비스의 내용에 변경이 있는 경우 변경된 서비스가 적용되기 30일 이전부터 적용 일자 이후 상당한 기간까지 웹사이트 및 어플리케이션 공지사항을 통해 회원들에게 변경된 서비스의 내용을 사전 공지합니다. 다만 회원의 거래와 관련하여 중대한 영향을 미치는 변경 사항이 있는 경우 회원에게 별도로 통지합니다."
				+ "\n"
				+ "\n위 약관은 2022년 05월 30일부터 시행합니다.");
		taServiceData.setLineWrap(true);
		taServiceData.setEditable(false);	// 수정 불가능
		taServiceData.setFont(new Font("a소나무L", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(taServiceData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(24, 25, 400, 525);
		
		sPanelCenterWhite.add(scrollPane);
		
		sPanelCenter.add(sPanelCenterWhite, BorderLayout.CENTER);
		add(sPanelCenter,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		new Service("서비스이용약관");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnBack) {
		mypage = new Mypage("마이페이지", id);
		setVisible(false);
		
	}
	}
	
}
