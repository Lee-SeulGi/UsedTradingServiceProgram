package zKHB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;


public class S_MainListDB {
	
	
	private ResultSet rs;

	public ArrayList<S_MainListGAP> getUserList(){
		
		String maintf = S_MainFrame.tftext;
		
		ArrayList<S_MainListGAP> list = new ArrayList<S_MainListGAP>();
		
		String sql = "SELECT * from Post";
		String sqltf = "select * from Post where post_title like '%" + maintf + "%'";
	
		if(S_MainFrame.i == 0) {
			rs = DB.DBselect(sql);
		}else {
			rs = DB.DBselect(sqltf);
		}
		
		try {
			while(rs.next()) {
				String title = rs.getString("post_title");
				String price = rs.getString("post_price");
				String state = rs.getString("post_state");
				String term = rs.getString("post_term");
				String name = rs.getString("user_name");
				
				S_MainListGAP vo = new S_MainListGAP();
				
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setState(state);
				vo.setTerm(term);
				vo.setName(name);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println(e + "= > getUserList Fail");
		}
		return list;
	}
	
	
}
