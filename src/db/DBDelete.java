package db;
//탈퇴하기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DBDelete {
	private static Connection conn;
	private static Statement stmt;
	//private static int rs;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//드라이브 띄우고 접속하기
		
			conn = DriverManager.getConnection("jdbc:mysql://포트번호는별도로넣어주세욥/powerrainzo","blue","1234");
			stmt = conn.createStatement();//conn에 문장을 가져옴
			//특정 아이디 회원 삭제하기
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 입력: ");
			String key = sc.nextLine();
			
			//삭제 : Delete from 테이블 where 조건
			//String deletesql = "Delete from User where User_id = '"+key+"'";//쿼리에 key값을 주어 검색!!!
			String deletesql = "delete from User where user_id = '"+key+"'";;
			System.out.println(deletesql);
			stmt.executeUpdate(deletesql);

			String selectsql = "select * FROM User"; //쿼리에 key값을 주어 검색!!!
			System.out.println(selectsql);
			ResultSet rs = stmt.executeQuery(selectsql);
			
			
			System.out.println("==================================");
			System.out.println("번호" + "\t" +"아이디" + "\t" + "이름" +"\t" + "패스워드" + "\t" + "폰번호" + "\t" + "거주지");
			System.out.println("----------------------------------");
		
			while(rs.next()) {
				int no = rs.getInt("user_no");
				String id = rs.getString("user_id");//직접 coloum명을 적어주는게 더 좋음
				String name = rs.getString("user_name");//직접 coloum명을 적어주는게 더 좋음
				String pw = rs.getString("user_pw");//데이터베이스의 인덱스는 0이 아니라 1번부터 돌아간다
				String phonenum = rs.getString("user_phonenum");
				String residence = rs.getString("user_residence");
				System.out.println(no + "\t" + id+ "\t" + name + "\t" +pw + "\t" + phonenum + "\t" + residence);
			}
			System.out.println("==================================");
		
			System.out.println("OK!");
		} catch (ClassNotFoundException e) {
			System.out.println("예외 발생 : 해당 드라이버가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("예외 발생 : 접속 정보 확인이 필요합니다.");
			e.printStackTrace();
		}
	  }
	
	
}
