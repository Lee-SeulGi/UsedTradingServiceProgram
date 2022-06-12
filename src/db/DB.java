package db;
//힝구
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

private static Connection conn;
private static Statement stmt;
private static ResultSet rs;

static String dbURL="jdbc:mysql://49.50.174.207/powerrainzo";
static String dbID="blue";
static String dbPassword="1234";

//여기에 메소드 다 때려박으세요
//static으로 선언한 이유 설명할 수 없으면 static으로 하지 말 것
public static void DBconnect(String dbURL,String dbID,String dbPassword) {
	try {
		// Database 연결
		Class.forName("com.mysql.cj.jdbc.Driver");	// 드라이버 로드
		conn = DriverManager.getConnection(dbURL, dbID, dbPassword);//DB랑 연결
		stmt = conn.createStatement();
		System.out.println("데이터베이스 연결 성공!");
		
		// 쿼리 수행을 위한 Statement 객체 생성
		
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("에러");
		e.printStackTrace();
	}
}




	public static void closeDB() {
		try {
			stmt.close();
			conn.close();
			System.out.println("데이터베이스 연결 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	// SELECT
		//
		public static ResultSet DBselect(String sql) {
			// 쿼리 수행
			
			ResultSet rs = null ;
			
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		
		
		
		
		// INSERT
		//
		public static int DBinsert(String sql) {
			int rs = 0;
					
			try {
				rs = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		
		
		
		
		// UPDATE
		//
		public static int DBupdate(String sql) {
			int rs = 0;
					
			try {
				rs = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		
		
		
		
		// DELETE
		//
		public static int DBdelete(String sql) {
			// 쿼리 수행
			int rs = 0;
					
			try {
				rs = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		
		
		
		
		public static void main(String[] args) {
			
			DBconnect(dbURL, dbID, dbPassword);
			ResultSet rs = DB.DBselect("select * from User");
			
		}
	
}