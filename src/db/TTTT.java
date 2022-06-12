package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TTTT {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cjjdbc.Driver");//드라이브 띄우고 접속하기
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://포트번호는별도로넣어주세욥/powerrainzo","blue","1234");
			Statement stmt = conn.createStatement();//conn에 문장을 가져옴
			
//			Scanner sc = new Scanner(System.in);
//			System.out.print("아이디 입력: ");
//			String key = sc.nextLine();
			
			
			//String sql = "select * from tb where id = '"+ key + "'";//쿼리에 key값을 주어 검색!!!
			//select * from tb where id = 'a1' =>아이디가 a1인 애들만 뽑기
			
			//삽입 - 그런데 이렇게 하면 insert 할때마다
			//32-35은 민주씨의 꿀팁
//			String user_id = tfname.getText().ToString();
			String sqlInsert = 
					"insert into User "
							 + "values ('id', 'test10', '1111', '01012345678', '강원도')";
//					 + "values ('"+user_id+"', 'test10', '1111', '01012345678', '강원도')";
//			values('"++"','"++"','"++"','"++"','"++"')
					
			
			//수정
			//String sqlUpdate = "update User set user_residence = '?'";//where로 조건을 설정해서 수정해줌
			
			
			//삭제
//			String sqlDelete = "delete from User where residence = '강원도'";
			
			System.out.println(sqlInsert);
			stmt.executeUpdate(sqlInsert);
			
			int result = stmt.executeUpdate(sqlInsert);
			
			if(result == 1) {
				
			} else {
				
			}
			
			//select문으로 User 테이블 검색
			String sql = "select * FROM User";//쿼리에 key값을 주어 검색!!!
			
			System.out.println(sqlInsert);
			ResultSet rs = stmt.executeQuery(sql);
			
			//테이블 정렬
			System.out.println("==================================");
			//System.out.println("유저번호" + "\t" + "아이디" + "\t" + "이름"+ "\t" +"패스워드" + "\t" + "전화번호" + "\t" + "거주지");
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
	

